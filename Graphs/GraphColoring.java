import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	private static PriorityQueue<Integer> pq;
	private static ArrayList<Integer> visited , dist , primcost;
	private static ArrayList<Integer>[] adj1 , adj2, cost;
	private static int mstsum = 0;
	private static int n,e;
	private static int clock =0;
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Integer> isColorAv , Fill;



	public static void main(String[] args) {
		readInp();
		//System.out.println("input read!");
		//Dijkstra(1);
		//Prims(1);
		//System.out.println(mstsum);
		//	for(int x : dist)
		//		System.out.print(x + " ");

		
		graphColorer();
		for(int x : Fill)
			System.out.print(x + " ");
	}



	public 	static void readInp() {
		n = sc.nextInt();
		e = sc.nextInt();
		

		visited = new ArrayList<>();
		dist    = new ArrayList<>();
		primcost = new ArrayList<>();
		
		Fill = new ArrayList<>();
		isColorAv = new ArrayList<>();
		

		adj1 = (ArrayList<Integer>[]) new ArrayList[n];
		adj2 = (ArrayList<Integer>[]) new ArrayList[n];
		cost = (ArrayList<Integer>[]) new ArrayList[n];

		
		//INITIALIZE CONTAINERS
		for(int i=0 ; i<n ; i++) {
			adj1[i] = new ArrayList<Integer>();
			adj2[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
			visited.add(0);
			Fill.add(Integer.MAX_VALUE);
			isColorAv.add(1);
			primcost.add(Integer.MAX_VALUE);
			dist.add(Integer.MAX_VALUE);

		}


		//FILL VALUES ACCORDING TO TYPE OF GRAPH.
		for(int i=0 ; i<e ; i++) {

			int a = sc.nextInt();
			int b = sc.nextInt();
			//int c = sc.nextInt();

			//FOR UNDIRECTED GRAPH

			adj1[a-1].add(b-1);
			adj1[b-1].add(a-1);

			//cost[a-1].add(c);
			//cost[b-1].add(c);

		}
	}

	
	public static void graphColorer() {
		
		//fill vertex 0 with color 0.
		Fill.set(0 , 0);
		
		for(int i= 1 ; i<n ; i++) {
			int mincolor = 0;
			
			for(int w : adj1[i]) {
				if(Fill.get(w)!=Integer.MAX_VALUE)
					isColorAv.set(Fill.get(w), 0);
			}
			
			for(int k=0 ; k<n ; k++) {
				if(isColorAv.get(k)==1) {
					mincolor = k;
					break;
				}
			}
			
			Fill.set(i, mincolor);
			
			for(int w : adj1[i]) {
				if(Fill.get(w)!=Integer.MAX_VALUE)
				isColorAv.set(Fill.get(w), 1);
			}
		}
		
		
	}

	public static void Prims(int start) {
		int mystart = start -1;
		primcost.set(mystart, 0);

		PriorityQueue< Integer >primq = new PriorityQueue<>(10 , new Comparator<Integer>() {
			public int compare(Integer a , Integer b) {

				if(primcost.get(a)>primcost.get(b))
					return 1;
				if(primcost.get(a)<primcost.get(b))
					return -1;
				return 0;
			}
		});	


		for(int i=0 ; i<n ; i++) 
			primq.add(i);

		while(!primq.isEmpty()) {
			int top = primq.poll();
			//System.out.println("top is " + top );
			//System.out.println("adding " + primcost.get(top));
			mstsum+= primcost.get(top);

			for(int i=0 ; i<adj1[top].size() ; i++) {

				int w = adj1[top].get(i);
				//System.out.println(w);
				//	System.out.println(primq.contains(w));
				if(primq.contains(w) && primcost.get(w)>cost[top].get(i)) {
					//	System.out.println("-->" +  cost[top].get(i));
					primcost.set(w, cost[top].get(i));
				//	if(top == 1)
			//			System.out.println(primcost.get(w));
					primq.remove(w);
					primq.add(w);
				}
			}

		}



	}

	public static void Relax(int v) {

		for(int i=0 ; i<adj1[v].size() ; i++) {
			int w = adj1[v].get(i);

			if(pq.contains(w) && dist.get(w)>dist.get(v) + cost[v].get(i)) {
				dist.set(w, dist.get(v)+cost[v].get(i));
				pq.remove(w);
				pq.add(w);
			}

		}
	}

	public static void Dijkstra(int start) {
		int mystart = start-1;

		dist.set(mystart, 0);

		pq = new PriorityQueue<>(10 , new Comparator<Integer>() {
			public int compare(Integer a , Integer b) {

				if(dist.get(a)>dist.get(b))
					return 1;
				if(dist.get(a)<dist.get(b))
					return -1;
				return 0;
			}
		});	

		//ADD ALL TO THE UNEXPLORED REGION.
		for(int i=0 ; i<n ; i++) {
			pq.add(i);
		}

		while(!pq.isEmpty()) {
			int top = pq.poll();
			Relax(top);

		}

	}

	public static void Explore(int v) {
		visited.set(v, 1);
		for(int w : adj1[v]) {
			if(visited.get(w)==0) {
				Explore(v);
			}
		}

	}

	public static void BFS(int start) {
		int mystart = start-1;

		Queue<Integer> q = new LinkedList();


		q.add(mystart);
		dist.set(mystart, 0);

		visited.set(mystart, 1);

		while(!q.isEmpty()) {
			int top = q.poll();
			//visited.set(top, 1);
			for(int w : adj1[top]) {
				if(visited.get(w)==0) {
					visited.set(w, 1);
					dist.set(w, dist.get(top)+1);
					q.add(w);
				}
			}
		}


	}

	public static void DFS() {
		for(int i=0 ; i<n ; i++) {
			if(visited.get(i)==0) {
				Explore(i);
			}
		}
	}



}
