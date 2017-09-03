import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[] l ,  a;


	public static void LIS() {
		l[0]=1;
		l[1]=1;

		for(int i=1 ; i<n ; i++) {
			l[i]=1;
			for(int j=0 ; j<i  ; j++)
				if(a[i]>a[j])
					l[i]=Math.max(l[i], l[j]+1);
					//l[i] = l[j]+1;
		}
		for(int x : l)
			System.out.print(x + " ");
		System.out.println();

		int max = 1;
		for(int i=0 ; i<n ; i++) {
			if(l[i]>max)
				max = l[i];
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		//n = sc.nextInt();
		//a = new int[n];
		a = new int[]{ 10 , 22 , 9 ,  33 , 21 , 50  , 41 , 60  , 80};
		n = 9;
		l = new int[n];
		//for(int i=0 ; i<n ; i++)
		//	a[i]=sc.nextInt();

		LIS();
	}


}
