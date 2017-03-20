import java.util.Scanner;
 
 
public class Main {
	static int[][] mat ;
	static int n,t;
	static Scanner s;
	static int res , ones;
 
	public static void main(String[] args){
 
		s = new Scanner(System.in);
 
		t=s.nextInt();
 
		while(t-- > 0) {
 
			n = s.nextInt();
 
			ones = ReadMatrix();
 
			ProcessMatrix();
			System.out.println(res);
			//s.close();
		}
	}
 
	public static void ProcessMatrix(){
 
		if(ones <= n){
			res=0;
			return;
		}
		else{
			ones-=n;
			res=1;
			for(int deduct=n-1 ; deduct>=1 ; deduct--){
 
				ones -= 2*deduct;
				if(ones <= 0 )
					return;
				res++;
				if(res==n){
					res=n-1;
					return;		
				}
			}
		}
 
 
	}
 
	public static int ReadMatrix(){
		int res=0;
		mat = new int[n][n];
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++){
				mat[i][j] = s.nextInt();
				if(mat[i][j]==1)
					res++;
			}
		return res;
	}
 
 
 
}
