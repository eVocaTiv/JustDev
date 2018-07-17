import java.util.Scanner;

public class Main {
	static int BIT[];
	static int n = 5;
	static int arr[] = {5, 15, 3 , 2 , 9};
	static Scanner sc = new Scanner(System.in);

	public static int getSum(int index) {
		index = index + 1;
		int sum = 0;
		while ( index > 0 ) {
			sum += BIT[index];
			index -= index & (-index);
		}
		return sum;
	}
	
	public static void updateBIT(int val, int index) {
		index = index + 1;
		while ( index <=n ) {
			BIT[index] += val;
			index += index & ( -index );
		}
	}
	
	public static void main(String[] args) {
		BIT = new int[6];

		// construct BIT
		for(int i=1 ; i<=n ; i++) {
			BIT[i] = 0;
		}
		for(int i=0 ; i<n ; i++) {
			updateBIT(arr[i], i);
		}
		
		System.out.println(getSum(2));
	}
}
