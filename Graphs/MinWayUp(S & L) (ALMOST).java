// IF THERE'S IS A LADDER AT  5 TO X THEN THIS ALGO. ASSUMES EDGES FROM 1 TO 5 THEN 5 TO X AS DIFFERENT EDGES
// ACTUALLY THERE MUST BE ONLY 1 TO X AS A DIRECT EDGE.
// ALSO ADJ LIST OF 5 HAS ONLY 1 EDGE TO X (THIS HAS BEEN IMPLEMENTED ALREADY) .

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> visited;
	static ArrayList<Integer> dist;
	static int quickestWayUp() {
		int res = 0;
		BFS();

		// Complete this function



		res = dist.get(99);
		return res-1;
	}

	public static void BFS() {
		for(int i=0 ; i<100 ; i++) {
			visited.add(0);
			dist.add(Integer.MAX_VALUE);
		}

		int mystart = 0;

		Queue<Integer> q = new LinkedList();
		q.add(mystart);
		visited.set(mystart, 1);
		dist.set(mystart, 0);
		while(!q.isEmpty()) {
			int top = q.poll();
			for(int w : adj[top])
				if(visited.get(w)==0) {
					
					//System.out.println(w);
					visited.set(w, 1);
					dist.set(w, dist.get(top)+1);
					q.add(w);
				}
			
		}

	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int a0 = 0; a0 < t; a0++){


			int n = in.nextInt();
			adj = (ArrayList<Integer>[]) new ArrayList[100];
			visited = new ArrayList<>();
			dist = new ArrayList<>();

			for(int i=0 ; i<100 ;i++)
				adj[i] = new ArrayList<>();



			for(int i=0 ; i<100 ;i++) {

				for(int j=i+1 ; j<=i+6 ; j++)
					if(j<100)
						adj[i].add(j);
			}

			for(int i=0 ; i<n ;i++)	{

				int a = in.nextInt();
				int b = in.nextInt();

				adj[a-1].clear();
				adj[a-1].add(b-1);

			}
			//REMOVE SNAKES AND LADDERS WALE.
			

			//REPLACE FOR SNAKES AND LADDERS.
	/*		
			for(int i=0 ; i<100; i++) {
				if(adj[i].size()==1) {		
					//System.out.println(adj[i].get(0));// snake or ladder starts here.
					
					for(int j=i-6 ; j<i ; j++) {
						if(j>=0)
							if(i-j-1>0)
							adj[j].remove(i-j-1);
					//		adj[j].add(adj[i].get(0));
					}
					
				}
			}
		*/	


			//    int[][] ladders = new int[n][2];
			//  for(int ladders_i = 0; ladders_i < n; ladders_i++){
			//     for(int ladders_j = 0; ladders_j < 2; ladders_j++){
			//        ladders[ladders_i][ladders_j] = in.nextInt();
			//}
			//}
			int m = in.nextInt();
			//int[][] snakes = new int[m][2];
			//for(int snakes_i = 0; snakes_i < m; snakes_i++){
			//	for(int snakes_j = 0; snakes_j < 2; snakes_j++){
			//		snakes[snakes_i][snakes_j] = in.nextInt();
			//	}
			for(int i=0 ; i<m ; i++)	{

				int a = in.nextInt();
				int b = in.nextInt();
				
				adj[a-1].clear();
				adj[a-1].add(b-1);
				//	adj[b-1].add(a-1);
			}


			//}
			int result = quickestWayUp();
			System.out.println(result);
		}	
		in.close();
	}
}
