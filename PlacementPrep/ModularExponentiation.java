
// GIVEN X Y AND P
// COMPUTE (X^Y)%P


public class ModularExp {
	static int x,y,p;
	static long res = 1;
	public static void getAns() {
		// adjust if x > p
		x = x%p;
		
		while ( y > 0) {
			if ((y & 1)== 1) {
				//y is odd
				res = (res*x)%p;
			}
			// y is even now.
			// y = y/2
			y = y >> 1;
			x = (x*x)%p;
		}
		System.out.println(res);
	}
	
	public static void main(String[ ] args) {
		x = 2;
		y = 5;
		p = 13;
		
		
		getAns();
		//find (x^y)%p
	}
}
