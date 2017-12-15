package test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	public static final int PORT = 4444;
    public static void main(String args[]) {
		new Server().runServer();
	}
   
   public void runServer() {
	   try {
		ServerSocket serversocket = new ServerSocket(PORT);
		System.out.println("server up and ready ");
		while(true) {
			Socket s =	serversocket.accept();
			new ServerThread(s).start();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
   }
}
