import java.util.Scanner;


public class Main {

	static int t;
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] a , state;
	int res;

	public static int getAns(int [] a , int end ){
		
		
		state = new int[n+1];

		if(a[0]==0 || n==0)
			return Integer.MAX_VALUE;
		//state[j] stores minimum jumps required from 0 to j.
		//=> use tabulation to construct the answer for n.

		state[0]=0;

		for(int i=1 ; i<n ; i++){
			int cres = Integer.MAX_VALUE;
			for(int j=0 ; j<i ; j++){
				if(a[j]!=Integer.MAX_VALUE && i - j <= a[j])
					cres = Math.min(cres , state[j]+1);

			}
			
			state[i]= cres;

		}
		return state[n-1];
	}

	public static void main(String[] args){
		t = sc.nextInt();

		while(t--> 0){
			n = sc.nextInt();
			a = new int[n];
			for(int i=0 ; i<n ;i++)
				a[i] = sc.nextInt();

			long res = getAns(a , n-1);
			
			if(res==Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(res);
			
		}

	

	}
}
