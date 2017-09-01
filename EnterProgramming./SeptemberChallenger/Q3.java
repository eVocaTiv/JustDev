import java.util.Scanner;


public class Main {
	private static Scanner sc;
	private static int t , n;
	private static int[][] letters;

	public static void GetReady(){
		n = sc.nextInt();
		letters = new int[26][1];
		
		
		//INITIALLY NO LETTER IS DETECTED.
		for(int i=0 ; i<26 ; i++)
			letters[i][0]=0;
		
		
	}	
	
	
	public static void GetAns(){
		
	}
	
	public static void main(String[] args){
		sc = new Scanner(System.in);
		
		t = sc.nextInt();
		
		while(t-- > 0){
			GetReady();
			GetAns();
		}
		
		
	}
}
