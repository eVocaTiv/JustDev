import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parser{
	public static void main(String[] args) throws FileNotFoundException{
		String cdir = System.getProperty("user.dir");
		System.out.println(cdir);
		File file = new File("/home/user/Desktop/prac/q1/out.nam");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
		
		int throughput = 0;	
		int sent = 0;
		int recd = 0;
		int total = 0;
		int pid = Integer.parseInt(args[0]);
		double t1=0;
		double t2=0;
		int p=0;
		
		
		

		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] linestr = line.split(" ");



				//CALCULATE NUMBER OF PACKETS SENT BETWEEN 1 AND 2.
			
				if(linestr[0].contentEquals("-") && linestr[8].contentEquals("cbr")){
						double time = Double.parseDouble(linestr[2]);
						if(time > 1.0 && time < 2.0)
						p++;
					}


				//CALCULATE TIME TAKEN BY PACKET WITH ID = 0.
				if(linestr[0].contentEquals("-") && (linestr[8].contentEquals("cbr")) && 
					linestr[14].compareTo(Integer.toString(pid))==0 ) {
					
						t1=Double.parseDouble(linestr[2]);
					}
					
					if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("cbr")) && 
				linestr[14].compareTo(Integer.toString(pid))==0){
					
					 	t2=Double.parseDouble(linestr[2]);
					 	
					}
					
		

			//received at 1.
			
			if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("cbr")) && 
					linestr[6].contentEquals("1")){
					
						recd++;
					}
			
			
			//sent to 1
			if(linestr[0].contentEquals("+") && (linestr[8].contentEquals("cbr")) && 
					linestr[6].contentEquals("1")){
					
						sent++;
					}
			
			if(linestr[0].contentEquals("+") && (linestr[8].contentEquals("cbr")) && 
					 
					linestr[2].compareTo("0.5")>0 && linestr[2].compareTo("4.5")<0 ){
					
						total++;
					}
			
			
			
		
		}
		//System.out.println("Throughput : " + throughput);
		System.out.println("SENT : " + sent);
		System.out.println("RECEIVED : " + recd);
		System.out.println("PDR : " + (double)recd/sent);
		System.out.println("TOTAL DATA PACKETS : " + total);
		double t = t2-t1;
		System.out.println("Packet sent at : " + t1 );
		System.out.println("Packet recd at : " + t2 );

		System.out.println("Packet : " + pid + " took time : " + t);
		System.out.println("Packets between 1 and 2 : " + p);
		
		sc.close();
		
	}
}
