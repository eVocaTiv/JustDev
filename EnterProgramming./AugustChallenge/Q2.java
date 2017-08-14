import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int t , D, n ;
	static double x=0;
	static long res , diff;
	static long xint;
	private static Scanner s;
	private static long[] list;


	public static void main(String[] args) {
		boolean np = true;
		s = new Scanner(System.in);
		t=s.nextInt();

		while(t-- > 0) {

			res = 0;
			n = s.nextInt();
			list = new long[n];
			D = s.nextInt();	




			for(int i=0 ; i<n ; i++)
				list[i]=s.nextInt();

			x=0;
			for(long el : list) {
				x+=el;
			}
			x/=n;


			//System.out.println("hi");
			//System.out.println(x);
			//System.out.println(x);
			if(x==(long)x) {
				np = false;
				xint = (int)x;
				//System.out.println("X val is " + xint);
				GetAns();
			}
			if(x==(long)x)
				for(long el : list) {
					if(el!=xint)
						np = true;
				}

			System.out.println(np == true? -1 : res);
			np = true;

			
			//for(int x : list)
		    //System.out.print(x+ " ");
		}
	}

	public static void GetAns() {
		//System.out.println("in getans");

		for(int i=0 ; i<n ; i++) {
			if(list[i]==xint)
				;
			else 
				if(list[i]<xint) {
					if(i+D<n) {
						diff = xint-list[i];
						list[i] = xint;
						res += diff;
						list[i+D]-=diff;
					}
					else
						return;
				}
				else {
					if(i+D<n) {
						diff = list[i]-xint;
						list[i] = xint;
						res += diff;
						list[i+D]+=diff;
						
					}
					else return;
				}
		}


	}



}
