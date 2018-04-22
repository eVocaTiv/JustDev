/* Class NameSearch demonstrates the quickSort and 
  binarySearch methods. */
public class NameSearch {
	//sort the array of strings using quick sort algorithm 
	public void quickSort(String femaleNames[]) 
	{
		doQuickSort(femaleNames, 0, femaleNames.length -1) ;
	}
	// doQuickSort method
	private void doQuickSort(String femaleNames[], int start, int end) 
	{
		int pivotPoint; 
		if (start < end)
		{
			// get the pivot point
			pivotPoint = partition(femaleNames, start, end);
			// sort the first sublist 
			doQuickSort(femaleNames, start, pivotPoint -  1);
			// sort the second sublist 
			doQuickSort(femaleNames, pivotPoint + 1, 
					end);
		}
	} // end of doQuickSort method

	// partition method
	private int partition(String femaleNames[], int start, 
			int end)
	{
		String pivotValue; 
		int endOfLeftList; 
		int mid;

		// find the middle element 
		mid = (start + end) / 2;

		// call to swap method 
		swap(femaleNames, start, mid);

		// save the pivotValue 
		pivotValue = femaleNames[start];

		// save the endOfLeftList value 
		endOfLeftList = start;

		// sort the names in the given array 
		for(int i = start + 1; i <= end; i++)
		{
			if(femaleNames[i].compareTo(pivotValue) < 0)
			{
				endOfLeftList++;
				// call to swap method 
				swap(femaleNames, endOfLeftList, i);
			}
		}

		// call to swap method
		swap(femaleNames, start, endOfLeftList);

		return endOfLeftList;
	} // end of partition method

	//swap method
	private void swap(String femaleNames[], int a, int b)
	{
		String temp;
		temp = femaleNames[a]; 
		femaleNames[a] = femaleNames[b];
		femaleNames[b] = temp; 
	} // end of swap method
	/* binarySearch method finds the given name in the 
sorted array */
	public int binarySearch(String firstNames[] , String 
			name)
	{
		return doBinarySearch(firstNames, 0, firstNames.length - 1, name);
	} // end of binarySearch method

	// doBinarySearch method
	private int doBinarySearch(String firstNames[], int first, int last, String name)
	{
		int middle = 0;

		// return -1, if the name o is not in the array 
		if (first > last)
			return -1;

		// find the middle position 
		middle = (first + last) / 2;

		// find the position of the given name 
		if(firstNames[middle].compareTo(name) < 0)
			return doBinarySearch(firstNames, middle +
					1, last, name);
		else if(firstNames[middle].compareTo(name) > 0) 
			return doBinarySearch(firstNames, first, 
					middle - 1, name);
		else
			return middle;
	}// end of doBinarySearch
} // end of NameSearch class














