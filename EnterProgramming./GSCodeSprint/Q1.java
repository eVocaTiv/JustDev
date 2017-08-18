import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner (System.in);
	private static ArrayList<Integer> list;
	static int k, x , d , n;
	static int t;
	static double sum=0;
	static String res = "fee";


	public static void ReadInp() {
		list = new ArrayList<>();
		sum=0;
		res="fee";
		n = s.nextInt();
		k = s.nextInt();
		x = s.nextInt();
		d = s.nextInt();

		//GET PAYMENT ARRAYLIST
		for(int i=0 ; i<n ; i++)
			list.add(s.nextInt());
		
		
	}
	
	
	
	public static void GetAns() {
		for(int i=0 ; i<n ; i++) {
			sum+= Math.max(k, (double)(x*list.get(i))/100);
		}
		if(d<sum)
			res="upfront";
		//System.out.println("k is" + k + " sum is " + sum);
		System.out.println(res);
	}

	public static void main(String[] args) {
		t = s.nextInt();
		while(t-->0) {
			
			ReadInp();
			GetAns();
		}
	}


}
