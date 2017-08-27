import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args){
		System.out.println("Connected to the server");
		try{
			ServerSocket ss = new ServerSocket(1235);
			Socket s1 = ss.accept();
		//	System.out.println();
			System.out.println("Connected to the server");
			OutputStream os = s1.getOutputStream();
			InputStream  is = s1.getInputStream();
			DataInputStream dis =new DataInputStream(is);
			
			DataOutputStream dos = new DataOutputStream(os);
			dos.writeUTF("Hello there!");
			
			
			System.out.println(dis.readUTF());
			
			
			dos.close();
			os.close();
			s1.close();
			ss.close();
			
			
		}
		
		catch(Exception e){
			
		}
	}
}
