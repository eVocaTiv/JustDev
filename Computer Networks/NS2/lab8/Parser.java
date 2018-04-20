import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class parser{
	public static void main(String[] args) throws FileNotFoundException{
		String cdir = System.getProperty("user.dir");
		System.out.println(cdir);
		File file = new File("/home/user/Desktop/lab7/lab8.nam");
		System.out.println(file.exists());
		Scanner sc = new Scanner(file);
		int throughput = 0;	

		while(sc.hasNext()){
			String line = sc.nextLine();
			String[] linestr = line.split(" ");
			if(linestr[0].contentEquals("r") && (linestr[8].contentEquals("cbr")) && 
					linestr[6].contentEquals("3"))			{

				throughput++;
			}//  			if(line.charAt(0)=='r'&& line("cbr") && line.contains("-d 3"))
			//				throughput++;				

			
		}

		System.out.println(throughput);
		sc.close();
	}



}
