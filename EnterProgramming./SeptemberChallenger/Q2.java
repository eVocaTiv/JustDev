import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	private static Scanner sc ;
	private static int t , n;
//	private static int[][] A ;
	private static Stack<Integer> s;
	private static ArrayList<Integer> res;

	public static void main(String [] args){
		sc = new Scanner(System.in);

		t = sc.nextInt();

		while(t-- > 0 ){
			n = sc.nextInt();
			s = new Stack<>();

			//A = new int[n+1][1];
			res = new ArrayList<>();

			//INITIALLY ALL NUMBERS FROM 1 TO N UNUSED.

			for(int i=n ; i>=1 ; i--){
				//A[i][0]= 0;
				s.push(i);
			}
			int i=1;
			//CONSTRUCT REQUIRED PERMUTATION.
			while(i<=n)
				while(!s.isEmpty()){
				//	System.out.println(i);
					if(i==n-1){
						int t1 , t2;
						t1 = s.pop();
						t2 = s.pop();
						if(t2==n){
							res.add(t2);
							s.push(t1);
							i++;
						}
						else{
							res.add(t1);
							s.push(t2);
							i++;
						}
					}
					
					if(s.peek()==i && i!=n){
						int top = s.pop();
						res.add(s.pop());
						s.push(top);
						i++;
					}
					else{
						if(s.isEmpty())
							break;
						res.add(s.pop());
						i++;
					}
				}



			for(int x : res)
				System.out.print(x + " ");

			System.out.println();
		}


	}

}
