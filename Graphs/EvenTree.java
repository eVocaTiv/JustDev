import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	static Scanner sc = new Scanner(System.in);
	static int n , e , res =0;
	static ArrayList<Integer>[] adj;
	static ArrayList<Integer> visited;

	public static void readInp() {
		n = sc.nextInt();
		e = sc.nextInt(); 

		adj = (ArrayList<Integer>[]) new ArrayList[n];
		visited = new ArrayList<>();

		for(int i=0 ; i<n ;i++) {
			adj[i] = new ArrayList<>();
			visited.add(0);
		}

		for(int i=0 ; i<e ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			adj[a-1].add(b-1);
			adj[b-1].add(a-1);
		}



	}


	public static void DFS() {

		Explore(0);

	}

	public static int Explore(int v) {
		int nodes = 0;
		int carryup = 0;
		visited.set(v, 1);

	   
		
		for(int w : adj[v]) {
			if(visited.get(w)==0) {
				nodes = Explore(w);
				if(nodes %2==0) {
					res++;
				}
				else {
					carryup += nodes;	
				}
			}
		}
		//DETACH

		return carryup+1;
	}

	public static void main(String [] args) {
		readInp();
		DFS();
		System.out.println(res);
	}




}
