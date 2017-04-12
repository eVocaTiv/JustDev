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
	private static boolean isBP = true;
	//adj1 STORES G AND adj2 STORES G'.

	private static ArrayList<Integer>[] adj1 , adj2 ;
	private static ArrayList<Integer> visited , pre , post , list , recstack;
	private static ArrayList<Integer> cyclelen;
	private static ArrayList<Integer> colors;


	public static void main(String[] args){

		list = new ArrayList<Integer>();
		visited = new ArrayList<Integer>();	
		post = new ArrayList<Integer>();	
		pre = new ArrayList<Integer>();	
		recstack=new ArrayList<Integer>();
		cyclelen = new ArrayList<Integer>();
		colors = new ArrayList<Integer>();


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
		System.out.println(isBP);
		}
	


	public static void CheckBP(ArrayList<Integer>[] adj){


	}


	public static void DFS(ArrayList<Integer>[] adj){
		for(int i=0 ; i<n ; i++){
			int parent=i;
			if(visited.get(i)==0){
				colors.set(i, 1);
				Explore(i , adj , parent);
			}
		}
	}

	public static void Explore(int i , ArrayList<Integer>[] adj , int parent){
		visited.set(i , 1);

		// COLOR RED AKA COLORS.SET 1.
		if(colors.get(i)==0)
			if(colors.get(parent)==1)
				colors.set(i, 2);
			else	
				colors.set(i, 1);
		else
			// THIS NODE ALREADY HAS A COLOR.
			if(colors.get(parent)==colors.get(i) && i!=parent){
				isBP = false;
				return;
			}
		
		
		for (int w : adj[i]){
				
			{	if(colors.get(w)==0)
				Explore(w , adj , i);
				if(colors.get(w)==colors.get(i)){
					isBP = false;
					return;
				}
			}

		}
	}

	public static int CalculateRecOneSize(){
		int res =0;
		for ( int ones : recstack){
			if ( ones == 1)
				res++;
		}
		return res;
	}

	public static void ReadInp(){
		for(int i=0 ; i<n ; i++){
			post.add(0);
			pre.add(0);
			visited.add(0);
			list.add(i);
			recstack.add(0);
			colors.add(0);

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
