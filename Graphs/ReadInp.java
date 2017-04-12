import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	private static ArrayList<Integer>  pre , post , dist , prev;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited;
	private static int n , e;
	private static Scanner s  = new Scanner(System.in);

	public static void main(String[] args){
		ReadInp();
		System.out.println("Hello");
	}




	public static void ReadInp(){
		n = s.nextInt();
		e = s.nextInt();
		int a , b , c;
		
		// INITIALIZE ARRAYLISTS.
		visited = new ArrayList<>();
		pre = new ArrayList<>();
		post  = new ArrayList<>();
		prev  = new ArrayList<>();
		dist  = new ArrayList<>();
		
		adj1 = (ArrayList<Integer>[])new ArrayList[n];
		adj2 = (ArrayList<Integer>[])new ArrayList[n];
		cost = (ArrayList<Integer>[])new ArrayList[n];
		
		for(int i=0 ; i<n ; i++){
			adj1[i]= new ArrayList<Integer>();
			adj2[i]= new ArrayList<Integer>();
			cost[i]= new ArrayList<Integer>();
		}
		
		for(int i=0 ; i<e ; i++){
			a=s.nextInt();
			b=s.nextInt();
			// c=s.nextInt();
			
			adj1[a-1].add(b-1);
			adj2[b-1].add(a-1);
			//cost[a-1].add(c);
			//cost[b-1].add(c);
			
		}
		
	}
	
}
