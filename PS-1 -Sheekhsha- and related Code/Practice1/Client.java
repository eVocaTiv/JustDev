import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		
		Scanner s1 = new Scanner(System.in);
		//Format of Socket
		//Socket s = new Socket("Ip Address" , "Port no.")
		
		Socket st = new Socket("127.0.0.1" , 1355);
		Scanner s2 = new Scanner(st.getInputStream());
		
		System.out.println("Please enter a number");
		int number = s1.nextInt();
		
		PrintStream p = new PrintStream(st.getOutputStream());
		p.println(number);
		
		//int temp = s2.nextInt();
		String todisplay = s2.nextLine();
		System.out.println(todisplay);		
		
	}

}
