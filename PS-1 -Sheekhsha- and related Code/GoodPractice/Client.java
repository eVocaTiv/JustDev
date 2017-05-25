import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
	 
		Scanner systemsc = new Scanner(System.in);
		Socket socket = new Socket("localhost" , 1001);
		Scanner fromserver = new Scanner(socket.getInputStream());
		
	
		//GET INPUT FROM SYSTEM.
		System.out.println("PLease enter any desired number");
		int number = systemsc.nextInt();
		
		//SEND THE INPUT TO THE SERVER.
		PrintStream p = new PrintStream(socket.getOutputStream());
		p.println(number);
		
		
		//DISPLAY THE RESPONSE FROM THE SERVER.
		String response = fromserver.nextLine();
		System.out.println(response);
		
		
	}
	
	
}
