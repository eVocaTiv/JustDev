import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Solution {
	private static int n , t , k , csum;
	private static ArrayList<Integer> consec;
	private static ArrayList<Integer> list ;
	private static Scanner s ;

	public static void main(String[] args){

		s = new Scanner(System.in);

		t= s.nextInt();
		while(t-- > 0){
			n = s.nextInt();
			k = s.nextInt();

			list = new ArrayList<Integer>();
			consec = new ArrayList<Integer>();

			String string = s.next();
			
			char[] arr = string.toCharArray();
			int[] numarr = new int[string.length()];
			for(int index=0 ; index<string.length() ; index++){
				numarr[index] = Character.getNumericValue(arr[index]);
			}
			
			for(int i=0 ; i<string.length() ; i++){
				list.add(numarr[i]);
			}
			
			csum=1;

			for(int i=0 ; i<n-1 ; i++){

				if(list.get(i)==list.get(i+1))
					csum++;
				else{
					if(csum!=1){
						consec.add(csum);
					}
					csum=1;
				}

				if(i==n-2)
					if(csum!=1)
						consec.add(csum);
			}

		
			System.out.println(GetAns(consec , k));
			
			
		}
		
		
		
	}
	
	public static int GetAns(ArrayList<Integer> c , int k){
		
		 Comparator comparator = Collections.reverseOrder();
		 Collections.sort(c , comparator);
		 
		 if(k==0)
			 if(!c.isEmpty())
				 return c.get(0);
			 else
				 return 1;
		 
		 if(c.isEmpty())
			 return 1;
		 int second;
		 int current=0;
		 int currentmax;
		while(k-- > 0){
			if(c.get(current)==2)
				return 2;
			if(c.get(current)==1)
				return 1;
			
			if(c.get(current)%2==0)
				second=c.get(current)/2 -1;
			else
				second=c.get(current)/2;
			
			
			c.set(current,c.get(current)/2);
			currentmax = current;
			if(current-1 >=0)
				if(c.get(currentmax) < c.get(current-1))
					currentmax = current-1;
			
			if(current+1< c.size())
				if(c.get(currentmax)< c.get(current+1))
					currentmax = current+1;
			
			current = currentmax;
			
			}

		return c.get(current);
	
		
	}

}

