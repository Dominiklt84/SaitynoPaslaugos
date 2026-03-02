package lt.viko.eif.dalencinovic.first.spring.network;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple TCP server that sends XML file to client.
 */
public class Server {
    private static final int PORT = 8085;

    /**
     * Starts TCP server and sends specified file
     * to first connected client.
     *
     * @param filePath path to XML file
     */
    public static void startServer(String filePath){
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started on port " + PORT);
            System.out.println("Waiting for client connection...");

            try (Socket socket= serverSocket.accept();
                 FileInputStream fileInputStream = new FileInputStream(filePath);
                 OutputStream outputStream=socket.getOutputStream()){

                fileInputStream.transferTo(outputStream);
                outputStream.flush();

                System.out.println("File sent successfully.");
            }
        }catch (Exception e){
            throw new RuntimeException("Server failed to send file", e);
        }
    }
}
