import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	private static ArrayList<Integer> list;
	private static int n,t,swaps;
	private static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		t=s.nextInt();

		while(t-- > 0){
			swaps=0;
			list = new ArrayList<>();
			n=s.nextInt();

			// ADD DEPARTURE TIMES.

			for(int i=0 ; i<n ; i++){
				list.add(s.nextInt());
			}

			//CONVERT TREE TO BST.
			//System.out.println(MinValue(0));
			ToBST(0);
			System.out.println(swaps);

			
			
		}
		
		


	}

	public static void Swap(int i , int j){
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j , temp);
	}

	public static void ToBST(int index){

		int rkey=list.get(index);
		int maxi = MaxValue(LeftChildIndex(index));
		int mini = MinValue(RightChildIndex(index));
		if(LeftChildIndex(index)<list.size())
			if(rkey < list.get(maxi)){
				Swap(index ,maxi);
				swaps++;
				ToBST(index);
			}
		if(RightChildIndex(index)<list.size())
		if(rkey > list.get(mini)){
			Swap(index , mini);
			swaps++;
			ToBST(index);
		}
		if(LeftChildIndex(index)<list.size())
			ToBST(LeftChildIndex(index));
		if(RightChildIndex(index)<list.size())
			ToBST(RightChildIndex(index));
		
	}

	public static int MinValue(int i){
		int res=i;
		if(i >= list.size())
			return ParentIndex(i);
		int min=list.get(i);
		if(LeftChildIndex(i)<list.size()){
			if(list.get(MinValue(LeftChildIndex(i))) < min){
				res=MinValue(LeftChildIndex(i));
				min= list.get(MinValue(LeftChildIndex(i)));
			}
		}
		if(RightChildIndex(i)<list.size()){
			if(list.get(MinValue(RightChildIndex(i))) < min){
				res=MinValue(RightChildIndex(i));
				min = list.get(MinValue(RightChildIndex(i)));
			}
		}
		return res;

	}

	public static int MaxValue(int i){
		int res=i;
		if(i >= list.size())
			return ParentIndex(i);
		int min=list.get(i);
		if(LeftChildIndex(i)<list.size()){
			if(list.get(LeftChildIndex(i)) > min){
				if(MaxValue(LeftChildIndex(i)) < list.size());{
					res=MaxValue(LeftChildIndex(i));
					min = list.get(MaxValue(LeftChildIndex(i)));
					}
			}
		}
		if(RightChildIndex(i)<list.size()){
			if(list.get(RightChildIndex(i))> min){
				if(MaxValue(RightChildIndex(i)) < list.size());{
				res=MaxValue(RightChildIndex(i));
				min = list.get(MaxValue(RightChildIndex(i)));
				}
			}
		}
		return res;

	}


	//UTILITY INDEX FUNCTIONS.
	public static int LeftChildIndex(int i){
		return 2*i+1;
	}

	public static int RightChildIndex(int i){
		return 2*i+2;
	}

	public static int ParentIndex(int i){
		return i/2;
	}
}
