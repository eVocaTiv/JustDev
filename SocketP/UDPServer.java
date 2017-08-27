import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;


public class UDPServer {
	public static void main (String [] args){
		DatagramSocket socket = null;
		try{
			//CREATE DATAGRAMSOCKET.
			socket = new DatagramSocket (1111);
			
			
			//CREATE PACKET BUFFER.
			byte[] buffer = new byte[1000];
			
			//RECEIVE DATA FROM CLIENT.
			
			while(true){
				//REQUEST A DATAGRAM PACKET.
				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
				//RECEIVE THE PACKET.
				socket.receive(request);
				//GENERATE REPLY.
				DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength() , request.getAddress() , request.getPort());
				socket.send(reply);
			}
			
		
		}
		
		catch (Exception e ){
			
		}
	
		finally{
			if(socket!=null)
			socket.close();
		}
	}
}
