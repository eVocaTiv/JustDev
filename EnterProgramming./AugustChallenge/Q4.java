import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int test , sno , tno;
	static String s , t , res;
	static Scanner sc;
	static int cnt[][];
	public static void GetAns() {
		boolean subset = false;
		boolean unico =  false;


		for(int x =0 ; x<s.length() ; x++) {

			cnt[0][s.charAt(x)-'a']++;
			cnt[1][t.charAt(x)-'a']++;

		}

		// 1.) CHECK IF S HAS A UNIQUE CHAR. OCCURING MORE THAN ONCE.
		for(int x = 0 ; x<26 ; x++) {
			if(cnt[0][x]>=2 && cnt[1][x]==0) {
				res="A";
				return ;
			}
		}

		subset = true;
		// 2.) CHECK IF T IS SUBSET OF S AND S HAS ATLEAST 1 UNIQUE CHAR.

		//check for unico.

		for(int x=0 ; x<26 ; x++) {
			if(cnt[0][x]>0 && cnt[1][x]==0){
				unico = true;
			}
		}

		//check for subset
		for(int x=0 ; x<26 ; x++) {
			if(cnt[0][x]==0 && cnt[1][x]>0){
				subset = false;
			}
		}

		/*
		if(s1.size()==0) {
			//System.out.println("size is 0");
			res = "B";
			return;
		}
		 */
		if(unico && subset)
			res = "A";
		else
			res = "B";

	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		test = sc.nextInt();


		while(test-- > 0) {
			res = "B";
			GetOn();
			GetAns();

			System.out.println(res);


		}

	}

	public static void GetOn() {
		cnt = new int[2][26];
		s = sc.next();
		t = sc.next();
		//s1 = new HashSet<>();
		//s2 = new HashSet<>();
		//sno = 0;
		//tno = 0;


	}

}
