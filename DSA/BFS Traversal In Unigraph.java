import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
	private static ArrayList<Integer> visited , pre , post , list , recstack , dist , prev;


	public static void main(String[] args){

		list = new ArrayList<Integer>();
		visited = new ArrayList<Integer>();	
		post = new ArrayList<Integer>();	
		pre = new ArrayList<Integer>();	
		recstack=new ArrayList<Integer>();
		dist=new ArrayList<Integer>();
		prev=new ArrayList<Integer>();


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
		//FindSCC();
		//System.out.println(hasCycles);

		BFS(adj1 , 1);
		for(int d : dist){
			System.out.println(d);
		}

	}

	public static void BFS(ArrayList<Integer>[] adj  , int center){
		for(int i=0 ; i<n ; i++){
			dist.add(Integer.MAX_VALUE);
			prev.add(-1);
		}
		dist.set(center-1,0);

		Queue<Integer> q = new LinkedList();
		q.add(center-1);

		while(!q.isEmpty()){

			int top=q.poll();

			for(int w : adj[top]){
				if(dist.get(w)==Integer.MAX_VALUE){
					q.add(w);
					dist.set(w , dist.get(top)+1);
					prev.set(w, top);
				}
			}
		}
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
