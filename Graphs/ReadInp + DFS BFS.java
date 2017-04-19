import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	private static ArrayList<Integer>  pre , post , dist , prev;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited;
	private static int n , e;
	private static int clock = 0;
	private static Scanner s  = new Scanner(System.in);

	public static void main(String[] args){
		ReadInp();
		BFS(1);

		for(int i : dist){
			System.out.println(i);
		}
	}


	public static void Explore(int v , ArrayList<Integer>[] adj){
		visited.set(v , 1);
		pre.set(v, clock++);

		for(int w: adj[v]){
			if(visited.get(w)==0)
				Explore(w , adj);
		}

		post.set(v , clock++);
	}


	public static void BFS(int start){
		int mystart=start-1;
		Queue<Integer> q = new LinkedList();
		q.add(mystart);
		dist.set(mystart, 0);

		visited.set(mystart , 1);
		while(!q.isEmpty()){
			int top = q.poll();
			for(int w : adj1[top]){
				if(visited.get(w)==0){
					dist.set(w , dist.get(top)+1);
					visited.set(w,1);
					q.add(w);
				}
			}
		}

	}

	public static void DFS(){
		for(int i=0 ; i<n ; i++)
			if(visited.get(i)==0)
				Explore(i , adj1);
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

			//FILL 0 VALUES.
			visited.add(0);
			post.add(0);
			pre.add(0);
			prev.add(-1);
			dist.add(Integer.MAX_VALUE);

		}

		for(int i=0 ; i<e ; i++){
			a=s.nextInt();
			b=s.nextInt();
			// c=s.nextInt();

			// UNDIRECTED GRAPH TAKEN.

			adj1[a-1].add(b-1);
			adj1[b-1].add(a-1);



			//adj2[b-1].add(a-1);
			//cost[a-1].add(c);
			//cost[b-1].add(c);

		}
	}

}
