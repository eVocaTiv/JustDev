import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int BIT[];
	static int n;
	static int arr[] ;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> list ;

	public static int getSum(int index) {
		index = index + 1;
		int sum = 0;
		while ( index > 0 ) {
			sum += BIT[index];
			index -= index & (-index);
		}
		return sum;
	}

	public static void updateBIT(int index, int val) {
		index = index + 1;
		while ( index <=n ) {
			BIT[index] += val;
			index += index & ( -index );
		}
	}

	public static void main(String[] args) {
		n=sc.nextInt();
		arr =  new int[n];
		list = new ArrayList<>();

		for(int i=0 ; i<n ; i++) {
			int el =  sc.nextInt();
			arr[i] = el;
			list.add(el);
		}
		Collections.sort(list);
		for(int i=0 ; i<n ; i++) {
			arr[i] = Collections.binarySearch(list, arr[i]);
		}
//		for(int i=0 ; i<n ; i++)
//			System.out.print(arr[i]);
		BIT = new int[n+1];

		// construct BIT
		for(int i=1 ; i<=n ; i++) {
			BIT[i] = 0;
		}
		int res = 0;
		for(int i=n-1 ; i>=0 ; i--) {
			res  += getSum(arr[i]-1);
//			System.out.println("res is " + res );
			updateBIT(arr[i], 1);
//			System.out.print("printing BIT ");
//			for(int j=1 ; j<=n ; j++)
//				System.out.print(BIT[j] + " ");
		}
//		System.out.println();
		System.out.println(res);
	}
}
