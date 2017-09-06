import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	static int t;
	static Scanner sc = new Scanner(System.in);
	static int n;
	static long[] a , state;
	static int[][] cost ;
	static double[][] res;

	public static void main(String[] args){
		t = sc.nextInt();

		while(t-- > 0 ){

			n = sc.nextInt();
			
			cost = new int[n][n];
			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++)
					cost[i][j] = sc.nextInt();
		
			System.out.println((double)getPath()/(2*n-1));

		}



	}

	public static double getPath(){
		res = new double[n][n];
		res[0][0]= cost[0][0];
		
		for(int i=1 ; i<n ; i++){
			res[i][0]= res[i-1][0] + cost[i][0];
			res[0][i]= res[0][i-1] + cost[0][i];
		}
		
		for(int i=1 ; i<n ; i++)
			for(int j=1 ; j<n ; j++)
				res[i][j] = Math.max(res[i-1][j], res[i][j-1]) + cost[i][j];
		

		return res[n-1][n-1];

	}

	

}
