import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	private static Scanner s;
	private static int n , e;
	private static int clock=0;
	private static int scc=0;
	private static Stack<Integer> visstack ;
	private static boolean hasCycles=false;
	//adj1 STORES G AND adj2 STORES G'.

	private static ArrayList<Integer>[] adj1 , adj2 ;
	private static ArrayList<Integer> visited , pre , post , list , recstack;


	public static void main(String[] args){

		list = new ArrayList<Integer>();
		visited = new ArrayList<Integer>();	
		post = new ArrayList<Integer>();	
		pre = new ArrayList<Integer>();	
		recstack=new ArrayList<Integer>();


		s=new Scanner(System.in);	
		n = s.nextInt();
		e = s.nextInt();

		adj1=(ArrayList<Integer>[]) new ArrayList[n];
		adj2=(ArrayList<Integer>[]) new ArrayList[n];

		for(int i=0 ; i<n ; i++){
			adj1[i]=new ArrayList<>();
			adj2[i]=new ArrayList<>();
		}




		//INITIALIZE ARRAYLISTS.

		ReadInp();
		DFS(adj1);
		//FindSCC();
		System.out.println(hasCycles);

	}


	public static void DFS(ArrayList<Integer>[] adj){
		for(int i=0 ; i<n ; i++){
			int parent=i;
			if(visited.get(i)==0){
				Explore(i , adj , parent);
			}
		}
	}

	public static void Explore(int i , ArrayList<Integer>[] adj , int parent){
		visited.set(i,1);
		recstack.set(i , 1);
		pre.set(i,clock++);
		for(int w : adj[i]){
			if(recstack.get(w)==1 && w!=parent)
				hasCycles=true;
			if(visited.get(w)==0)
				Explore(w , adj , i);
		}
		recstack.set(i, 0);
		post.set(i,clock++);
	}

	public static void ReadInp(){
		for(int i=0 ; i<n ; i++){
			post.add(0);
			pre.add(0);
			visited.add(0);
			list.add(i);
			recstack.add(0);

		}


		for(int i=0 ; i<e ; i++){

			int a=s.nextInt();
			int b=s.nextInt();

			adj1[a-1].add(b-1);
			adj1[b-1].add(a-1);
			adj2[b-1].add(a-1);

		}
	}



}
