import java.util.Arrays;
import java.util.Scanner;


//NAIVE SOLUTION

public class Solution {
	static int[] p , t;

	public static int GetAns(int type , int v , int n) {

		if(type==1) {
			//O(N)...
			for(int i=0 ; i<n ; i++) {
				if(p[i]>v) {
					return t[i];
				}
			}

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
			//System.out.println("Index is " + index);
			int maxindex = index;

			for(int j = index ; j<n ; j++) {
				if(p[j]>p[maxindex]) {
					maxindex = j;
				}


			}
			return p[maxindex];

		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int q = in.nextInt();
		t = new int[n];
		for(int t_i = 0; t_i < n; t_i++){
			t[t_i] = in.nextInt();
		}
		p = new int[n];
		for(int p_i = 0; p_i < n; p_i++){
			p[p_i] = in.nextInt();
		}
		
		
		// O(Q*LOGN) .. EXCEEDS TIME LIMIT!
		for(int a0 = 0; a0 < q; a0++){
			int _type = in.nextInt();
			int v = in.nextInt();

			
			System.out.println( GetAns(_type , v , n) );

		}


		in.close();
	}
}
