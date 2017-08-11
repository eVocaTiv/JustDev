
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static int t;
	private static Scanner s;
	private static ArrayList<Integer> list;


	public static void main(String[] args) {
		s = new Scanner(System.in);
		t=s.nextInt();

		while(t-- > 0) {
			list = new ArrayList<>();
			String res = "no";
			int n = s.nextInt();

			for(int i=0 ; i<n ; i++)
				list.add(s.nextInt());

			if(CheckRainbow(list))
				res="yes";



			System.out.println(res);

		}
	}

	public static boolean CheckRainbow(ArrayList<Integer> list) {
		boolean res = true;
		int s = 0;
		int l = list.size()-1;
		int current = list.get(0);
		while(s<=l) {
			int val = list.get(s);
			
			
			//IMPORTANT CORNER CASE!!
			if  (val == 8 || val == 9) {
				res = false;
				break;
			}
			//System.out.println("Current value is " + current);
			if(list.get(s)!=list.get(l)) {
				//System.out.println(s + " " + l );
				res=false;
				break;
			}
			else
				if(val == current+1)
					current++;
				else
					if(val == current);

					else{
						res = false;
						break;
					}

			s++;
			l--;
		}

		if(current < 7)
			res = false;
		return res;


	}

}
