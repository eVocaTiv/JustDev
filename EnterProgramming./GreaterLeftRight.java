import java.util.Scanner;


public class Main {
	static int t , n;
	static Scanner sc = new Scanner(System.in);
	static int[] a , leftmax , rightmax;
	static int res;
	
	
	public static void main(String[] args){
		 t= sc.nextInt();
		 
		 while(t-- > 0){
			 n = sc.nextInt();
			 
			 a = new int[n];
			 
			 for(int i=0 ; i<n ; i++)
				 a[i] = sc.nextInt(); 

			 getAns();
			 System.out.println(res);
		 }
	}
	
	public static void getAns(){
		leftmax = new int[n];
		rightmax = new int[n];
		
		leftmax[0]= a[0];
		
		for(int i=1 ; i<n ; i++){
			leftmax[i]=Math.max(leftmax[i-1], a[i]);
		}
		
		rightmax[n-1] = a[n-1];
		for(int i=n-2 ; i>=0 ; i--){
			rightmax[i]=Math.max(rightmax[i+1], a[i]);
		}
		
		
		for(int i=1 ;i<n-1 ; i++){
			if (a[i]>=leftmax[i] && a[i]<=rightmax[i]){
				res = a[i];
				return;
			}
		}
	}
	
	
}
