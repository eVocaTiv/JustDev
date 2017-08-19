import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static long res = 0;
	static ArrayList<Integer> profitList;

	static void traderProfit(int k, int n, int[] A) {
		// Complete this function
		
		int maxi=-1;
		int mini=-1;
		for(int j=0 ; j<n ; j++) {
			
			
			//FINAL CONDITION.
			if(k==1 && mini != -1 ) {
				maxi = mini;
				for(int x = mini ; x<n-1 ; x++)
					if(A[x+1]>A[maxi]) {
						maxi = x+1;
					}
				
				res+=A[maxi]-A[mini];
				break;
			}
			//FIND LOCAL MINIMA.
			if(j!=n-1 && A[j+1]>A[j]  && mini==-1) {
				//BUY AT J.
				mini = j;
			}
			else
				if(j!=n-1 && A[j+1]<A[j] && maxi==-1) {
					//SELL AT J
					maxi = j;
				}
				else
					if(j==n-1)
						maxi = n-1;
			

			if(maxi!=-1 && mini!=-1) {
				//System.out.println("Maxi is " + A[maxi]);
				//System.out.println("Mini is " + A[mini]);
				int val = A[maxi]-A[mini];
				//System.out.println("adding.. " + val);
				res+= val;
				k--;
				mini = -1;
				maxi = -1;
			}
		}


	}

	public static void main(String[] args) {
		profitList = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			res=0;

			int k = in.nextInt();
			int n = in.nextInt();
			int[] arr = new int[n];


			for(int arr_i = 0; arr_i < n; arr_i++){
				arr[arr_i] = in.nextInt();
			}

			traderProfit(k, n, arr);
			
			
			
			System.out.println(res);
		}
		in.close();
	}
}
