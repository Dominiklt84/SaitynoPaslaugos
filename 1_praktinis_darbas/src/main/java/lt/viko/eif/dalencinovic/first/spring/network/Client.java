package lt.viko.eif.dalencinovic.first.spring.network;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void startClient(String savePath)throws Exception{
        Socket socket = new Socket("localhost",8085);

        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(savePath);

        inputStream.transferTo(fileOutputStream);

        fileOutputStream.close();
        socket.close();
        System.out.println("File received.");
    }
}
