/* package whatever; // don't place package name! */

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static String swap(int x , int y , String s){

		char[] chars = s.toCharArray();

		//swap the 2 chars.
		char temp ;
		
		temp = chars[x];
		chars[x] = chars[y];
		chars[y] = temp;
		
		return String.valueOf(chars);
	}


	public void printPerm(String s , int i , int r){


		if(i==r)
			System.out.println(s);

		else
			for(int count = i ; count <=r ; count++) {
				s = swap( count , i , s);
				printPerm(s , i+1 , r);
				//s = swap( count , i  , s);
				
			}
		
	}


	private String s ;
	//private Scanner sc = new Scanner(System.in);



	public static void main (String[] args) throws java.lang.Exception
	{
		Main m = new Main();
		m.s = new String("ABC");
		m.printPerm(m.s , 0  , m.s.length()-1);


		// your code goes here
	}
}
