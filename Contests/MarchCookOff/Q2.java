import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
	static int r , b , p , t;
	static BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException{
		t=Integer.parseInt(s.readLine());
		
		while(t-- > 0){
			String str[]=s.readLine().split(" ");
			r=Integer.parseInt(str[0]);
			b=Integer.parseInt(str[1]);
			p=Integer.parseInt(str[2]);
			
			int bt = r+b-p;	
			double res = ((double)p*(r/(double)(r+b))+ (double)bt*(b/(double)(r+b)));
			
			
			DecimalFormat df = new DecimalFormat("#0.0000000000");
			System.out.println((df.format(res)));
			
		}
		
		
		
	}

}
