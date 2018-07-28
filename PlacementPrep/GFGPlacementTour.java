import java.util.Arrays;
import java.util.Scanner;

public class PlacementTour {
	static Scanner sc = new Scanner(System.in);
	static int n, t, b;
	static int[] arr ;
	static long res = -1;

	public static boolean checkAns(int K) {
		long[] temp = new long[n];
		for(int i=0 ; i<n ; i++) {
			temp[i] = arr[i] + ( i+1) * K;
		}
		Arrays.sort(temp);
		long sum = 0;
		for(int i=0 ; i<K ; i++) {
			sum += temp[i];
		}
		if( sum <= b) {
			if(res < sum)
				res = sum;
			return true;
		}
		return false;
	}

	public static void getAns(int low, int high) {
		while ( low <= high ) {
			int mid = (low + high )/2;
			if(checkAns(mid)) {
				low = mid+1;
			}
			else {
				high = mid-1;
			}
		}
	}

	public static void main(String[] args) {
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0 ; i<n ; i++)
			arr[i] = sc .nextInt();
		b = sc.nextInt();
		getAns(0 , n-1);

		System.out.println(res);
	}

}
