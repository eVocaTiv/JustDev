import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
	private static Scanner s;
	private static int n , e;
	private static int clock=0;
	private static int scc=0;

	//adj1 STORES G AND adj2 STORES G'.

	private static ArrayList<Integer>[] adj1 , adj2 ;
	private static ArrayList<Integer> visited , pre , post , list;


	public static void main(String[] args){

		list = new ArrayList<Integer>();
		visited = new ArrayList<Integer>();	
		post = new ArrayList<Integer>();	
		pre = new ArrayList<Integer>();	


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
		DFSRev();
		FindSCC();

		System.out.println(scc);

	}


	public static void FindSCC(){
		SortRevPost();
		for(int i=0 ; i<n ; i++){
			visited.set(i , 0);
		}
		//PROCESSING WRT REVERSE POST ORDER TO FIND SCCS.
		for(int v : list){
			if(visited.get(v)==0){
				scc++;
				Explore(v , adj1);
			}
		}



	}

	public static void SortRevPost(){
		Collections.sort(list , new Comparator<Integer>(){
			public int compare (Integer a , Integer b){
				if(post.get(a)<post.get(b))
					return 1;
				if(post.get(a)>post.get(b))
					return -1;
				return 0;
			}
		});


	}



	public static void DFSRev(){
		for(int i=0 ; i<n ; i++){
			if(visited.get(i)==0){
				Explore(i , adj2);
			}
		}
	}

	public static void Explore(int i , ArrayList<Integer>[] adj){
		visited.set(i,1);
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
			list.add(i);
		}
		
		for(int i=0 ; i<e ; i++){

			int a=s.nextInt();
			int b=s.nextInt();
			
			adj1[a-1].add(b-1);
			adj2[b-1].add(a-1);
		}
	}



}
