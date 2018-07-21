import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static String[] hItems ;
	static int[] h;
	static int n;
	static long area;
	static Stack<Integer> s = new Stack<>();

	// Complete the largestRectangle function below.
	static void calcArea(int popped, int left,  int right) {
		//		System.out.println("l " + left );
		//		System.out.println("r " + right);
		area = Math.max(area, left == -1 ?  (right)*h[popped] :  (right-left-1)*h[popped]);

	}
	static void largestRectangle(int[] h) {
		int i=0;
		while( i < h.length ) {
			//			System.out.println("h");
			int popped = 0, peek = 0 ;
			if(s.isEmpty() || h[i] >= h[s.peek()]) 
				s.push(i++);
			else {
				popped = s.pop();
				if(!s.isEmpty())
					peek = s.peek();
				else
					peek = -1;
				//					calcArea(s.pop(), s.peek(),  i);
				//					System.out.println(area);
				//				System.out.println("i is " +  i );
				calcArea(popped, peek,  i);
				//				System.out.println(area);
			}
		}
		//		if (!s.isEmpty())
		//		calcArea(s.pop(),s.peek(), n-1);
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029FileWriter(System.getenv(\"OUTPUT_PATH\"))\u0085])?");

		h = new int[n+1];

		hItems= scanner.nextLine().split(" ");
		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}
		h[n] = 0;

		largestRectangle(h);

		bufferedWriter.write(String.valueOf(area));

		bufferedWriter.close();

		scanner.close();
	}
}
