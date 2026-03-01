package lt.viko.eif.dalencinovic.first.spring.network;

import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void startServer(String filePath)throws Exception{
        ServerSocket serverSocket = new ServerSocket(8085);
        System.out.println("Server started...");

        Socket socket = serverSocket.accept();

        FileInputStream fileInputStream= new FileInputStream(filePath);
        OutputStream outputStream = socket.getOutputStream();

        fileInputStream.transferTo(outputStream);

        fileInputStream.close();
        socket.close();
        serverSocket.close();
    }
}
