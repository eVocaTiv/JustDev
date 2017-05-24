import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	public static final int PORT = 490;

	public static void main(String[] args) throws IOException{
		new Server().runServer();	

	}

	public void runServer() throws IOException{
		ServerSocket ss = new ServerSocket(PORT);
		System.out.println("Server Started...");

		//int count=0;
		//while(count++<10){
		Socket s1 = ss.accept();


		new ServerThread(s1).start();
	}


	public class ServerThread extends Thread {
		Socket socket;

		ServerThread(Socket socket){
			this.socket = socket;
		}

		public void run(){
			String ip =null;


			//}
			Scanner sc;
			try {
				sc = new Scanner(socket.getInputStream());

				ip = sc.nextLine();

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("ServerThread running right now ");



			PrintStream p;
			try {
				p = new PrintStream (socket.getOutputStream());
				p.println("from Server " + ip);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}





		} 





	}

}
