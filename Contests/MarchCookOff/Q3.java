import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	private static int n,e,count;
	private static ArrayList<Integer>[] adj;
	private static ArrayList<Integer> visited , post , pre;
	private static Scanner s = new Scanner(System.in);
	private static int [][] colors ;

	public static void main(String[] args){
		count=0;
		visited = new ArrayList<>();
		pre = new ArrayList<>();
		post = new ArrayList<>();
		n = s.nextInt();
		//e = s.nextInt();
		for(int i=0 ; i<n ;i++)
			visited.add(0);	
		adj = (ArrayList<Integer>[])new ArrayList[n];
		colors = new int[n][n];

		for(int i=0 ; i<n ; i++){
			adj[i] = new ArrayList<Integer>();

		}
		
		
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				colors[i][j]=s.nextInt();

		
		Queue<Integer> q;
		q=RainBow();
		
		for(int i: q){
			int qi = i+1;
			System.out.println(qi);
		}
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
			if(visited.get(w)==0)
				Explore(w);
			

		}
		PostVisit(v);
	}


	public static Queue<Integer> RainBow(){
		Queue<Integer> res = new LinkedList();
		for(int i=0 ; i<n ; i++)
			res.add(i);
		int counter=0;
		boolean changed=true;
		
		while(true){
			counter++;
			
			int v=res.peek();
			int colors=0;
			HashSet<Integer> map = new HashSet<Integer>();
			for(int i : res){
				if(i != v)
				map.add(Main.colors[v][i]);
			}
			//System.out.println("Map size is " + map.size());
			if(map.size()<=1){
				res.poll();
				changed=true;
			}
			else{
				int toadd = res.poll();
				res.add(toadd);
				changed=false;
			}
			if(counter>n && !changed){
				return res;
			}

		}
		

	}


}
