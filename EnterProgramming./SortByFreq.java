import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class Main{

	static int t, n;
	static Scanner sc = new Scanner (System.in);
	static int[] a;
	static HashMap<Integer , Integer> map ;
	static ArrayList<Integer> list;
	
	public static void getAns(){
		
		map = new HashMap<>();
	
		int f;
		for(int i=0 ; i < n ; i++){
			f=a[i];
			if(map.containsKey(f)){
				map.put(f, map.get(f)+1);
			}
			else
				map.put(f , 1);	
		
		}
	
		
	list = new ArrayList<>();
	
	//get an arraylist from the given array.
	for(int i=0 ;i<n ; i++){
		list.add(a[i]);
	}
	
	Collections.sort(list , new Comparator<Integer>(){
		public int compare(Integer a , Integer b){
			if(map.get(a)>map.get(b))
				return -1;
			if(map.get(a)<map.get(b))
				return 11;
			return 0;
		}
	});
	
	
	
	}

	public static void main(String [] args){

		t = sc.nextInt();

		while( t-- > 0 ){
			n=sc.nextInt();
			a=new int[n];
			int f;

			for(int i=0 ; i<n ;i++){
				a[i] = sc.nextInt();
		
			}


			getAns();
			for(int x : list)
				System.out.print(x + " ");

		}



	}

}
