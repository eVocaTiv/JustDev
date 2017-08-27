
import java.net.*;


public class UDPClient {

	public static void main(String[] args){
		DatagramSocket mysocket = null;
		try{
			//CREATE DATAGRAM SOCKET.
			mysocket = new DatagramSocket();
		
		//CREATE PACKET TO SEND WITH ALL THE PARAMETERS.
			
			//1  --  CREATE DATA BUFFER FOR PACKET TO SEND.
			byte [] message = new byte[3];
			for(int i=0 ; i<3 ; i++){
				message[i] = (byte) i;
			}
			
			//2 --  GET IP ADDRESS AND PORT OF THE DESTINATION HOST.
			InetAddress hostAddress = InetAddress.getByName("127.0.0.1");
			
			//3 --  GET PORT
			
			
			
			//GENERATE PACKET
	        DatagramPacket request = 
	                new DatagramPacket(message ,message.length	, hostAddress, 1111);
		
	        mysocket.send(request);
	        
	        //CREATE BUFFER TO RECEIVE THE REPLY PACKET.
	        byte[] buffer = new byte[1000];
	        
	        //CREATE PACKET TO BE RECIEVED.
	        DatagramPacket gotreply = new DatagramPacket(buffer, buffer.length);
	        
	        //RECEIVE THE REPLY FROM UDPSERVER .
	        mysocket.receive(gotreply);
	        
	        for(int i=0 ; i<5 ; i++)
	        System.out.print(buffer[i] + " ");
	        
	        
	        System.out.println();
	        
	        for(int i=0 ; i<5 ; i++)
	        System.out.print(message[i] + " ");	
	        
		}

		catch(Exception e){

		}
		
		finally{
			if(mysocket!=null)
				mysocket.close();
		}
	}
}
