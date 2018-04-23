import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Main {
	static char[] str ;
	static long[] S;
	static int len;
	// Complete the substrings function below.
	static void substrings(String n) {
		len = n.length();
		S = new long[len+1];
		str = n.toCharArray();
		//System.out.println(str.length);
		for(int i=0 ; i<=len ; i++)
			S[i]=0;

		for(int i=1 ; i<=len ; i++)
		{
			
			StringBuilder sb = new StringBuilder("");
		
			for(int j=i ; j>=1 ; j--) {
				sb.append(str[j-1]);
				BigInteger b = new BigInteger(sb.reverse().toString());
				S[i]+=((b.mod(new BigInteger(String.valueOf("1000000007"))).intValue()));
			//	S[i]+=(Long.parseLong(sb.reverse().toString()))%((long)Math.pow(10, 9)+7);
				sb.reverse();

			}
			S[i]+= S[i-1]%((long)Math.pow(10, 9)+7);
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String n = scanner.nextLine();
 
		 substrings(n);

	//	System.out.println((long)Math.pow(10, 9)+7);
		System.out.println(S[len]);
		scanner.close();
	}
}
