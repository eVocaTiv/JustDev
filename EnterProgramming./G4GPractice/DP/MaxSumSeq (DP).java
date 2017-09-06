import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class Main {

	static int t;
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] a , state;
	int res;

	
	public static int maxSumSeq(int[] a , int k ){
		state = new int[n];
		for(int i=0 ; i<n ; i++)
			state[i]= a[i];
		
		for(int i=1 ; i<n ; i++){
			int cres = state[i];
			for(int j=0 ; j<i ; j++){
				if(a[j]<a[i] && state[j] + a[i]>cres )
					cres = state[j] + a[i];
					//cres = Math.max(state[j] + a[i] , cres);
			}
			state[i] = cres;
		}
	
		int res=Integer.MIN_VALUE;
		for(int i=0 ; i<n ; i++)
			if(res < state[i])
				res = state[i];
		
		return res;
		
	}
	public static void main(String[] args){
		t = sc.nextInt();
		
		while(t-- > 0 ){
			n = sc.nextInt();
			
			a= new int[n];
			for(int i=0 ; i<n ; i++)
				a[i]= sc.nextInt();
			
			System.out.println(maxSumSeq(a , n));
			
		}
		
		
		
	}
	
	
}
