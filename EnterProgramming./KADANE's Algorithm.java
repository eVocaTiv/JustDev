import java.util.Scanner;

public class Main {
	static int[] a ;
	static int n;
	static Scanner sc = new Scanner(System.in);
	
	public static void doKadane(){
		int max_so_far =0 , max_ending_here=0;
		
		for(int i=0 ; i<n ; i++) {
			max_ending_here += a[i];
			if(max_ending_here < 0)
				max_ending_here = 0;
			if(max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		
		
		System.out.println(max_so_far);
		
	}
	
	
	public static void main(String[] args) {
		
		//READ INPUT.
		n = sc.nextInt();
		a = new int[n];
		for(int i=0 ; i<n ; i++)
			a[i] = sc.nextInt();
		
		doKadane();
		
		
	}
	
	
}
