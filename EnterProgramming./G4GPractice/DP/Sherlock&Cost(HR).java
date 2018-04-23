import java.io.IOException;
import java.util.Scanner;

public class Solution {
	static int dp[][];
	// Complete the cost function below.
	static int cost(int[] B , int n ) {
		int res = 0;
		dp = new int[n][2];

		
		//base cases
		for(int i=0 ; i<n ; i++) {
			dp[i][0] = 0;
			dp[i][1] = 0;
		}
		
		//fill
		for(int i=1 ; i<n ; i++) {
			dp[i][0]=Math.max(dp[i-1][0], dp[i-1][1] + Math.abs(1-B[i-1]));
			dp[i][1]=Math.max(dp[i-1][0] + Math.abs(B[i]-1),  dp[i-1][1] + Math.abs(B[i]-B[i-1]));
			
		}

		return Math.max(dp[n-1][1] , dp[n-1][0]);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		int t = scanner.nextInt();

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();

			int[] B = new int[n];

			for (int BItr = 0; BItr < n; BItr++) {
				int BItem = scanner.nextInt();
				B[BItr] = BItem;
			}

			int result = cost(B , n);

			System.out.println(String.valueOf(result));
		}


		scanner.close();
	}
}
