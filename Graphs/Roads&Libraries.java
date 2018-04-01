import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

	static ArrayList<Integer> compSizeList;
	static ArrayList<Integer>[] adj1;
	static ArrayList<Integer> visited ;
	static int compsize = 0;
	static long roadsAndLibraries(int n, int c_lib, int c_road) {
		long res = 0;
		// Complete this function
		
		
		
		long cc = countCC(n);
		//System.out.println("cc equals " + cc);
		//for(int x : compSizeList)
	    //	System.out.println(x);

		if(c_lib <= c_road)
			res = (long) c_lib * n;
		else
			for(int i = 0 ; i<cc ; i++) {
				//System.out.println(res);
				//System.out.println(compSizeList.get(i));
				res += (long)c_lib+ (long) c_road *(compSizeList.get(i)-1);
				//	System.out.println(res);
			}
		
		return res;
	}

	public static void Explore(int v) {
		//System.out.println(true);
		visited.set(v, 1);
		compsize++;
		for(int w : adj1[v])
			if(visited.get(w)==0)
				Explore(w);

	}
	public static int countCC(int n) {
		int cc = 0;
		compsize = 0;
			for(int i=0 ; i<n ; i++) {
				if(visited.get(i)==0) {
					cc++;
					Explore(i);
				}
				if(compsize!=0)
				compSizeList.add(compsize);
				compsize = 0;
			}
		return cc;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for(int a0 = 0; a0 < q; a0++){
			int n = in.nextInt();
			int m = in.nextInt();
			int c_lib = in.nextInt();
			int c_road = in.nextInt();
			int[][] cities = new int[m][2];
			adj1 = (ArrayList<Integer>[]) new ArrayList[n];
			visited = new ArrayList<>();
			 compSizeList = new ArrayList<>();
			for(int i=0 ; i<n ; i++) {
				adj1[i] = new ArrayList<>();
				visited.add(0);
			}

			for(int i=0 ; i<m ; i++) {
				int city1 = in.nextInt();
				int city2 = in.nextInt();


				// CONNECTED USING BIDIRECTIONAL ROADS.
				adj1[city1-1].add(city2-1);
				adj1[city2-1].add(city1-1);


			}

			long result = roadsAndLibraries(n, c_lib, c_road);
			System.out.println(result);
		}
		in.close();
	}
}
