import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static ArrayList<Integer> list;
	private static ArrayList<Integer> ilist;
	private static ArrayList<Integer> visited;
	private static int n ,swaps , t , cyclesize;
	private static HashMap<Integer , Integer> map = new HashMap<>();
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {


		t=s.nextInt();
		while(t-- > 0){
			visited = new ArrayList<>();
			list = new ArrayList<>();
			ilist = new ArrayList<>();
			swaps=0;

			 
			n=s.nextInt();

			for(int i=0 ; i<n ; i++)
				visited.add(0);
			for(int i=0 ; i<n ; i++)
				list.add(s.nextInt());

			Inorder(0); // O(N)
			GetPlace(); // O(N*LOGN + N ) 
						
			GetAns();   // O(N)
			System.out.println(swaps);
		}
	}

	public static void GetAns(){
		for(int v=0 ; v<n ; v++){

			cyclesize=0;
			
			if(visited.get(v)==0){
				cyclesize++;
				visited.set(v,1);
				int next=map.get(ilist.get((v)));
				
				while(visited.get(next)!=1){
					//System.out.println("Next for " + ilist.get(next) );
					//System.out.println("hi");
					visited.set(next,1);
					next=map.get(ilist.get(next));
					//System.out.println(" is " + ilist.get(next));
					cyclesize++;
					
				}
				
				swaps+=cyclesize-1;
			
			}
			
			
			
		}
		
		//System.out.println(swaps);
	}

	public static void GetPlace(){
		Collections.sort(list);

		for(int v=0 ; v<n ; v++){
			map.put(list.get(v), v);
		}
		//System.out.println(map.get(1004));
	}


	public static void Inorder(int i){
		if(Left(i)<n)
			Inorder(Left(i));
		ilist.add(list.get(i));
		if(Right(i)<n)
			Inorder(Right(i));
	}

	// UTILITY FUNCTIONS.


	public static int Left(int i){
		return 2*i+1;
	}

	public static int Right(int i){
		return 2*i+2;
	}

	public static int Parent(int i){
		return i/2;
	}



}
