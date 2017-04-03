import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	// ATTEMPT TO CODE THE QUICKSORT ALGORITHM.
	private static Scanner s = new Scanner(System.in);
	private static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args){

		//READ INPUT.

		int n = s.nextInt();
		for(int i=0 ; i<n ; i++){
			list.add(s.nextInt());
		}

		//SORT.

		QuickSort(list , 0 , list.size()-1);


		//PRINT SORTED ARRAY.

		for(int i=0 ; i<n ; i++){
			System.out.println(list.get(i));
		}


	}

	public static void QuickSort(ArrayList<Integer> list , int low , int high){
		if(low < high ){
			int pivotindex = Partition(list, low, high);

			QuickSort(list , low , pivotindex-1);
			QuickSort(list , pivotindex+1 , high);

		}

	}

	public static void Swap(int x , int y){
		int temp = list.get(x);
		list.set(x , list.get(y));
		list.set(y , temp );
	}
	
	public static int Partition(ArrayList<Integer> list , int low , int high ){
		int pivot = list.get(high);
		int l=low-1;
		int g=low-1;
		// TRAVERSE THE ARRAY USING 'low' , COMPARE WITH 'pivot' and INCREMENT l and g as per need.

		while(low < high){
			
			int y=list.get(low);
			
			if(y>pivot){
				low++;
				g++;
			}
			
			else{
				Swap(l+1 , low);
				low++;
				l++;
				g++;
			}

		}
		
		Swap(l+1 , high);


		return l+1;
	}


}
