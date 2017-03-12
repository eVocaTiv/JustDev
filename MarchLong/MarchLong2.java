import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int t;
	static Scanner s = new Scanner(System.in);


	public static void main(String[] args){

		t = s.nextInt();

		while(t-- > 0){
			ArrayList<Integer> list = new ArrayList<>();
			int n = s.nextInt();

			for(int i=0 ; i<n ; i++)
				list.add(s.nextInt());

			Collections.sort(list);

			for(int i=0 ; i<list.size() ; i++){
				if(i==list.size()-2){
					System.out.println(list.get(list.size()-1));
					break;
				}
				else
					if(i==0 && list.get(i)!=list.get(i+1)-1){
						System.out.println(list.get(0));
						break;
					}
					else
						if(list.get(i)!=list.get(i+1)-1){	
							System.out.println(list.get(i+1));
							break;
						}

			}




		}

	}


}
