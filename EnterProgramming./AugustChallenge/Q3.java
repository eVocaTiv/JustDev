import java.util.Scanner;

public class Main {
	static int[][] qual;
	static String[] as;
	static long[] maxJobs , offSal , minSal , nowJobs;
	static int totalsal=0;
	static int n , m , t , got;
	static Scanner s;
	public static void Init() {
		totalsal = 0;
		

		n = s.nextInt();
		m = s.nextInt();

		as = new String[n];
		//qual = new int[n][m];
		maxJobs = new long[m];
		offSal = new long[m];
		minSal = new long[n];
		nowJobs = new long[m];

		for(int i=0 ; i<n ; i++)
			minSal[i] = s.nextInt();
		for(int i=0 ; i<m ; i++) {
			offSal[i] = s.nextInt();
			maxJobs[i] = s.nextInt();
			nowJobs[i] = 0;

		}

		for(int i=0 ; i<n ; i++) {
			
			as[i] = s.next();
			//s.nextLine();
			//String str = s.next();
			//System.out.println("hiiii");
			//System.out.println(str);
		//	for(int j=0 ; j<m ; j++) {
			//	System.out.println("i is " + i + "j is " + j);
			//	qual[i][j] = Character.getNumericValue(str.charAt(j));
			//	System.out.print(qual[i][j] + " ");
			
			//}
		}

	}


	public static void main(String[] args) {
		
		s = new Scanner(System.in);
		t = s.nextInt();
		while(t-- > 0) {
			got = 0 ;
			Init();
			//System.out.println(qual[n-1][m-3]);

			for(int i=0 ; i<n ; i++){
				Process(i);
			}
			
	
			
			//PRINT COMPANIES WITH 0 RECRUITS.
			int lol = 0;
			
			for(int comp=0 ; comp < m ; comp ++) {
				if(nowJobs[comp]==0)
					lol++;
			}
			
			System.out.println(got + " " + totalsal + " " + lol);
			

		}

	}

	public static void Process(int i) {
		boolean joined = false;
		int prev = -1;
		long maxlatest = 0;
		for(int comp = 0 ; comp < m ; comp++) {
			//System.out.println("Char is" + as[i].charAt(comp));
			if(as[i].charAt(comp)=='1' && maxJobs[comp]>0 && offSal[comp]>=minSal[i] && offSal[comp]>maxlatest) {
				//System.out.println("Entering");
				//joined = true;
				//CONSIDER JOINING COMP.
				if(prev!=-1)
					maxJobs[prev]++;
				
				maxJobs[comp]--;
		
				maxlatest = offSal[comp];
				prev = comp;
				
				
			} 
		}
		
		//COMPANY JOINED OR NOT.
		if(prev!=-1) {
			totalsal += maxlatest;
			got++;
			nowJobs[prev] = 1;
		}
	}

}
