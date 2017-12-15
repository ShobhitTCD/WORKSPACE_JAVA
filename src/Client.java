import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		String name = args[0];
		Socket socket = new Socket("localhost", 4444);
		BufferedReader bufferedReaderFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
		printWriter.println(name);
		BufferedReader bufferedReaderFromCommandPrompt = new java.io.BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String readerInput = bufferedReaderFromCommandPrompt.readLine();
			printWriter.println(name + ":" + readerInput);
			System.out.println(bufferedReaderFromClient.readLine());
		}
		
	}

}
