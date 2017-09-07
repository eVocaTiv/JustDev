import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int t;
	static String str;
	
	
	public static boolean checkSumString(String str , int start , int len1 , int len2) {
		boolean res = false;
		
		if(str.length()-len1-len2 <=0 )
			return false;
		
		String s1 , s2 , s3;
		
		s1 = str.substring(start, start+len1);
		s2 = str.substring(start+len1, start+len1+len2);
		s3 = String.valueOf((Integer.parseInt(s1)+Integer.parseInt(s2)));
	
		
		
		//System.out.println(s1);
		//System.out.println(s2);
		//System.out.println(s3);
		
		if(s3.length() > str.length()-len1-len2-start)
			return false;
	
		else//check for equality of s3
		{//System.out.println("hi");
			//System.out.println(s3);
			//System.out.println(str.substring(start+len1+len2 , start+len1+ len2 + s3.length()));
			if(s3.contentEquals(str.substring(start+len1+len2 , start+len1+ len2 + s3.length()))) {
				//System.out.println("hi");
				if(start + len1 + len2 + s3.length() == str.length()) {
					return true;
				}
			return checkSumString(str , start+len1 , len2 , s3.length());	
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		t=sc.nextInt();
		
		while(t-- > 0) {
			boolean ans = false;
			str = sc.next();
			for(int i=1 ; i<str.length() ; i++)
				for(int j=1 ; j<str.length()-i ; j++)
				if(checkSumString(str, 0, i, j)) {
					System.out.println(1);
					ans = true;
					break;
				}
			if(!ans) {
				System.out.println(0);
				ans = true;
				
			}
		}
		
	}
	
	
}
