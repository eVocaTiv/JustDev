import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parser{
	public static void main(String[] args) throws FileNotFoundException{
		String cdir = System.getProperty("user.dir");
		System.out.println(cdir);
		File file = new File("/home/user/Desktop/cnprac/out.nam");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
	    int tp=0;
	    int rec = 0;
	    int sent=0;

		while(sc.hasNext()){
	
			String line = sc.nextLine();
			String[] linestr = line.split(" ");

            

			if(linestr[0].contentEquals("+") && (linestr[8].contentEquals("tcp")) && 
					 (linestr[6].contentEquals("3") || linestr[19].contains("3.")))			{
				    sent++;
			}
		
		    if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("tcp")) && 
					 linestr[6].contentEquals("3"))			{
				    tp++;
			}
		
		    if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("tcp")) && 
					 linestr[6].contentEquals("3"))			{
				    rec++;
			}
		

		}
	    System.out.println("Rec : " + rec);
	    System.out.println("sent : " + sent);
	    
		//System.out.println("TP is : " + tp);
		sc.close();
	}



}
