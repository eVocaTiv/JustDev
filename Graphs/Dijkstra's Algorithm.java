import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
	private static ArrayList<Integer>  pre , post , dist , prev;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited;
	private static ArrayList<Integer> edges;
	private static PriorityQueue<Integer> q;
	private static int n , e , start , end;
	private static int clock = 0;
	private static Scanner s  = new Scanner(System.in);

	public static void main(String[] args){
		ReadInp();
		//DFS();
		Dijkstra(start);
		int d = dist.get(end-1);
		System.out.print(d==Integer.MAX_VALUE ? -1 : d);
		System.out.print(" " + edges.get(end-1));
	}

	public static void Dijkstra(int Start){

		//INITIALLT ONLY START VERTEX IN COVERED REGION.
		int mystart = Start-1;
		dist.set(mystart , 0);
		edges.set(mystart,0);

		q = new PriorityQueue<>(10 , new Comparator<Integer>(){
			public int compare(Integer a , Integer b){
				if(dist.get(a)>dist.get(b))
					return 1;
				if(dist.get(a)<dist.get(b))
					return -1;
				return 0;

			}
		});

		for(int i=0 ; i<n ; i++){
			q.add(i);
		}
		//System.out.println(q.size());

		while(!q.isEmpty()){
			int next = q.poll();
			int val = next + 1;
			Relax(next);

			//System.out.println("The distance array is with value as " + val + " is ");
			//	for(int x : dist)
			//	System.out.print (x + " ");
			//	System.out.println();
			//	System.out.println("queue size left is "+ q.size());

		}




	}
	// CHANGES ADDED
	// 1. Q.CONTAINS(W) IN IF STATEMENT ( TO CHECK IF THE NEIGHBOUR IS IN UNDISCOVERED AREA OR NOT
	//  , ONLY THEN UPDATE THE DISTANCE FOR IT.
	// 2. NEW IF CONDITION ( IF (DIST.GET(NEXT)!=INTEGER.MAX_VALUE ) . ONLY THEN UPDATE NEIGBOUR'S DISTANCE AS
	// DIST.GET(NEXT) + COST , ELSE LEAVE IT TO + INFINITY.
	// FIXED ERROR AS + INFINITY + COST ( 1 ) WAS GIVING -INFINITY!!
	public static void Relax(int next){

		for(int i=0 ; i<adj1[next].size() ; i++){

			//RELAX ALL NEIGHBOURS.
			int w = adj1[next].get(i);
			if(q.contains(w) && dist.get(w)>dist.get(next)+ cost[next].get(i)){
				if(dist.get(next)!=Integer.MAX_VALUE){
					dist.set(w , dist.get(next) + cost[next].get(i));
					edges.set(w,edges.get(next)+1);
					q.remove(w);
					q.add(w);
				}
			}
			else
				if(q.contains(w) && dist.get(w)==dist.get(next)+ cost[next].get(i)){
					if(dist.get(next)!=Integer.MAX_VALUE && edges.get(w)> edges.get(next) + 1)
						edges.set(w,edges.get(next)+ 1);
					q.remove(w);
					q.add(w);
				}

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
		edges = new ArrayList<>();

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
			edges.add(-1);

		}

		for(int i=0 ; i<e ; i++){
			a=s.nextInt();
			b=s.nextInt();
			c=s.nextInt();

			// UNDIRECTED GRAPH TAKEN.

			adj1[a-1].add(b-1);



			//adj2[b-1].add(a-1);
			cost[a-1].add(c);

		}
		start = s.nextInt();
		end = s.nextInt();
	}

}
