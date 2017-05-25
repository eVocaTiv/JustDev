import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
	private final static int PORT = 1001;
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		Scanner systemsc = new Scanner(System.in);
		ServerSocket ss = new ServerSocket(1001);
		Socket socket = ss.accept();
		Scanner fromclient = new Scanner(socket.getInputStream());
		
		//RECEIVE THE DATA FROM THE CLIENT.
		int gotdata = fromclient.nextInt();
		
		//GENERATE THE RESPONSE.
		int response = gotdata + 1;
		
		
		//SEND THE RESPONSE.
		PrintStream p = new PrintStream(socket.getOutputStream());
		p.println("Server Generated response... " + response);
		
	}
}
