import java.util.HashMap;
import java.util.Scanner;

public class Main{
	static String str , res;
	static Scanner sc = new Scanner(System.in);
	static int t, n;
	static HashMap<Character , Integer> map;

	public static String RemoveDupl(){
		map = new HashMap<>();

		char[] arr = str.toCharArray();

		for(char c : arr){
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c , 1);
		}

		
		StringBuilder sb = new StringBuilder();

		for(char c : arr){
			if(map.containsKey(c)){
				sb.append(c);
				map.remove(c);
			}
		}

		return sb.toString();


	}

	public static void main(String [] args){
		t = sc.nextInt();

		while(t-- > 0){
			sc.nextLine();
			str=sc.nextLine();
			
			n = str.length();

			System.out.println(RemoveDupl());


		}
	}
}
