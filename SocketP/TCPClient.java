import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Client {
	public static void main(String [] args){

		try{
			Socket socket = new Socket("localhost", 1235);

			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			
			
			//String s = dis.readLine();
			
			System.out.println("hello");
			//dos.writeUTF("Hello from the client side!");
			System.out.println(dis.readUTF());
			dos.close();
			dis.close();
			os.close();
			is.close();
			socket.close();
			

		}


		catch(Exception e){

		}
	}
}
