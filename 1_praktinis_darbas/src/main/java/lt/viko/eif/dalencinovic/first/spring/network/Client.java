package lt.viko.eif.dalencinovic.first.spring.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Simple TCP client that receives XML file from server.
 */
public class Client {
    private static final String HOST= "localhost";
    private static final int PORT = 8085;

    /**
     * Connects to server and receives XML file.
     *
     * @param savePath path where received file will be saved
     */
    public static void startClient(String savePath){
        try (Socket socket=new Socket(HOST, PORT)){
            InputStream inputStream = socket.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream(savePath);

            inputStream.transferTo(fileOutputStream);

            System.out.println("File received successfully.");
        }catch (Exception e){
            throw new RuntimeException("Client failed to receive file", e);
        }
    }
}
