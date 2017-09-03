import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	static int n , t;
	static Scanner sc = new Scanner(System.in);
	static int[] dp;

	public static void getAns(){
		//1st ugly number is 1;
		dp[0]=1;
		
		int i2=0  , i3=0 , i5=0;
		int next_of_2 = 2;
		int next_of_3 = 3;
		int next_of_5 = 5;

		int dpx=1;
		for(int i=1 ; i<n ; i++){
			dpx = Math.min(next_of_2 , Math.min(next_of_3 , next_of_5));
			dp[i]=dpx;
			if(dpx==next_of_2) {
				i2++;
				next_of_2 = dp[i2]*2;
				
			}
			
			if(dpx==next_of_3) {
				i3++;
				next_of_3 = dp[i3]*3;
				
			}
			if(dpx==next_of_5) {
				i5++;
				next_of_5 = dp[i5]*5;	
			}

			
		}
	
		System.out.println(dpx);
	}

	public static void main (String[] args) {
		t = sc.nextInt();
		while(t-- > 0){
			n = sc.nextInt();
			dp = new int[n];
			getAns();
		}
	}
}
