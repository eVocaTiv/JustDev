import java.util.Scanner;


public class Main {
	static int n , m;
	static int [] s;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args){
		n = sc.nextInt();
		m = sc.nextInt();
		s = new int[m];
		for(int i=0 ; i<m ; i++){
			s[i] = sc.nextInt();
		}
		
		System.out.println(getAns(s , n , m));
	}
	
	//METHOD TO GET TOTAL WAYS.
	public static int getAns(int [] s, int n ,int m){
		if(n<0)
			return 0;
		
		if(n==0)
			return 1;
		
		if(m<=0 && n>=1)
			return 0;
		
		return getAns(s , n  , m-1) + getAns( s , n-s[m-1] , m);
		
	}
	
	
}
