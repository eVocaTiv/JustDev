import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{

		String clientname = String.valueOf(Math.random());
		Socket socket = new Socket("127.0.0.1" , 490);

		//	PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		//BufferedReader b = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		Scanner sc = new Scanner(System.in);
		Scanner b = new Scanner(socket.getInputStream());
		
		System.out.println("please enter your message");
		String message = sc.nextLine();
		
		PrintStream p = new PrintStream(socket.getOutputStream());
		
		//int count=0;
		//while(count++<10){
		p.println("Final string : " +  message);
		
		String todisplay = b.nextLine();
		System.out.println(todisplay);	
		//	}

		//System.out.println("Client " + clientname + " Sent message to Server + " + readerInput);	
	}
}
