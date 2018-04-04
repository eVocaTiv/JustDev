import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//import java.util.Scanner;

public class Main{
	private static int n , e;
	static int mat[][];
	private static int t;
	private static int clock = 0;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited , pre , post , prev , dist;
//	private static Scanner sc = new Scanner(System.in);
	private static PriorityQueue<Integer> q;
	private static BufferedReader br = new BufferedReader( new InputStreamReader(System.in));



	public static void relax(int top){
		//RELAX ALL EDGES OF THIS NEW COVERED NODE.

		for(int i=0 ; i<adj1[top].size() ; i++){
			int w = adj1[top].get(i);
			if(q.contains(w) && dist.get(w)> dist.get(top) + cost[top].get(i) && dist.get(top)!= Integer.MAX_VALUE){
				dist.set(w , dist.get(top) + cost[top].get(i));
				q.remove(w);
				q.add(w);
			}


		}

	}

	public static void dj(int start){
		int mystart = start-1;
		dist.set(mystart , 0);
		//visited.set(mystart , 1);

		q = new PriorityQueue<Integer>(10 , new Comparator<Integer>(){
			public int compare(Integer a , Integer b){
				if(dist.get(a)>dist.get(b)){
					return 1;
				}
				if(dist.get(a)<dist.get(b)){
					return -1;
				}
				return 0;
			}
		});


		//Q IS THE UNCOVERED REGION.

		for(int i=0 ; i<n ; i++)
			q.add(i);

		while(!q.isEmpty()){
			relax(q.poll());
		}

	}


	public static void main(String[] args) throws NumberFormatException, IOException{
		t = Integer.parseInt(br.readLine());
		while(t-- > 0 ){
			GetInp();
			dj(Integer.parseInt(br.readLine()));

			for(int x : dist)
				if(x!=0)
					System.out.print(x==Integer.MAX_VALUE ? -1 + " " : x + " " );
			System.out.println();
		}
	}

	public static void BFS(int start){
		int mystart = start-1;
		dist.set(mystart , 0);
		visited.set(mystart , 1);

		Queue<Integer> q = new LinkedList();
		q.add(mystart);

		while(!q.isEmpty()){
			int top = q.poll();
			for(int w : adj1[top]){
				if(visited.get(w)==0){
					visited.set(w, 1);
					q.add(w);
					dist.set(w, dist.get(top)+1);
				}
			}

		}
	}





	public static void DFS(){
		for(int i=0 ; i<n ; i++)
			if(visited.get(i)==0)
				Explore(i , adj1);

	}

	public static void Explore(int v , ArrayList<Integer>[] adj){
		pre.set(v , clock++);
		visited.set(v, 1);
		for(int w : adj1[v]){
			if(visited.get(w)==0){
				visited.set(w , 1);
				Explore(w , adj1);
			}
		}
		post.set(v , clock++);

	}



	public static void GetInp() throws NumberFormatException, IOException{

		String sin = (br.readLine());
		String num [] = sin.split(" ");
		n = Integer.parseInt(num[0]);
		e = Integer.parseInt(num[1]);

	mat = new int[n][n];
		
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				mat[i][j]=Integer.MAX_VALUE;
		
		//GET NO. OF NODES AND EDGES.
		//n = sc.nextInt();
		//e = sc.nextInt();


		//INITIALIZE CONTAINERS.
		visited = new ArrayList<Integer>();
		pre = new ArrayList<Integer>();
		post = new ArrayList<Integer>();
		dist = new ArrayList<Integer>();
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

			dist.add(Integer.MAX_VALUE);
			visited.add(0);
			pre.add(0);
			post.add(0);
			prev.add(-1);

		}

		//GET VALUES 

		int a , b, c;

		for(int z=0 ; z<e ; z++){
			String edgein = br.readLine();
			String[] ea = edgein.split(" ");
			a = Integer.parseInt(ea[0]);
			b = Integer.parseInt(ea[1]);
			c = Integer.parseInt(ea[2]);
		
			
			
       
		
			if(mat[a-1][b-1]>c || mat[b-1][a-1]>c) {
				mat[a-1][b-1]=c;
				mat[b-1][a-1]=c;
			}

			// UNDIRECTED GRAPH TAKEN.
//			for(int i=0 ; i<adj1[a-1].size() ; i++) {
//				if(adj1[a-1].get(i)== b) {
//					if(cost[a-1].get(i)>c) {
//						cost[a-1].set(i, c);
//						cost[b-1].set(i, c);
//						continue;
//					}
//				}
//			}


		}
		
		for(int i=0 ; i<n ; i++)
				for(int j=0 ; j<n ; j++) {

					int x = mat[i][j];
					
					if(x!=Integer.MAX_VALUE) {
					adj1[i].add(j);
					adj1[j].add(i);

					cost[i].add(x);
					cost[j].add(x);
					
					}
				}

		//System.out.println("Input successfully read!...");


	}


}
