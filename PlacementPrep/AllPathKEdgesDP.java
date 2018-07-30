
public class Main {
	static int res = 0;
	static int V = 4;
	static int count[][][];
	
	
	public static int countwalks(int[][] graph, int u , int v, int k) {
		count = new int [V][V][k+1];
		for(int e = 0 ; e <=k ; e++) {
			for(int i=0 ; i<V ; i++) {
				for(int j=0 ; j<V ; j++) {
					count[i][j][e] = 0;
					if( i == j && e ==0 )
						count [i][j][e] = 1;
					if ( e ==1 && graph[i][j] == 1)
						count [i][j][e] = 1;
					if ( e > 1) {
						for (int w =0 ; w< V ; w++)
							if ( w != i && graph[i][w] == 1) 
								count[i][j][e] += count[w][j][e-1];
					}
				}
			}
		}
		
		
		return count[u][v][k];
	}

	   // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        /* Let us create the graph shown in above diagram*/
        int graph[][] =new int[][] { 
        	{0, 1, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 1},
            {0, 0, 0, 0}
        };
        int u = 0, v = 3, k = 2;
//        KPaths p = new KPaths();
        System.out.println(countwalks(graph, u, v, k));
    }
}
