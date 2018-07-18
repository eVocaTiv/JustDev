import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	static int res = 0;
	static PriorityQueue<Integer> lower = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer a , Integer b) {
			if (a>b)
				return -1;
			if (a<b)
				return 1;
			return 0;
		}
	});
	static PriorityQueue<Integer> upper = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer a , Integer b) {
			if (a>b)
				return 1;
			if (a<b)
				return -1;
			return 0;
		}
	});
	static int n;
	static double med = -1;

	static void rebalance() {
		if(lower.size() > upper.size() + 1)
			upper.add(lower.poll());
		else 
			if ( upper.size() > lower.size() + 1)
				lower.add(upper.poll());
		calculateMed();
	}
	static void add(int[] expenditure, int val) {
		if( med == -1 ) {
			lower.add(val);
			med = val;
		} else {
			if ( val > med) {
				upper.add(val);
				rebalance();
			} else {
				lower.add(val);
				rebalance();
			}
		}
	}
	static void calculateMed() {
		if( lower.size() == upper.size() ) {
//			System.out.println("yo");
//			System.out.println("upper peek " + upper.peek());
//			System.out.println("lower peek " + lower.peek());
			med = (double)(lower.peek() + upper.peek())/2;
		}
		else {
			if ( lower.size() > upper.size()) {
				med = lower.peek();
			} else
				med = upper.peek();
		}
//		System.out.println("median update: " + med );
	}
	// Complete the activityNotifications function below.
	static int activityNotifications(int[] expenditure, int d) {
		// add first d elements.
		int i=0;
		for( ; i<d ; i++) {
			add(expenditure, expenditure[i]);
		}
		for(; i<n ; i++) {
//			System.out.println("Median is " + med);

			if (expenditure[i] >= 2*med)
				res++;
			if(lower.contains(expenditure[i-d]))
				lower.remove(expenditure[i-d]);
			else
				upper.remove(expenditure[i-d]);
			rebalance();

			add(expenditure, expenditure[i]);
		}
		//		
		//		while(!lower.isEmpty())
		//			System.out.print(lower.poll() + " ");
		//
		//		System.out.println();
		//		while(!upper.isEmpty())
		//			System.out.print(upper.poll() + " ");


		return res;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nd = scanner.nextLine().split(" ");

		n = Integer.parseInt(nd[0]);

		int d = Integer.parseInt(nd[1]);

		int[] expenditure = new int[n];

		String[] expenditureItems = scanner.nextLine().split(" ");

		for (int i = 0; i < n; i++) {
			int expenditureItem = Integer.parseInt(expenditureItems[i]);
			expenditure[i] = expenditureItem;
		}

		int result = activityNotifications(expenditure, d);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.close();
		scanner.close();
	}
}
