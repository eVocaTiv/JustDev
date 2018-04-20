import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parser{
	public static void main(String[] args) throws FileNotFoundException{
		String cdir = System.getProperty("user.dir");
		System.out.println(cdir);
		File file = new File("/home/user/Desktop/lab9/lab9.nam");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
		int throughput = 0;	
		int packetsGenbySource2to4=0;
		int packetsRecby42to4=0;
		int packetsGenbySource4to6=0;
		int packetsRecby44to6=0;
		int bw24=0;
		int bw46=0;
		int bw68=0;
		int packetsGenbySource6to8=0;
		int packetsRecby46to8=0;
		

		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] linestr = line.split(" ");

			if(linestr[2].compareTo("2.0")>=0 && linestr[2].compareTo("4.0")<0 )
				bw24++;


			if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("cbr")) && 
					linestr[6].contentEquals("4"))			{
				if(linestr[2].compareTo("2.0")>=0 && linestr[2].compareTo("4.0")<0)
					packetsRecby42to4++;
			}
			if(linestr[0].contentEquals("+") && (linestr[8].contentEquals("cbr")) && 
					linestr[4].contentEquals("6"))			{
				if(linestr[2].compareTo("2.0")>=0 && linestr[2].compareTo("4.0")<0)
					packetsGenbySource2to4++;
			}
			
			//b/w 4 and 6.
			

			if(linestr[2].compareTo("4.0")>=0 && linestr[2].compareTo("6.0")<0 )
				bw46++;


			if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("cbr")) && 
					linestr[6].contentEquals("4"))			{
				if(linestr[2].compareTo("4.0")>=0 && linestr[2].compareTo("6.0")<0)
					packetsRecby44to6++;
			}
			if(linestr[0].contentEquals("+") && (linestr[8].contentEquals("cbr")) && 
					linestr[4].contentEquals("6"))			{
				if(linestr[2].compareTo("4.0")>=0 && linestr[2].compareTo("6.0")<0)
					packetsGenbySource4to6++;
			}
			
		
		}
		//System.out.println("Total b/w 2 and 4 : " + bw24);
		//System.out.println("Received  b/w 2 and 4: " + packetsRecby42to4);
		//System.out.println("Generated  b/w 2 and 4: " + packetsGenbySource2to4);
		System.out.println("Total PDR b/w 2 and 4: "+ (double)packetsRecby42to4/packetsGenbySource2to4);
		
		//System.out.println("Total b/w 4 and 6 : " + bw46);
		//System.out.println("Received  b/w 4 and 6: " + packetsRecby44to6);
		//System.out.println("Generated  b/w 4 and 6: " + packetsGenbySource4to6);
		System.out.println("Total PDR b/w 4 and 6: "+ (double)packetsRecby44to6/packetsGenbySource4to6);
		
		//System.out.println("Total b/w 6 and 8 : " + bw68);
		//System.out.println("Received  b/w 6 and 8: " + packetsRecby46to8);
		//System.out.println("Generated  b/w 6 and 8: " + packetsGenbySource6to8);
		//System.out.println("Total PDR b/w 6 and 8: "+ (double)packetsRecby46to8/packetsGenbySource6to8);
		
		sc.close();
	}



}
