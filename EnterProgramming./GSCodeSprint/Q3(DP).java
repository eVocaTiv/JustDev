import java.util.Scanner;

public class Solution {
	static int[][] profitmatrix ;
	static int[] arr;

    static int traderProfit(int k, int n, int[] A) {
        // Complete this function
    	//INITIALIZE MATRIX.
    	for(int i=0 ; i<k ; i++)
    		profitmatrix[i][0]=0;
    	for(int i=0 ; i<n ; i++)
    		profitmatrix[0][i]=0;
    	
    	
    	for(int i=1 ; i<=k ; i++)
    		//DAYS COUNTED FROM 0 TO N-1.
    		//HENCE FILL ONLY TILL N-1 AND RETURN PROFITMATRIX[K][N-1] AT THE END.
    		for(int j=1 ; j<n ; j++) {
    			int maxi = 0;
    			for(int x=0 ; x<j ; x++) {
    				maxi = Math.max(maxi, profitmatrix[i-1][x] + arr[j] - arr[x]);
    				
    			}
    			
    			profitmatrix[i][j]=Math.max(maxi , profitmatrix[i][j-1]);
    		}
    	
    	return profitmatrix[k][n-1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
        	
            int k = in.nextInt();
            int n = in.nextInt();
            profitmatrix = new int[k+1][n+1];
            arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            int result = traderProfit(k, n, arr);
            System.out.println(result);
        }
        in.close();
    }
}
