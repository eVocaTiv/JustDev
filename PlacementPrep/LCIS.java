
public class Main {
	static int table[];
	public static int LCIS(int[] arr1, int n , int[] arr2, int m) {
		int res = 0 ;
		table = new int [m];
		for(int i=0 ; i<m ; i++) {
			table[i] = 0;
		}

		// for every element in array 1
		for(int i=0 ; i<n ; i++) {

			int curlen = 0;
			// traverse through every element in array 2
			for(int j=0 ; j<m ; j++) {

				// if same element 
				// then update table[j] based on curlen + 1
				if(arr1[i] == arr2[j]) {
					table[j] = Math.max(table[j], curlen + 1);
				}

				// if 2nd array's element is lesser 
				if(arr1[i] > arr2[j]) {
					if (table[j] > curlen)
						curlen = table[j];
				}

			}


		}

		for (int i=0; i<m; i++)
			if (table[i] > res)
				res = table[i];
		return res;
	}
	public static void main(String[] args)
	{
		int arr1[] = {3, 4, 9, 1};
		int arr2[] = {5, 3, 8, 9, 10, 2, 1};

		int n = arr1.length;
		int m = arr2.length;

		System.out.println("Length of LCIS is " +
				LCIS(arr1, n, arr2, m));
	}
}
