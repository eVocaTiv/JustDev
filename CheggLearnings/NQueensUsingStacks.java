import java.util.Stack;

/*  N Queen Problem using Stacks & backtracking */
public class NQueens
{ 
	static Stack<Integer> s ;
    static final int N = 4;
    // to keep track of current state of the NxN chessboard.
    // 1 represents Queen at a spot.
    // 0 means No Queen placed at that spot.
    static  int board[][] ;
  
    /* A utility function to print solution */
    void printSolution(Stack<Integer> s) 
    { 
        for (int i = 0; i < N; i++) 
        { 
            for (int j = 0; j < N; j++) 
            	if(board[i][j] == 1)
            		System.out.print(" Q ");
            	else
            		System.out.print(" * ");
            System.out.println(); 
        } 
    } 
  
    /* A utility function to check if a queen can 
       be placed on board[row][col]. 
		Here we check for conflicts for placing the queen
		1) from top in the current column
		2) right upper diagnol
		3) left upper diagnol
		*/
    boolean isSafe(int board[][], int row, int col) 
    { 
       int i, j; 

       //check current column for conflicts (only checking above of current spot ).
       // since we fill rowwise so the rows below than this haven't been filled , so we don't need to check for the full column.
        for (i = 0; i < row ; i++) 
            if (board[i][col] == 1) 
                return false; 
  
        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--) 
            if (board[i][j] == 1) 
                return false; 
  
        /* Check upper diagonal on right side */
        for (i=row, j=col; j<N && i>=0; i--, j++) 
            if (board[i][j] == 1) 
                return false; 

//        System.out.println("safe");
//        System.out.println(row + " " + col);
        return true; 
    } 
  
    /* An iterative utility function to solve N 
       Queen problem */
    boolean solveNQUtil(int board[][], int row, Stack<Integer> s) 
    { 
    	boolean success = false;
    	s = new  Stack<>();
    	int i = 0;
    	// we iterate rowwise.
    	// i keeps track of the current column we are considering in this row.
    	// the current row is given by x ( i.e size of stack ).
    	// the values in stack ( 0 indexed ) correspond to column values.
    	// and the index of stack ( 0 indexed )  gives the row value.
    	// so if the stack has only 1 element say 2.
    	// it means a queen is placed at - Row,Col : [ 0, 2 ]
    	
    	
    	/* base case: If all queens are placed i.e success is true
            or stack is empty. */
    
    	while(!success || s.isEmpty()) {
    		
    		// current row i.e x
    		// will be equal to the latest index of stack
    		// which is just the size of stack.
    		int x = s.size();
    		
    		// if a valid position is found in current row
    		// we proceed to next row
    		// else backtrack.
    		boolean validPos = false;
    		
    		// all queens placed.
    		if (x == N) {
    			printSolution(s);
    			success = true;
    			
    			
    			// Simple excercise left for you.
    			
    			// this solution only gives 1 answer.
    			// for all possible answers.
    			// continue searching from last row.
    			
    			
    			// backtrack after you find a solution
    			// from here- go to previous row.
    			// and in the previous row, consider the column value next to what you previous considered
    			// i.e lastcol + 1.
    			// be sure to update stack and the board[][].
    			//Something on these lines
//    			int lastcol = s.pop();
//    			x--;
//    			System.out.println(lastcol);
//    			board[x][lastcol] = 0;
//    			i = lastcol + 1;
//    			continue;
    		}
    		
    		// checks all possible column values for current row
    		// loops from i to N
    		// i stores the considered column position in this row.
    		for( ; i<N ; i++)
    			if(isSafe(board, x, i)) {
//    				System.out.println("safe for " + x + " " + i);
    				// place queen
    				board[x][i] = 1; 
    				s.push(i); // updates row by default since size increases.
    			    i=0; // for next row, we will consider column positions from the start
    			    validPos = true; 
    			    x++; 
    			    break; // move to next row i.e continue while loop
    			}
    			
    		// need to backtrack to previous row
    		if(!validPos) {
    			if(s.isEmpty())
    				// end 
    				break;
    			else {
    				// update board and stack.
    				// then backtrack to previous row.
    				int lastcol = s.pop();
    				board[x-1][lastcol] = 0; 
    				x--;
    				i = lastcol+1;
    			}
    		}
    	}

    	return success;
    } 
  
    /* This function solves the N Queen problem using 
       Backtracking.  It mainly uses solveNQUtil () to 
       solve the problem. You can modify solveNQUtil () 
       simply to produce all the possible solutions :) */
    void solveNQ(int N) 
    { 
    	// stack for holding positions.
    	s = new Stack<>();
    	
    	
    	// board to keep track of the positions of the queens on the chessboard.
       board = new int[N][N];
        for(int i=0 ; i<N ; i++)
        	for(int j=0 ; j<N ; j++)
        		board[i][j] = 0;

        //incase no solution exists
        // example for N=3
        if(solveNQUtil(board, 0, s) == false)
        	System.out.println("No solution exists!");
    } 
    // driver program to test above function 
    public static void main(String args[]) 
    { 
        NQueens Queen = new NQueens(); 
        Queen.solveNQ(N); 
    } 
} 
