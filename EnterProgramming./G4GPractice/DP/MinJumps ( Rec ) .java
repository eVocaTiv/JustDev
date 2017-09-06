import java.util.Scanner;


public class Main {
	
	static int t;
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] a;
	int res;
	
	public static int getAns(int [] a , int low , int high ){
		if(low == high)
			return 0;
		if(a[low]==0)
			return Integer.MAX_VALUE;
		
		//ELSE RECURSIVELY FIND THE SOLUTION FROM NEXT JUMP;
		int cres= Integer.MAX_VALUE;
		
		for(int i=low+1 ; i<=high && i<=a[low] ; i++){
			int temp = getAns(a , i , high);
			
			if(temp!=Integer.MAX_VALUE && cres > 1 + temp){
				cres = 1 + temp;
			}
			
			
		}
		
		return cres;
		
		
	}
	
	public static void main(String[] args){
		t = sc.nextInt();
		
		while(t--> 0){
			n = sc.nextInt();
			a = new int[n];
			for(int i=0 ; i<n ;i++)
				a[i] = sc.nextInt();
		
		}
		
		System.out.println(getAns(a , 0  , n-1));
		
		
		
	}
}
