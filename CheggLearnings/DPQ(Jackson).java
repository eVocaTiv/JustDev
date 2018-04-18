import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Packman {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int r, c;
	static long[][] cost , pathsum;
	static long minsum = 0;
	static HashSet<String> pathstrings = new HashSet<>();
	static StringBuilder pathstr = new StringBuilder(); 	

	public static void getAns() {

		pathsum = new long[r][c];
		//BASE CASES
		pathsum[0][0] = 0;
		for(int i=1 ; i<c ; i++)
			pathsum[0][i]=pathsum[0][i-1] + cost[0][i];
		for(int i=1 ; i<r ; i++)
			pathsum[i][0]=pathsum[i-1][0] + cost[i][0];

		for(int i=1 ; i<r ; i++) {
			for(int j=1 ; j<c ; j++) {
				pathsum[i][j] = (long)(Math.max(pathsum[i-1][j], pathsum[i][j-1]) + cost[i][j])%(long)(Math.pow(10, 9)+7);	
			}
		}

		System.out.print(pathsum[r-1][c-1] + " ");




	}

	public static void getPath(int x , int y , String cstr) {
		//	System.out.println("X and Y : " + x + " " + y );
		if(x==0&&y==0) {
			pathstrings.add(new StringBuilder(cstr).reverse().toString());
			return;
		}
		if(x-1<0) {
			getPath(x , y-1 , cstr + "R");
		}
		if(y-1<0) {
			getPath(x-1 , y , cstr + "D");
		}
		if(x-1 >=0 && pathsum[x][y]==pathsum[x-1][y]+cost[x][y]) {
			//System.out.println("iff");
			//		pathstr.append("D");
			getPath(x-1 , y , cstr + "D");
		}
	
			if(y-1 >=0 && pathsum[x][y]==pathsum[x][y-1]+cost[x][y]) {
				//System.out.println("elsee");
				//	pathstr.append("D");
				getPath(x, y-1 , cstr + "R");
			}
	}

	public static void main(String[] args) throws IOException {

		String s = br.readLine();
		String[] str = s.split(" ");
		r = Integer.parseInt(str[0]);
		c = Integer.parseInt(str[1]);

		cost = new long[r][c];

		for(int i=0 ; i<r ; i++) {
			String s2 = br.readLine();
			//	System.out.println("readline is " + s2);
			String[] str2 = s2.split(" ");

			for(int j=0 ; j<c ; j++) {
				if(str2[j].charAt(0)==('P')|| str2[j].charAt(0)==('E'))
					cost[i][j]=0;
				else
					cost[i][j] = Integer.parseInt(str2[j]);
			}
		}
		getAns();
		getPath(r-1, c-1 , "");
		System.out.println(pathstrings.size());
		
		ArrayList<String> list = new ArrayList<>();
		list.addAll(pathstrings);
		Collections.sort(list);
		System.out.println(list.get(0));
	}


}
