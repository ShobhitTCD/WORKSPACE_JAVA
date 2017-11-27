

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerMain {
    public static void main(String[] args) {
        int port = 8818;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true) {
                System.out.println("About to accept client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                NewConnectionThread newClientConnection = new NewConnectionThread(clientSocket);
                newClientConnection.start(); // we are creating a new thread for the new connection so that the connection is not interrupted
                
              }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
