public class Solution {
    public int automata(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C, int D, int E) {
        int n = A.size();
       
        //dp [state][moves left]
        int[][] dp = new int[n][E+1];
        
        // BASE CASE
        for(int i=0 ; i<n ; i++) {
             boolean isFinalState = C.contains(i);
             if ( isFinalState ) {
                 dp[i][0] = 1;
             } else {
                 dp[i][0] = 0;
             }
        }
        
        // bottom up fill
        for(int moves = 1 ; moves <=E ; moves ++){
            for(int state = 0; state <n ; state ++){
                dp[state][moves] += dp[A.get(state)][moves-1] + dp[B.get(state)][moves-1];
            }
        }
        
        return dp[D][E];
        
        
    }
}
