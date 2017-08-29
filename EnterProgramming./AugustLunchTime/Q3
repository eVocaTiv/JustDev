import java.math.BigInteger;
import java.util.Scanner;

public class Ez {
	static int t;
	static int n;
	static BigInteger k;
	static Scanner sc = new Scanner(System.in);


	public static void init() {
		n=sc.nextInt();
		k=new BigInteger(sc.next());

	}

	public static void main(String[] args) {
		t = sc.nextInt();
		BigInteger s1 = new BigInteger("0");
	

		while(t-->0) {
			init();
			BigInteger res = new BigInteger("0") ;
			for(;n>=1 ; n--) {
				
				
				if((k.divideAndRemainder(BigInteger.valueOf(2)))[1]!=BigInteger.ZERO) {
				//	System.out.println("true");
					res = res.add(BigInteger.valueOf((long)(1<<(n-1))));
				}
				k = k.divide(BigInteger.valueOf(2));
			}

			System.out.println(res);
			//	long res = 0;
			/*
			String dfs = new String();
			DecimalFormat df ;
			for(int i=0 ; i<n ; i++)
				dfs += "0";
			df = new DecimalFormat(dfs);

			String s = (Long.toBinaryString(k));
			long sin = Long.parseLong(s);
			String sd = df.format(sin);

			//System.out.println("String is " + sd);
			StringBuilder sb = new StringBuilder(sd).reverse();

			System.out.println(Long.parseLong(sb.toString() ,2));
			 */
		}
	}

}

