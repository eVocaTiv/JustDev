import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Main {
	static Node root;
	static ArrayList<Integer> Inorderlist = new ArrayList<Integer>();
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		root= new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right= new Node(6);
		root.left.right.right = new Node(7);
		root.left.right.left = new Node(4);
		root.right.right= new Node(14);
		root .right . right .left = new Node(13);

		System.out.println("Please enter your desired number");
		
		System.out.println(FindClosestAns(root , s.nextInt()));

	}

	public static int FindClosestAns(Node focus , int val){
		return val + FindClosest(focus , val , 0 , Integer.MAX_VALUE);
	}


	public static int FindClosest(Node focus , int val , int diff , int mindiff){
		if(focus==null)
			return mindiff;
		diff = focus.key - val;

		if(diff==0)
			return 0;

		if(Math.abs(diff) < Math.abs(mindiff))
			mindiff = diff;

		if(Math.abs(diff) == Math.abs(mindiff)){
			if(diff < 0)
				mindiff = diff;
		}
		if(focus.key>val){
			//System.out.println("focus key is " + focus.key);
			if(focus.left!=null)
				return FindClosest(focus.left , val , diff, mindiff);
			return mindiff;
		}
		else
			if(focus.right!=null)
				return FindClosest(focus.right , val, diff, mindiff);
			return mindiff;

	}


	public static void Inorder(Node focus){
		if(focus.left!=null)
			Inorder(focus.left);
		Inorderlist.add(focus.key);
		if(focus.right!=null)
			Inorder(focus.right);

	}


	public static void SumCheck(int sum){
		Inorder(root);
		Collections.sort(Inorderlist);
		int l=0;
		int tsum=0;
		int r=Inorderlist.size()-1;
		while(l<r){
			tsum=Inorderlist.get(l) + Inorderlist.get(r);
			if(sum==tsum){
				System.out.println("True");
				return;
			}
			else
				if(sum>tsum){
					//System.out.println("High and Sum is" + tsum);
					l++;
				}
				else
					if(sum<tsum){
						System.out.println("Low");	
						r--;
					}

		}

		System.out.println("False");
	}

	public static void PLV(){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		root.level=0;
		int currentlevel=0;
		while(!q.isEmpty()){
			Node top = q.remove();
			if(top.level==currentlevel){
				System.out.println(top.key);
				currentlevel++;
			}
			if(top.left!=null){
				q.add(top.left);
				top.left.level=top.level+1;
			}
			if(top.right!=null){
				q.add(top.right);
				top.right.level=top.level+1;
			}

		}



	}
}
