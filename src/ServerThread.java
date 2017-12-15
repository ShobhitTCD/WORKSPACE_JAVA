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
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println("user " + buffReader.readLine() + "is now connected to the server" );
		    while((message = buffReader.readLine()) != null) {
		    	System.out.println("incomming client message is   " + message);
		    	printWriter.println(" response from server or other user " + message);
		    }socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
