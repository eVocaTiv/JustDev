import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*package whatever //do not write package name here */

class GFG {
	static int a[], l[];
	static int n ;
	static int t, k;
	static String res;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> list;
	public static void main (String[] args) {
		t = sc.nextInt();
		while(t-- > 0) 
			getAns();
	}
	public static int binarySearch(int low , int high) {
		int mid = (low+high)/2;
		if ( low == high) {
			return list.get(low);
		}
		if( low > high ) {
			return -1;
		}
		if ( mid % 2 != 0 ) {
			// mid is odd
			if ( list.get(mid-1) == list.get(mid) ) {
				return binarySearch(mid+1 , high);
			} 
			return binarySearch (low, mid-1);
		} else {
			// mid is even
			if ( list.get(mid+1) == list.get(mid) ) {
				return binarySearch( mid+2, high);
			}
			return binarySearch(low, mid);
		}
	}
	public static void getAns() { 
		n=sc.nextInt();
		a = new int[n];
		list = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			list.add(sc.nextInt());
		}

		System.out.println(binarySearch(0 , n-1));
	}

}
