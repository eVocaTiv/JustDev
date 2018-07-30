
public class Main {
	static int res = 0;
	static int V = 4;
	static int count[][][];
	static int soln[][] = new int[V][V];

	public static boolean solveMaze(int maze[][], int x, int y) {
		// if dest reached
		if ( x == V-1 && y == V-1) {
			soln[x][y] = 1;
			printSolnMatrix(maze);
			return true;
		}
		else {
			soln[x][y] = 1;
			if ( y + 1 < V && maze[x][y+1] != 0 && solveMaze(maze, x, y+1) == true) {
				return true;
			}
			else
				if ( x + 1 < V && maze[x+1][y] != 0 && solveMaze(maze, x+1, y) == true) {
					return true;
				}
				else {
					soln[x][y] = 0;
					return false;
				}
		}
	}

	public static void printSolnMatrix(int maze[][]) {
		for(int i=0 ; i<V ; i++) {
			for(int j=0 ; j<V ; j++) {
				System.out.print(soln[i][j] + " ");
				}
			System.out.println();
		}
			
	}
	// Driver method
	public static void main(String args[])
	{
		int maze[][] = {{1, 0, 0, 0},
				{1, 1, 0, 1},
				{0, 1, 0, 0},
				{1, 1, 1, 1}
		};
		for(int i=0 ; i<V ; i++)
			for(int j=0 ; j<V ; j++) {
				soln[i][j] = 0;
			}
		solveMaze(maze, 0 , 0);
	}
}
