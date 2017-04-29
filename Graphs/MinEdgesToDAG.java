import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	private static int n,e,count;
	private static int res =0 ;
	private static ArrayList<Integer>[] adj;
	private static ArrayList<Integer> visited , post , pre;
	private static Scanner s = new Scanner(System.in);


	public static void main(String[] args){
		count=0;
		visited = new ArrayList<>();
		pre = new ArrayList<>();
		post = new ArrayList<>();
		n = s.nextInt();
		e = s.nextInt();
		for(int i=0 ; i<n ;i++)
			visited.add(0);	
		adj = (ArrayList<Integer>[])new ArrayList[n];

		for(int i=0 ; i<n ; i++)
			adj[i] = new ArrayList<Integer>();


		for(int i=0 ; i<e ; i++){
			int a = s.nextInt();
			int b = s.nextInt();

			adj[a-1].add(b-1);
		}
		ArrayList<Integer> list = new ArrayList<>();

		for(int i=0 ; i<n ;i++){
			post.add(0);
			list.add(i);
			pre.add(0);
		}
		DFS();

		Collections.sort(list, new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				if(post.get(a)<post.get(b))
					return 1;
				if(post.get(a)>post.get(b))
					return -1;
				return 0;
			}
		});
	
	
	/*	for(int i:list){
			int res=i+1;
			System.out.println(res);
		}
		
	*/
	boolean flag = false;
	//LIST NOW STORES THE TOPOLOGICAL SORTED ORDER OF THE GRAPH NODES.
	//RUNTIME IS  -------- O(V*E)
	
	
	
	for(int v = 0 ; v<list.size() ; v++){
	    //FOR EVERY VERTEX ON THE LEFT OF THE CURRENT VERTEX .
	    for(int u = 0 ; u<v ; u++){
	        for(int x : adj[list.get(u)]){
	            if(x == list.get(v))
	                flag = true;
	        }
	        if(flag==true){
	            flag=false;
	            continue;
	        }
	       else{
	     
	           res++;
	       }     
	    }
	}
	
	System.out.println(res);
    	
	
}

	public static void PostVisit(int v){
		post.set(v,count++);
	}

	public static void PreVisit(int v){
		pre.set(v,count++);
	}
	public static void DFS(){

		for(int i=0 ; i<n ; i++){
			visited.set(i, 0);
		}

		for(int i=0 ; i<n ; i++){
			if(visited.get(i)==0)
				Explore(i);
		}

	}

	public static void Explore(int v){
		visited.set(v, 1);
			PreVisit(v);
		for(int w : adj[v]){
			if(visited.get(w)==0){
		
			Explore(w);

			}
			PostVisit(v);
		}
	}


	public static void Dijkstra(){



	}


	public static void BFS(){


	}
}
