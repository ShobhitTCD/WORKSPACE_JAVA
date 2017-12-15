package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
	Socket socket;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			String message = null;
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    while((message = buffReader.readLine()) != null) {
		    	message = buffReader.readLine();
		    	System.out.println("incomming client message is   " + message);
		    }socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

