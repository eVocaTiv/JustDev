import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] s;
	static int t;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		t = sc.nextInt();
		while(t-->0) {
		
		n=sc.nextInt();
		m=sc.nextInt();
		s=new int[m];
		for(int i=0 ; i<m ; i++)
			s[i]=sc.nextInt();
		
		System.out.println(minCoins(s , n , m));
		
		
		}
	}
	
	public static int minCoins(int s[] , int n , int m ) {
		if(n==0)
			return 0;
		
		int res = Integer.MAX_VALUE;
		int temp;
		for(int i=0 ; i<m ; i++) {
			if(s[i]<=n) {
				temp = minCoins(s , n-s[i] , m);
				
				if(temp!=Integer.MAX_VALUE && res>temp)
					res = temp+1;
			}
		}
		
		return res;
		
		
	}
}
