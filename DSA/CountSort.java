/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int n=8;
		int[] arr = new int[]{3,3,1,2,2,1,1,2};
		int[] count = new int[n];
		int[] out = new int[n];
		
		// STEP 1
		for(int i : arr){
			count[i]++;
		}
		
		// STEP 2
		
		for(int i=1 ; i<n ; i++){
			count[i]+=count[i-1];
		}
		
		//STEP 3
		//BUILD OUTPUT ARRAY.
		
		for(int i=0 ; i<n ; i++){
			out[count[arr[i]]-1] = arr[i];
			count[arr[i]]--;
		}
		
		for(int i: out){
			System.out.println(i);
		}
		
		
		// your code goes here
	}
}
