import java.util.Arrays;
import java.util.Scanner;


//NAIVE SOLUTION

public class Solution {
	static long[] p , t;
	static long[] premax , postmax;

	public static long GetAns(long type , long v , long n) {

		if(type==1) {
			//O(N)...
			int rawindex = Arrays.binarySearch(premax, v);
			//rawindex = -(indexpoint ) - 1 ;
			//	System.out.println("RawIndex is" + rawindex);

			int index = rawindex;
			if(index < 0) {
				index ++;
				index = - index;
			}
			// have index of p
			// return time value
			//System.out.println("1 index is" + index);
			
			return ((index<0)||(index>=n))? -1 : t[index];

			//TYPE 1 QUERY.
		}
		else {
			//O(logn) + O(n) = O(n)....
			int rawindex = Arrays.binarySearch(t, v);
			//rawindex = -(indexpoint ) - 1 ;
			//	System.out.println("RawIndex is" + rawindex);

			int index = rawindex;
			if(index < 0) {
				index ++;
				index = - index;
			}
			
			//System.out.println("2 index is" + index);
			return ((index<0)||(index>=n))? -1 : postmax[index];

		}

		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		t = new long[n];
		for(int t_i = 0; t_i < n; t_i++){
			t[t_i] = in.nextInt();
		}
		p = new long[n];
		for(int p_i = 0; p_i < n; p_i++){
			p[p_i] = in.nextInt();
		}
		premax = new long[n];
		postmax = new long[n];
		
		//CALCULATE PREMAX ARRAY
		//O(N)...
		long premaxval = 0;
		for(int i=0 ; i<n ; i++) {
			premaxval=Math.max(premaxval, p[i]);
			premax[i]=premaxval;
		}
		//CALCULATE POSTMAX ARRAY
		//O(N)....
		long postmaxval = 0;
		for(int i=n-1 ; i>=0 ; i--) {
			postmaxval=Math.max(postmaxval, p[i]);
			postmax[i]=postmaxval;
		}
		
		
		
		
		// O(Q*LOGN) !!
		for(int a0 = 0; a0 < q; a0++){
			int _type = in.nextInt();
			int v = in.nextInt();

			
			System.out.println( GetAns(_type , v , n) );

		}


		in.close();
	}
}
