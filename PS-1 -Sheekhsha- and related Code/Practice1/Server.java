import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException{
		
		//CREATE SERVER SOCKET OBJECT.
		ServerSocket ss = new ServerSocket(1355);
	
		//CREATE SOCKET OBJECT TO INTERACT WITH THE CLIENT.
		Socket ns1 = ss.accept();
		
		//ACCEPT THE INPUT FROM THE CLIENT
		Scanner sc = new Scanner(ns1.getInputStream());
		int number = sc.nextInt();
		int temp = number*2;
		String op = "ServerClient model successfully working";
		
		//NOW TO PASS BACK THE INFO TO THE CLIENT TO BE PRINTED.
		 
		PrintStream p = new PrintStream(ns1.getOutputStream());
		p.println(op);
		
		
		
	}

}
