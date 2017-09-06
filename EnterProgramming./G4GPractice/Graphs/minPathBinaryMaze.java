import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] a, visited;
	static int n , m;
	static Queue<Point> q;
	static Scanner sc = new Scanner(System.in);
	static int[] row = new int[] {-1 , 0 , 0 , 1};
	static int[] col = new int[] {0 , -1 , 1 , 0};


	static int t;

	public static class Point {
		int f;
		int s;
		int dist;

		public Point(int s , int d , int dist) {
			this.f = s;
			this.s = d;
			this.dist = dist;
		}
	}

	public static void addValidNeighbours(Point p) {
		for(int i=0 ; i<4 ; i++) {
			int x = p.f + row[i];
			int y = p.s + col[i];

			/*
			 * System.out.println("rawxy : "+ x + y);

			if(x>=0 && x<n && y>=0 && y<n) {

				System.out.println("xy : " +x + y);
				System.out.println(" a[x][y] is " + a[x][y]);
			}

			 */
			if(x>=0 && x<m && y>=0 && y<n && a[x][y]==1 && visited[x][y]==0) {
				q.add(new Point(x , y, p.dist+1));
				//	visited[x][y]=1;
				//	System.out.println("adding pt " + x  + y );
			}

		}
	}

	public static int getAns(int[][] a , Point s1 , Point s2) {
		int res = 0 ;


		if(a[s1.f][s1.s]==0 || a[s2.f][s2.s]==0)
			return -1;

		q = new LinkedList();

		q.add(new Point(s1.f , s1.s , 0));

		while(!q.isEmpty()) {

			Point p = q.poll();
			visited[p.f][p.s]=1;

			if(p.f==s2.f && p.s == s2.s)
				return p.dist;
			addValidNeighbours(p);
		}



		return res;
	}

	public static void main(String[] args) {
		t=sc.nextInt();
		while(t-- > 0) {
			m= sc.nextInt();
			n= sc.nextInt();
			a= new int[m][n];

			visited= new int[m][n];
			//READ INPUT.
			for(int i=0 ; i<m ; i++)
				for(int j=0 ; j<n ; j++) {
					a[i][j]=sc.nextInt();
					visited[i][j]=0;
				}

			Point source = new Point(sc.nextInt() , sc.nextInt() , 0);
			Point dest = new Point ( sc.nextInt() , sc.nextInt() , Integer.MAX_VALUE);
			System.out.println(getAns(a , source , dest));

			
		

	}



}

}
