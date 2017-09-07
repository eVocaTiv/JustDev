import java.util.Scanner;





public class Main {
	static Scanner sc = new Scanner(System.in);
	static int t, n;
	static int[][] a , b;
	static int res = 0;
	static int[] rows = new int[]{-1 , 0 , 0 , 1};
	static int[] cols = new int[]{0 , 1 , -1 , 0};



	public static int getAns(int i , int j){
		int maxi = 1;
		if(i>=n || j>=n  || i<0 || j < 0 )
			return 0;
		if(b[i][j]!=-1)
			return b[i][j];
		else{
			for(int k=0 ; k<4 ; k++){
				if(i+rows[k]<n && j+cols[k]<n && i+rows[k]>=0 && j+cols[k] >=0 
						&& a[i+rows[k]][j+cols[k]]==(a[i][j]+1)){
					maxi = 1 + getAns(i+rows[k] , j+cols[k]);
					
				}
			}
			
		return maxi;	
		}
			//solve for the subproblem.
	}


	public static void main(String [] args){
		t = sc.nextInt();

		while(t-- > 0){
			n= sc.nextInt();
			a = new int[n][n];
			b= new int[n][n];


			for(int i=0 ;i<n ;i++)
				for(int j=0 ;j<n ;j++){
					a[i][j]=sc.nextInt();
					b[i][j]=-1;
				}
		

			

			for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++){
					res = Math.max(res  , getAns(i , j));
				}

			System.out.println(res);
		}

	}

}
