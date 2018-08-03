/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
 
 
 
public class Solution {
    public int cntMatrix(TreeNode A, TreeNode B) {
        if(A == null || B == null){
            return 0;
        }
        int res = 0 ;
        int val1 = A.val;
        int val2 = B.val;
        // if A empty
        if(val1 == -1) {
            if(val2 == -1){
                res = 0;
                return res;
            }
            else {
                A.val = 777;
                res = 1;
            }
        } else
        // if A has a value
        if(val1 != -1){
            if(val2 != -1){
                res = 0;
            } else {
                res = -1;
                return res;
            }
        }
        
        // if both not null
        // if(val1 == -1) {
        
        int res1 = 0;
        int res2 = 0;
        res1 = cntMatrix(A.left, B.left);
        res2 = cntMatrix(A.right, B.right);
        
        if(res1 == -1 || res2 == -1){
            return -1;
         } 
        
        return res + res2 + res1 ;
    
        
    }
}
