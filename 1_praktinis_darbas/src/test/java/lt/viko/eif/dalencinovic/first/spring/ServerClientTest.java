package lt.viko.eif.dalencinovic.first.spring;

import lt.viko.eif.dalencinovic.first.spring.network.Client;
import lt.viko.eif.dalencinovic.first.spring.network.Server;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration test for Server and Client communication.
 */
class ServerClientTest {

    @Test
    void testServerClientFileTransfer() throws Exception {

        // Create temporary source XML file
        File sourceFile = File.createTempFile("source", ".xml");
        sourceFile.deleteOnExit();

        String testContent = "<test>hello</test>";
        Files.writeString(sourceFile.toPath(), testContent);

        // Create destination file
        File receivedFile = File.createTempFile("received", ".xml");
        receivedFile.deleteOnExit();

        // Start server in separate thread
        Thread serverThread = new Thread(() ->
                Server.startServer(sourceFile.getAbsolutePath())
        );
        serverThread.start();

        // Give server time to start
        Thread.sleep(500);

        // Start client
        Client.startClient(receivedFile.getAbsolutePath());

        // Wait for server to finish
        serverThread.join();

        // Validate file content
        assertTrue(receivedFile.exists());

        String receivedContent = Files.readString(receivedFile.toPath());
        assertEquals(testContent, receivedContent);
    }
}