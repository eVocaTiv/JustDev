import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] cost , price;
	static int t;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		t = sc.nextInt();
		while(t-->0) {
		
		n=sc.nextInt();
		price=new int[n];
		for(int i=0 ; i<n ; i++)
			price[i]=sc.nextInt();
		
		System.out.println(minPrice(price , n , n));
		
		
		}
	}
	
	public static int minPrice(int s[] , int n , int m ) {
		cost = new int[n];
		cost[0]=price[0];
		
		for(int i=1 ; i<n ; i++) {
			int current_cost=Integer.MIN_VALUE;
			int temp = Integer.MIN_VALUE;
			
			for(int j=0 ; j<i ; j++) {
				temp = Math.max(price[i], price[i-j-1]+ cost[j]);
				if(current_cost<temp)
					current_cost = temp;
			}
			cost[i]=current_cost;
		}

		
		return cost[n-1];
	}
}
