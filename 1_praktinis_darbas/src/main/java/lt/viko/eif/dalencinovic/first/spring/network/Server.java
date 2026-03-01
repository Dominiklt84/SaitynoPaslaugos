package lt.viko.eif.dalencinovic.first.spring.network;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Simple TCP server that sends XML file to client.
 */
public class Server {
    private static final int PORT = 8085;

    /**
     * Starts server and sends XML file to connected client.
     *
     * @param filePath path of XML file to send
     */
    public static void startServer(String filePath){
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started on port " + PORT);
            try (Socket socket= serverSocket.accept();
                 FileInputStream fileInputStream = new FileInputStream(filePath);
                 OutputStream outputStream=socket.getOutputStream()){

                fileInputStream.transferTo(outputStream);

                System.out.println("File sent successfully.");
            }
        }catch (Exception e){
            throw new RuntimeException("Server failed to send file", e);
        }
    }
}
