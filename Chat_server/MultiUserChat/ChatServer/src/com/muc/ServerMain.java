package com.muc;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by jim on 4/18/17.
 */
public class ServerMain {
    public static void main(String[] args) {
        int port = 8818;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true) {
                System.out.println("About to accept client connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket);
                OutputStream outputstream = clientSocket.getOutputStream();
                outputstream.write("Helllo World".getBytes());
                clientSocket.close;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
