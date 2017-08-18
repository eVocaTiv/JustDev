import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static Scanner s = new Scanner (System.in);
	private static ArrayList<Stock> list;
	static int n;
	static long k;
	static long res=0;



	public static class Stock{
		int price;
		int index;

		public Stock(int price , int index) {
			this.price = price;
			this.index = index;
		}
	}

	public static void ReadInp() {
		list = new ArrayList<>();
		res = 0;

		//GET STOCK ARRAY WITH INDEX!	
		n = s.nextInt();
		for(int i=0 ; i<n ; i++)
			list.add(new Stock(s.nextInt(), i));

		k = s.nextLong();
		//GET PAYMENT ARRAYLIST


	}



	public static void GetAns() {

		//SORT THE LIST WRT PRICE ASC. 
		//N*LOG(N)..
		list.sort(new Comparator<Stock>() {
			public int compare(Stock s1 , Stock s2) {
				if(s1.price<s2.price)
					return -1;
				if(s1.price>s2.price)
					return 1;
				return 0;
			}
		});



		//PROCESS THE LIST.
		//N*N...
		res=0;
		for(int i=0 ; i<n ; i++) {
			if(k<list.get(i).price)
				break;
			//else can atleast buy 1 of that stock.
			if(k>(long)(list.get(i).price)*(list.get(i).index+1)) {
				res+=list.get(i).index+1;
				k-=(long)(list.get(i).price)*(list.get(i).index+1);
			}
			else
				//THIS IS THE LAST PURCHASAL STOP.
			
				for(int j=1 ; j<=list.get(i).index+1 ; j++) {
					if(k>=list.get(i).price) {
						k-=list.get(i).price;
						res++;
					}
					else
						break;
				}
			
		}


		System.out.println(res);

	}

	public static void main(String[] args) {
		{

			ReadInp();
			GetAns();
		}

	}
}
