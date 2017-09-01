import java.util.Scanner;


public class Main {

	private static Scanner sc;
	private static int t , n;
	private static long[]  prefix , suffix , a;

	public static void init(){


		n = sc.nextInt();

		a = new long[n];
		prefix = new long[n];
		suffix = new long[n];

		for(int i=0 ; i<n ; i++){
			a[i] = sc.nextInt();
		}

	}

	public static void GetAns(){
		prefix[0]=a[0];
		suffix[n-1] = a[n-1];
		//compute prefix.

		for(int i=1 ; i<n ; i++){
			prefix[i]= prefix[i-1] + a[i];
		}

		//compute suffix.
		for(int i=n-2 ; i>=0 ; i--){
			suffix[i]= suffix[i+1] + a[i];
		}

		long sum = Long.MAX_VALUE ;
		int index = 0;
		for(int i=0 ; i<n ;i++){
			if(sum>prefix[i] + suffix[i]){
				sum = Math.min(sum , prefix[i] + suffix[i]);
				index = i;
			}
		}

		
		index++;
		System.out.println(index);



	}

	public static void main(String[] args){
		sc = new Scanner(System.in);
		t = sc.nextInt();



		while(t-- > 0){
			init();
			GetAns();
		}
	}


}
