import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static PriorityQueue<Mix> list = new PriorityQueue<>(3 , new Comparator<Mix>(){
		public int compare(Mix m1 , Mix m2){
			if(m1.b > m2.b)
				return 1;
			if(m1.b < m2.b)
				return -1;
			return 0;
		}
	});
	public static class Mix{
		private int a;
		private int b;
		
		Mix(int a , int b){
			this.a=a;
			this.b=b;
		}
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		
		for(int i=0 ; i<n ; i++){
			list.add(new Mix(s.nextInt() , s.nextInt()));
		}
	
		while(!list.isEmpty()){
			Mix m = list.poll();
			System.out.println(m.a + " " + m.b);
		}
		
		s.close();
	}
}
