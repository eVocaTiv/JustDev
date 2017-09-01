import java.util.*;
import java.io.*;
import java.math.*;
import java.time.*;

public class Main{
	private static int n , e;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited , pre , post , prev;
	private static Scanner sc = new Scanner(System.in);
	

	
	
	public static void main(String[] args){
		GetInp();
	}
	
	public static void DFS(){
		
	}
	
	public static void Explore(int v){
		
	}
	
	
	
	public static void GetInp(){
		
		//GET NO. OF NODES AND EDGES.
		n = sc.nextInt();
		e = sc.nextInt();
		
		
		//INITIALIZE CONTAINERS.
		visited = new ArrayList<Integer>();
		pre = new ArrayList<Integer>();
		post = new ArrayList<Integer>();
		
		prev = new ArrayList<Integer>();
		
		//..
		adj1 = (ArrayList<Integer>[]) new ArrayList[n];
		adj2 = (ArrayList<Integer>[]) new ArrayList[n];
		cost = (ArrayList<Integer>[]) new ArrayList[n];
		//..
		for(int i=0 ; i<n ; i++){
			adj1[i] = new ArrayList<>();
			adj2[i] = new ArrayList<>();
			cost[i] = new ArrayList<>();
			
			
			visited.add(0);
			pre.add(0);
			post.add(0);
			prev.add(-1);
			
		}
		
		//GET VALUES 
		
		int a , b, c;
		
		for(int i=0 ; i<e ; i++){
			a = sc.nextInt();
			b = sc.nextInt();
			//c = sc.nextInt();
			
			
			//UNDIRECTED GRAPH.
			adj1[a-1].add(b-1);
			adj2[b-1].add(a-1);
			
			//ADD COSTS TO BOTH VERTICES .
		//	cost[a-1].add(c);
		//	cost[b-1].add(c);
		}
		
		//System.out.println("Input successfully read!...");
		
		
	}


}
