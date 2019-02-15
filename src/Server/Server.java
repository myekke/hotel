package Server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(1789);
        System.out.println("waiting for client");
        Socket socket = serverSocket.accept();
        System.out.println("Connected");
        InputStream inputStream = socket.getInputStream();
        String finaltext = "";
        int ASCII = inputStream.read();
        while (ASCII != -1) {
            finaltext = finaltext.concat(String.valueOf((char) ASCII));
            ASCII = inputStream.read();
        }
        inputStream.close();
        System.out.println(finaltext);
        System.out.println("Client: message recieved!");

    }
}
