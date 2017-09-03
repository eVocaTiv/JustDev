import java.io.*;
import java.util.*;

public class Solution {

    private static Scanner sc = new Scanner(System.in);
    private static int n , q;
    private static HashMap<String , Integer> map;
    
    
    public static void main(String[] args) {
        n = sc.nextInt();
        map = new HashMap<>();
        
        // READ ALL THE STRINGS AND PUT THEM INTO A HASHMAP WITH THEIR COUNT.
        for(int i=0 ; i<n ; i++){
            String s = sc.next();
            if(!map.containsKey(s))
                map.put(s , 1);
            else
                map.put(s , map.get(s)+1);
        }
        
        //GET ANS.
        
        q = sc.nextInt();
        
        //PROCESS EACH QUERY.
        for(int i=0 ; i<q ; i++){
            String sq = sc.next();
            if(!map.containsKey(sq))
                System.out.println(0);
            else
                System.out.println(map.get(sq));
        }
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
