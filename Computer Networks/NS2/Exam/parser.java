import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parser{
	
	public static void main(String[] args) throws FileNotFoundException{
		String cdir = System.getProperty("user.dir");
		System.out.println(cdir);

		File file = new File("/home/user/prac/TCP.tr");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
		int x =0;
		double throughput1 = 0;	
		long sent =0;
		long recd1 = 0;
		int dropped = 0;
		int dq = 0;
		double PDR = 0;
		int[] recd2 = new int[15];
		int[] recd3 = new int[15];

		int[] recd5 = new int[15];
		int[] recd6 = new int[15];
		int[] recd7 = new int[15];


		while(sc.hasNext()){
			//System.out.println("yes");
			String line = sc.nextLine();
			String[] str = line.split(" ");
				

			if(str[0].contentEquals("r") && str[4].contentEquals("tcp") 
					&& str[3].contentEquals("5"))
				recd1++;

			double time = Double.parseDouble(str[1]);
			if(time >= 0.0 && time <=2.0){



				//			if(str[0].contentEquals("+") && str[4].contentEquals("tcp"))
				//				sent++;
				//			if(str[0].contentEquals("-") && str[4].contentEquals("tcp"))
				//				dq++;
				//			if(str[0].contentEquals("d") && str[4].contentEquals("tcp"))
				//				dropped++;
				//			
				//			PDR = (double)recd/sent;



			}

			if(time >=2.0 && time <=5.0){

				//2.-------------------------------------------
				//15 rows for node 5.
				if(time>=2.0 && time <=2.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[0]++;

					}
				if(time>=2.2 && time <=2.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[1]++;
					}
				if(time>=2.4 && time <=2.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[2]++;
					}
				if(time>=2.6 && time <=2.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[3]++;
					}
				if(time>=2.8 && time <=3.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[4]++;
					}

				//---

				if(time>=3.0 && time <=3.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[5]++;
					}
				if(time>=3.2 && time <=3.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[6]++;
					}
				if(time>=3.4 && time <=3.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[7]++;
					}
				if(time>=3.6 && time <=3.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[8]++;
					}
				if(time>=3.8 && time <=4.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[9]++;
					}
				///----


				if(time>=4.0 && time <=4.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[10]++;
					}
				if(time>=4.2 && time <=4.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[11]++;
					}
				if(time>=4.4 && time <=4.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[12]++;
					}
				if(time>=4.6 && time <=4.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[13]++;
					}
				if(time>=4.8 && time <=5.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd2[14]++;
					}

				////---------now calculcate for 6


				//15 rows for node 6.
				if(time>=2.0 && time <=2.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[0]++;
					}
				if(time>=2.2 && time <=2.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[1]++;
					}
				if(time>=2.4 && time <=2.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[2]++;
					}
				if(time>=2.6 && time <=2.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[3]++;
					}
				if(time>=2.8 && time <=3.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[4]++;
					}

				//---

				if(time>=3.0 && time <=3.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[5]++;
					}
				if(time>=3.2 && time <=3.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[6]++;
					}
				if(time>=3.4 && time <=3.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[7]++;
					}
				if(time>=3.6 && time <=3.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[8]++;
					}
				if(time>=3.8 && time <=4.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[9]++;
					}
				///----


				if(time>=4.0 && time <=4.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[10]++;
					}
				if(time>=4.2 && time <=4.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[11]++;
					}
				if(time>=4.4 && time <=4.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[12]++;
					}
				if(time>=4.6 && time <=4.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[13]++;
					}
				if(time>=4.8 && time <=5.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd3[14]++;
					}

			}
			//-------calc for 6 done.
			//2. ended

			if(time >=7.0 && time <=9.0){
				//3) calculation ---------------------------------

				//node 5
				if(time>=7.0 && time <=7.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[0]++;

					}
				if(time>=7.2 && time <=7.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[1]++;
					}
				if(time>=7.4 && time <=7.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[2]++;
					}
				if(time>=7.6 && time <=7.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[3]++;
					}
				if(time>=7.8 && time <=8.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[4]++;
					}

				//---

				if(time>=8.0 && time <=8.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[5]++;
					}
				if(time>=8.2 && time <=8.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[6]++;
					}
				if(time>=8.4 && time <=8.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[7]++;
					}
				if(time>=8.6 && time <=8.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[8]++;
					}
				if(time>=8.8 && time <=9.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("5")){
						recd5[9]++;
					}

				//calc for 5 done
				
				//calc for 6 now.

				//node 6
				if(time>=7.0 && time <=7.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[0]++;

					}
				if(time>=7.2 && time <=7.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[1]++;
					}
				if(time>=7.4 && time <=7.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[2]++;
					}
				if(time>=7.6 && time <=7.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[3]++;
					}
				if(time>=7.8 && time <=8.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[4]++;
					}

				//---

				if(time>=8.0 && time <=8.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[5]++;
					}
				if(time>=8.2 && time <=8.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[6]++;
					}
				if(time>=8.4 && time <=8.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[7]++;
					}
				if(time>=8.6 && time <=8.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[8]++;
					}
				if(time>=8.8 && time <=9.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("tcp") && str[3].contentEquals("6")){
						recd6[9]++;
					}


				//calc done for node 6
				//now node 7
				
				if(time>=7.0 && time <=7.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[0]++;

					}
				if(time>=7.2 && time <=7.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[1]++;
					}
				if(time>=7.4 && time <=7.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[2]++;
					}
				if(time>=7.6 && time <=7.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[3]++;
					}
				if(time>=7.8 && time <=8.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[4]++;
					}

				//---

				if(time>=8.0 && time <=8.2)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[5]++;
					}
				if(time>=8.2 && time <=8.4)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[6]++;
					}
				if(time>=8.4 && time <=8.6)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[7]++;
					}
				if(time>=8.6 && time <=8.8)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[8]++;
					}
				if(time>=8.8 && time <=9.0)
					if(str[0].contentEquals("r") && str[4].contentEquals("cbr") && str[3].contentEquals("7")){
						recd7[9]++;
					}



			}
			
			
			
		}
		//		System.out.println("Sent : " + sent);
		//		System.out.println("Received : " + recd);
		//		System.out.println("Dropped : " + dropped);
		//		System.out.println("DQ : " + dq);
		//		System.out.println("PDR : " + PDR);
		//		

		//1. throughput at node 5 between 0.0 and 2.0
		System.out.println(x);

		int packetsize = 500 * 8;
		double totaltime1 = 2.0;
		throughput1 = (packetsize * recd1)/totaltime1;
		
		System.out.println();
		System.out.println("part 1 ");
		System.out.println("Throughput at node 5 between 0.0 and 2.0 : " + throughput1/1000000 + " Mbits per sec");
		System.out.println();

		//2. throughput at nodes 5 and 6 in every 0.2 sec between 2 and 5.
		//node 5
		System.out.println();
		System.out.println("part 2 ");
		System.out.println("Throughput for node 5 in Mbits per sec");
		for(int i=0 ; i<15  ; i++)
			System.out.print(" -- " + (double)(recd2[i]*500*8)/(0.2)/1000000 );
		System.out.println();
		System.out.println();
		System.out.println("Throughput for node 6 in Mbits per sec");
		for(int i=0 ; i<15  ; i++)
			System.out.print(" -- " + (double)(recd3[i]*500*8)/(0.2)/1000000 );

		//3. throughput at nodes 5 , 6, 7 in every 0.2 sec between 7 and 9.

	
		System.out.println();
		System.out.println();
		System.out.println("part 3 ");
		System.out.println("Throughput for node 5 in Mbits per sec");
		for(int i=0 ; i<10  ; i++)
			System.out.print(" -- " + (double)(recd5[i]*500*8)/(0.2)/1000000 );
		System.out.println();
		
		System.out.println("Throughput for node 6 in Mbits per sec");
		for(int i=0 ; i<10  ; i++)
			System.out.print(" -- " + (double)(recd6[i]*500*8)/(0.2)/1000000 );
		System.out.println();
		
		System.out.println("Throughput for node 7 in Mbits per sec");
		for(int i=0 ; i<10  ; i++)
			System.out.print(" --  " + (double)(recd7[i]*500*8)/(0.2)/1000000 );
	 
		
		
		
		sc.close();

	}
}
