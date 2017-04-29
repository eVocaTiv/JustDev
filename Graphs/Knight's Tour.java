import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;


public class Main {
	private static ArrayList<Integer>  pre , post , dist , prev ;
	static int[] rowoff , coloff;
	private static 	HashMap<Integer , Integer> vis = new HashMap<>();
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited;
	private static int n , e , st;
	private static int clock = 0;
	private static Node start , end;
	private static Scanner s  = new Scanner(System.in);
	
	public static class Node{
		public int x , y;
		public int dist;
		public Node(int x , int y , int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	


	public static void main(String[] args){
		ReadInp();
		System.out.println(BFS(start , end));


	}

	public static int BFS(Node src , Node dest){
	   // src.dist = 0;
		Queue<Node> q = new LinkedList();
	
		
		q.add(src);
		
		while(!q.isEmpty()){
		    
		    Node top = q.poll();
	        int x= top.x;
		    int y= top.y;
		    int distance = top.dist;
		    //CHECK IF THIS IS THE DESTINATION NODE.
		    if (x==dest.x && y==dest.y)
		        return distance;
		        
		    
		      if(!vis.containsKey(x*15 + y*27)){
		            vis.put(x*15 + y*27 , 1);
		    
		    //IF NOT THEN ADD THE NEW NODES INTO THE QUEUE.      
		    for(int i=0 ; i<8 ; i++){
		        
		        int newx = x+rowoff[i];
		        int newy = y+coloff[i];
		        Node toadd = new Node(newx , newy , distance+1);

		           if(newx >=0 && newy>=0 && newx<=7 && newy<=7){
		                   toadd.dist = distance+1;
		                   q.add(toadd);
		                    
		               
		           }
		                   
		    }
		    
		}
	}
        return Integer.MAX_VALUE;
	}



	public static void ReadInp(){
	//	n = s.nextInt();
	//	e = s.nextInt();
	    
	    rowoff = new int[]{ 2, 2, -2, -2, 1, 1, -1, -1 };
	    coloff = new int[] { -1, 1, 1, -1, 2, -2, 2, -2 };
	    n=64;
		int a , b , c , d;
		a=s.nextInt();
		b=s.nextInt();
		c=s.nextInt();
		d=s.nextInt();
		start = new Node(a , b , 0);
		end = new Node(c , d ,100);
		
		
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
		
		
		//CREATE VISITED HASHMAP;
		
	
        //ADD EDGES FOR EVERY VERTEX.

	/*	for(int i=0 ; i<e ; i++){
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
		*/
	}

}
