import java.util.Arrays;
import java.util.Scanner;

public class SmallestStringWindow {
	static Scanner sc = new Scanner(System.in);
	static int n, t,x;
	static String str, pat;

	public static void getAns() { 
		str = sc.next();
		pat = sc.next();

		int hash_str[] = new int[26];
		int hash_pat[] = new int[26];

		Arrays.fill(hash_str, 0);
		Arrays.fill(hash_pat,0);

		if(str.length() < pat.length())
			return;
		// store frequencies of the string and pattern.
		for(int i=0 ; i<pat.length() ; i++) {
			hash_pat[pat.charAt(i)-'a']++;
		}

		int matchCount = 0, startIndex = -1, start = 0, endIndex = -1;
		int minsize = Integer.MAX_VALUE;
		// SEEK WINDOW THEN MINIMIZE IT.
		for(int j=0 ; j<str.length(); j++) {

			// update string freq.
			hash_str[str.charAt(j)-'a']++;

			// match a char. if freq less than that in pattern.
			if(hash_str[str.charAt(j)-'a'] != 0 && 
					hash_str[str.charAt(j)-'a'] <= hash_pat[str.charAt(j)-'a']) {
				endIndex = j;
				matchCount ++;

			}

			if(matchCount == pat.length()) {
				//				System.out.println("matched start & end : " + startIndex + " " + endIndex);
				//ALL CHARACTERS MATCHED.
				//MINIMIZE WINDOW LOGIC
				while(hash_str[str.charAt(start)-'a'] ==0 ||  hash_str[str.charAt(start)-'a'] > hash_pat[str.charAt(start)-'a']) {
					if( hash_str[str.charAt(start)-'a'] > hash_pat[str.charAt(start)-'a'])
						hash_str[str.charAt(start)-'a']--;
					start++;
				}

				int len_window = j - start + 1;
				if ( minsize > len_window) {
					minsize = len_window;
					startIndex = start;
				}
			}
		}
//		for(int i=0 ; i<26;  i++)
//			System.out.print(hash_str[i] + " ");
//		System.out.println("window size is " + minsize);
		endIndex = startIndex + minsize;
		System.out.println("start " + startIndex + " end " + endIndex);


	}

	public static void main(String[] args) {
		t = sc.nextInt();
		while( t-->0 ) {
			getAns();
		}
	}


}
