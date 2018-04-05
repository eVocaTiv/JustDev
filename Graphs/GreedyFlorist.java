import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int n , k , sum = 0;
	static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> cost , sofar;
    

	public static void main(String[] args) {
		n = sc.nextInt();		 
		k = sc.nextInt();
		cost = new ArrayList<>();
		sofar = new ArrayList<>();
		for(int i=0 ; i<n ; i++) {
			cost.add(sc.nextInt());
			sofar.add(0);
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>(10 , new Comparator<Integer>() {
			public int compare(Integer a , Integer b) {
				if(sofar.get(a)>sofar.get(b))
					return 1;
				return -1;
			}
		});
		
		int customer;
		Collections.sort(cost);
		Collections.reverse(cost);
		for(int i=0 ; i<k ; i++)
			q.add(i);
		//PURCHASE N FLOWERS.
		for(int i=0 ; i<n ; i++) {
			
			customer = q.poll();
			int purchasedsofar = sofar.get(customer);
			
			sum+= (purchasedsofar+1)*cost.get(i);
			
			sofar.set(customer, purchasedsofar+1);
			q.add(customer);
		}
		
		System.out.println(sum);
		

	}


}
