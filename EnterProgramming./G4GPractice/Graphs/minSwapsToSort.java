import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> visited , pre , post , dist;
	static ArrayList<Integer>[] adj1 , adj2;
	static int t, n;
	static int[] a;
	static int cyclesize=0;
	static int res = 0;

	public static void ReadInp(){


		a=new int[n];

		visited = new ArrayList<>();


		for(int i=0 ; i<n ; i++){
			visited.add(0);
			a[i]= sc.nextInt();
		}

	}


	public static void Explore(int v){
		if(visited.get(v)==1){
			res+=cyclesize-1;
			cyclesize = 0;
			return ;
		}
		visited.set(v, 1);
		if(a[v]-1==v){
			cyclesize = 1;
			return;
		}

		else{
			//	System.out.println("increasing cycle size");
			cyclesize++;
			Explore(a[v]-1);
		}
	}


	public static int minSwaps(){
		res = 0;
		for(int i=0 ; i<n ; i++)
			visited.set(i , 0);

		for(int i=0 ; i<n ; i++){
			cyclesize=0;
			if(visited.get(i)==0)
				Explore(i);

		}


		return res;
	}

	public static void main(String [] args){
		t = sc.nextInt();

		while(t-- > 0 ){
			n=sc.nextInt();
			ReadInp();
			minSwaps();
			System.out.println(res);
		}



	}



}
