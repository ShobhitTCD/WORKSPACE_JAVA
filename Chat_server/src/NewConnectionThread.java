import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;


/*
 * we have created this class to create a new thread for every client connection
 */
public class NewConnectionThread extends Thread{
	
	private Socket socket;
	
	public NewConnectionThread(Socket socket) {
		this.socket = socket;
	}
	@Override
	public void run() {
		try {
			handleClientSocket();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private  void handleClientSocket() throws IOException, InterruptedException {
		InputStream inputStream = socket.getInputStream();
		
		OutputStream outputstream = socket.getOutputStream();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		String line;
		while(bufferedReader.readLine() != null) {
			if(bufferedReader.readLine() == "quit") {
				socket.close();
			}else {
				String mssgSendToUser = "Message Send to user " + bufferedReader.readLine() +"\n";
				outputstream.write(mssgSendToUser.getBytes() );
			}
		}
		
		
	}
}
