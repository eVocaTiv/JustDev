import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


//BINARY SEARCH CODE.

public class Main{

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Scanner s;
	private static int n ;

	public static void main(String [] args){

		//INITIALIZE AND READ INPUTS.
		s = new Scanner(System.in);	
		n = s.nextInt();

		//FILL ARRAY.
		for(int i=0 ; i<n ; i++)
			list.add(s.nextInt());
		//INPUT KEY TO SEARCH FOR
		int key = s.nextInt();


		Collections.sort(list);

		System.out.println(BinarySearch(0, list.size()-1 , key));

	}


	public static int BinarySearch(int low , int high , int key ){
		
	

		if(low <= high){
			int mid = (high + low)/2;
			if(key == list.get(mid))
				return mid;
			if(key > list.get(mid))
				return BinarySearch(mid+1, high, key);	
			return BinarySearch(low, mid-1, key);

		}
		//REACH HERE IF ELEMENT IS NOT PRESENT IN THE ARRAY , SO RETURN -1.
		return -1;
	}

}
