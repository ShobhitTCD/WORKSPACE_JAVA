import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.eclipse.jgit.api.Git;


public class Server {
	public static final int PORT = 4444;
    public static void main(String args[]) throws IOException {
    	
    	
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
