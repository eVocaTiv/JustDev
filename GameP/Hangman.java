import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static String toDisplay , Secret;
	private static char c ;
	private static boolean guess = false;
	public static void main(String[] args){

		toDisplay = new String();
		Secret = sc.nextLine();
		for(int i=0 ; i<Secret.length() ; i++){
			toDisplay = toDisplay + "*";
		}

		System.out.println("The current string is " + toDisplay);



		while(!guess){
			System.out.println("Please Enter your next Guess");
			//INPUT NEXT GUESS CHARACTER.
			c=sc.next().charAt(0);
			if(!(Secret.indexOf(c)>=0)){
				System.out.println("Wrong!");
				System.out.println("The current string is " + toDisplay);
			}else{
				//CORRECT GUESS
				String temp = new String(toDisplay);
				String newDisplay = new String();
				for(int i=0 ; i<temp.length(); i++){
					if(Secret.charAt(i)==c){
						//System.out.println(true);
						newDisplay += c;
					}
					else{
						newDisplay += temp.charAt(i);
					}
				}
				
				toDisplay = newDisplay;
				System.out.println("The current string is " + toDisplay);
				
				if(toDisplay.equals(Secret))
					guess = true;


			}
			
		}		
		

		System.out.println("Congratulations , you've won the game!");


	}



}
