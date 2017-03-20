import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	static String string;
	static char[] arr ;
	static int n , m , t , rows , cols, trows , tcols;
	static boolean flag=false;

	public static boolean isInvalidPoint(){
		return (trows <0 ||trows >=n || tcols <0 || tcols>=m);
	}

	public static void main(String[] args){
		t=s.nextInt();

		while(t-- > 0 ){
			n=s.nextInt();
			m=s.nextInt();

			string=s.next();
			arr=new char[string.length()];
			arr=string.toCharArray();

			GetAns();
		}

	}


	public static void GetAns(){

		for( rows=0 ; rows<n ; rows++){
			for( cols=0; cols<m ; cols++){
				//System.out.println("point under consid is " + rows + cols);
				trows= rows;
				tcols = cols;
				int size=0;
				for(char c : arr){
					size++;
					switch(c){
					case 'U':					trows--;
					break;
					case 'D':					trows++;
					break;

					case 'L':					tcols--;
					break;

					case 'R':					tcols++;
					break;

					default : break;
					}
					if(isInvalidPoint()){
						//System.out.println("yes");
						break;
					}
					if(size==arr.length){
						System.out.println("safe");
						return;
					}
				}

			}

		}
		System.out.println("unsafe");
	}
}
