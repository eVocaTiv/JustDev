import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static long res = 0;
	static int m , n ;
	static Scanner in = new Scanner(System.in);
	public static void GetAns(){
		arr = new int[n+1];
		Arrays.fill(arr , 0);
		//READ VALUES FOR a , b , k and use modifications at range indices.
		//System.out.println("m is " + m );
		for(int a0 = 0; a0 < m; a0++){
			int a = in.nextInt();
			int b = in.nextInt();
			int k = in.nextInt();

			arr[a]+=k;
			if(b+1<=n)
				arr[b+1]-=k; 
		}
		// System.out.println("ins");

		//CALCULATE THE PREFIX ARRAY AND MAINTAIN MAX.

		// int[] prefix = new int[n+1];
		//  System.out.println("n is " + n );
		//prefix[0]=0;
		long temp = 0;
		for(int i=0 ; i<=n ; i++){
			temp = temp+arr[i];
			res = Math.max(res ,temp);
		}
		System.out.println(res);
	}

	public static void main(String[] args) {

		n = in.nextInt();
		m = in.nextInt();
		// System.out.println("hi");

		GetAns();
		//System.out.println(res);

		in.close();
	}
}
