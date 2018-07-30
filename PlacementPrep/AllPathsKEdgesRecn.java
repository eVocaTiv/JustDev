
public class Main {
	static int res = 0;
	static int V = 4;
	
	public static int countwalks(int[][] graph, int u , int v, int k) {
		if ( k==1 && graph[u][v] == 1 )
			return 1;
		if ( k==0 && u ==v )
			return 1;
		if( k<=0 )
			return 0;
		int count = 0;
		for(int i=0 ; i<V ; i++) {
			if(graph [u][i]==1)
				count += countwalks(graph, i	, v, k-1);
		}
		return count;
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
