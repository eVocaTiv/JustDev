 import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;


public class Main {
	private static ArrayList<Integer>  pre , post , dist , prev , id;
	private static ArrayList<edges> Klist;
	private static ArrayList<Integer>[] adj1 , adj2 , cost;
	private static ArrayList<Integer> visited;
	private static int n , e;
	private static int clock = 0;
	private static int mstcost =0;
	private static Scanner s  = new Scanner(System.in);

	public static void main(String[] args){
		ReadInp();
		Kruskal();
		System.out.println(mstcost);
	}
	
	public static void Kruskal(){
		Collections.sort(Klist , new Comparator<edges>(){
		    public int compare(edges a , edges b){
		        if(a.getCost() > b.getCost())
		            return 1;
	            if(a.getCost() < b.getCost())
	                return -1;
	            return 0;
		    }
		});
	    
	    int mstedges = 0;
	    //PROCESS EDGEWISE ( SORTED IN ASCEDING ORDER WRT EDGECOST)
	   for(edges e : Klist){
	       if(mstedges == n-1)
	        break;
	       if(leader(e.src)==leader(e.dest))
	        continue;
	       else{
	           union(e.src , e.dest);
	           mstedges++;
	           mstcost += e.getCost();
	       }
	       
	   } 
	    
	}
	
	public static class edges{
	   
	    public int src;
	    public int dest;
	    int edgecost;
	   
	   public int getCost(){
	       return edgecost;
	   }
	    
	    public edges(int a , int b , int c){
	        src = a;
	        dest = b;
	        edgecost = c;
	    }
	}
	
	
	public static void union(int x ,int y){
        int leaderx = leader(x);
        int leadery = leader(y);
        id.set(leaderx , leadery);
    }
    
    //LEADER STORES THE TOP ROOT OF THE DISJOINT SUBSET
    public static int leader (int x){
        while(id.get(x)!=x){
            id.set(x , id.get(id.get(x)));
            x = id.get(x);
        }
        return x;
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
		id = new ArrayList<>();
		Klist = new ArrayList<>();

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
            id.add(i);
            
		}

		for(int i=0 ; i<e ; i++){
			a=s.nextInt();
			b=s.nextInt();
			c=s.nextInt();

			// UNDIRECTED GRAPH TAKEN.

			adj1[a-1].add(b-1);
			//adj1[b-1].add(a-1);
            cost[a-1].add(c);
            Klist.add(new edges(a-1 , b-1 , c));
    

			//adj2[b-1].add(a-1);
			//cost[a-1].add(c);
			//cost[b-1].add(c);

		}
	}

}
    
