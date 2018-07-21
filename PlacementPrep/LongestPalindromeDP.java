/*package whatever //do not write package name here */

import java.util.Scanner;

class GFG {
	static int t, n;
	static String s;
	static Scanner sc = new Scanner(System.in);
	static int res = 0;
	static String palindrome;
	static int[][] box;
	static int index;
	static int maxlen = 0;
	public static void getAns() {
		s = sc.next();
		char[] str = s.toCharArray();
		int n = s.length();
		box = new int[n][n];
		// all single letter words are palindromes
		for(int i=0 ; i<n ; i++) {
			box[i][i] = 1; 
		}
		// check for length 2 palindromes.
		for(int i=0 ; i<n-1 ; i++) {
			if (str[i] == str[i+1]) {
				box[i][i+1] = 1;
				index = i;
				maxlen = 2;
			}
		}
		
		// check for length 3 and higher.
		
		for(int len = 3 ; len <=n ; len ++) {
			for(int i = 0 ; i < n-len+1 ;  i ++) {
				int end = i + len - 1; 
			    if (box[i+1][end-1] == 1 && str[i] == str [end]) {
			    	box[i][end] = 1;
			    	
			    	if(len > maxlen) {
			    	index = i;
			    	maxlen = len;
			    	}
			    }
			}
		}
		res = box[0][0];
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<n ; j++) {
				System.out.print(box[i][j] + " ");
//				res = Math.max(res, box[i][j]);
			}
			System.out.println();
		}
	}
	public static void main (String[] args) {
		t = sc.nextInt();
		while (t-- > 0) {
			getAns();
			System.out.println(maxlen);
		}
	}
}
