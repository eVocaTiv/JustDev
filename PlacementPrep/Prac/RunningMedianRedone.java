import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	static int med = -1;
	public static void main(String[] args)  { 
		int[] arr = new int[] { 0, 9, 1, 8, 2, 
				7, 3, 6, 4, 5 }; 
		int k = 3; 

		findMedian(arr, k); 
	} 

	static void findMedian(int[] a, int k) {
		for(int i=0; i<k; i++) {
			addElement(a[i]);
		}
		for(int i=k; i<a.length; i++) {
			printMedian(k);
			addElement(a[i]);
			removeElement(a[i-k]);
		}
		printMedian(k);
	}

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


	static void addElement(int x) {
		if(lower.isEmpty())
			lower.add(x);
		else
			if(upper.isEmpty())
				upper.add(x);
			else  {
				int maxi = lower.peek();
				int mini = upper.peek();
				if(x >= maxi) {
					upper.add(x);
				} else {
					lower.add(x);
				}
			}
		reBalance();
	}

	static void reBalance() {
		int lowerSize = lower.size();
		int upperSize = upper.size();

		// make sure lower is always >= upper.
		if((upperSize-lowerSize) > 0) {
			lower.add(upper.poll());
		} else
		if((lowerSize-upperSize) > 1) {
			upper.add(lower.poll());
		}
	}

	static void printMedian(int k) {
		if(k % 2 == 0) {
			System.out.print((upper.peek() + lower.peek()) /2  + " ");
		} else {
			System.out.print(lower.peek() + " ");
		}
	}

	static void removeElement(int x) {
		if(lower.contains(x))
			lower.remove(x);
		else
			upper.remove(x);
		reBalance();
	}
}
