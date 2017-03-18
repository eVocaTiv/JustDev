import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	private static Scanner s;
	private static int n , e , start;
	private static int clock=0;
	private static int scc=0;
	private static Stack<Integer> visstack ;
	private static boolean hasCycles=false;
	//adj1 STORES G AND adj2 STORES G'.

	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited , pre , post , dist , prev;


	public static void main(String[] args){

		visited = new ArrayList<Integer>();	
		post = new ArrayList<Integer>();	
		pre = new ArrayList<Integer>();	
		dist=new ArrayList<Integer>();
		prev = new ArrayList<Integer>();

		s=new Scanner(System.in);	
		n = s.nextInt();
		e = s.nextInt();

		adj1=(ArrayList<Integer>[]) new ArrayList[n];
		cost=(ArrayList<Integer>[]) new ArrayList[n];
		
		//adj2=(ArrayList<Integer>[]) new ArrayList[n];

		for(int i=0 ; i<n ; i++){
			adj1[i]=new ArrayList<>();
			cost[i]=new ArrayList<>();
			//adj2[i]=new ArrayList<>();
		}




		//INITIALIZE ARRAYLISTS.

		ReadInp();
		DFS(adj1);
		//FindSCC();
		//System.out.println(hasCycles);
		Dijkstra(start);
		
		for(int distnodes : dist){
			System.out.println(distnodes);
		}

	}


	public static void Dijkstra(int S){

		// WE MAINTAIN A REGION R OF VERTICES FOR WHICH THE SHORTEST ROUTE IS ALREADY KNOWN TO US.
		// THE FIRST ELEMENT ADDED TO R IS THE VERTEX S ( ROOT ).

		// ON EACH ITERATION WE TAKE A VERTEX OUTSIDE R HAVING MIN DIST. VALUE , ADD IT TO R AND RELAX ALL IT'S OUTGOING EDGES.



		for(int i=0 ; i<n ; i++){
			dist.add(Integer.MAX_VALUE);
		//	prev.add(-1);
		}


		dist.set(S-1 , 0);

		PriorityQueue<Integer> pq = new PriorityQueue<>(10 , new Comparator<Integer>(){
			public int compare(Integer a , Integer b){
				if(dist.get(a)>dist.get(b))
					return 1;
				if(dist.get(a)<dist.get(b))
					return -1;
				return 0;
				
				
			}
		});
		for(int i=0 ; i<n ; i++)
			pq.add(i);

		while(!pq.isEmpty()){
			int nodemin = pq.poll();


			//RELAX METHOD.

			for(int i=0 ; i<adj1[nodemin].size() ; i++){
				int w=adj1[nodemin].get(i);
				if(dist.get(w) > dist.get(nodemin) + cost[nodemin].get(i)){
					dist.set(w , dist.get(nodemin) + cost[nodemin].get(i));
				}
			}


		}

	}


	public static void DFS(ArrayList<Integer>[] adj){
		for(int i=0 ; i<n ; i++){
			if(visited.get(i)==0){
				Explore(i , adj);
			}
		}
	}

	public static void Explore(int i , ArrayList<Integer>[] adj){
		visited.set(i,1);
		;
		pre.set(i,clock++);
		for(int w : adj[i]){
			if(visited.get(w)==0)
				Explore(w , adj);
		}

		post.set(i,clock++);
	}

	public static void ReadInp(){
		for(int i=0 ; i<n ; i++){
			post.add(0);
			pre.add(0);
			visited.add(0);

		}


		for(int i=0 ; i<e ; i++){

			int a=s.nextInt();
			int b=s.nextInt();
			int c=s.nextInt();

			adj1[a-1].add(b-1);
			cost[a-1].add(c);
			//	adj2[b-1].add(a-1);

		}
		start=s.nextInt();
	}



}
