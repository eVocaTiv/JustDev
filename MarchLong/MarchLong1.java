import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int t;
	private static Scanner s = new Scanner(System.in);
	
	
	public static void main(String[] args){
		t = s.nextInt();
		
		while(t-- > 0){
			int n = s.nextInt();
			
			ArrayList<Integer> xi = new ArrayList<>();
			ArrayList<Integer> yi = new ArrayList<>();
			
			
			for(int i=0 ; i <n ; i++)
				xi.add(s.nextInt());
			
			for(int i=0 ; i <n ; i++)
				yi.add(s.nextInt());
		
			int sum1 =0;
			int sum2= 0;
			
			for(int index=0; index <n ; index++){
				if(index%2==0){
					sum1+=xi.get(index);
					sum2+=yi.get(index);
				}
					else{
					sum1+=yi.get(index);
					sum2+=xi.get(index);
					}
			}	
			
			
			System.out.println(Math.min(sum1, sum2));
		}
		
		
		
	}
	
}
