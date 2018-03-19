import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	
	static Node root;
	static int N;
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for(int i=0 ; i<N ; i++){
			list.add(sc.nextInt());
		}	
		
		
		makeLevelTree();
		//minSwapsToBST();
		//System.out.println(root.left.key);
		InOrder(root);
	}
	
	
	public static void InOrder(Node focus){
		if(focus==null)
			return;
		if(focus.left!=null)
			InOrder(focus.left);
		System.out.print(focus.key+ " ");
		if(focus.right!=null)
			InOrder(focus.right);

	}
	public static void minSwapsToBST(){
		int counter = 0;
		int minswaps = 0;
		int index = 0;
		//while(counter <=N){
		//	if(list.get(index)==)
		//}
		
		System.out.println(1);
	}
	
	public static Node makeLevelTree(){
		Queue<Node> q = new LinkedList();
		
		
		root = new Node(list.get(0));
		q.add(root);
		int index=0;
		
		while(index +2 < list.size()){
			
			Node top = q.poll();
			Node l = new Node(list.get(index+1));
			Node r = new Node(list.get(index+2));
			
			top.left = l;
			top.right = r;
			
			q.add(l);
			q.add(r);
			index+=2;
		}
		
		
		return root;
		
	}

	public static class Node{
		Node left , right;
		int key;

		public Node(){
			key = -1;
			left = right = null;
		}

		public Node(int key){
			this.key = key;
			left = right= null;
		}
	}


}

