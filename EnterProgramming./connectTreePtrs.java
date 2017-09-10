import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	
	static Scanner sc = new Scanner(System.in);
	static Node root;
	static Queue<Node> q ;
	
	public static void connectNodes(Node focus){
		
		q = new LinkedList();
		
		q.add(focus);
		
		focus.ptr = null;
		
		while(!q.isEmpty()){
			Node top = q.poll();
			if(top.left!=null){
				q.add(top.left);
				top.left.level = top.level + 1;
			}
			if(top.right!=null){
				q.add(top.right);
				top.right.level = top.level + 1;
			}
			
			
			//UPDATE PTRS.
			
			if(!q.isEmpty() && q.peek().level == top.level){
				top.ptr = q.peek();
			}
		}
	}
	
	
	public static void main(String [] args){
		Main tree = new Main();
	
		tree.root = new Node(10 , 0);
		tree.root.left = new Node(3);
		tree.root.right = new Node(5);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(2);
		
		connectNodes(tree.root);
		
		System.out.println(tree.root.left.left.ptr.ptr.key);
	}
	
	public static class Node{
		Node left , right;
		Node ptr;
		int key;
		int level;
		public Node(int key , int level){
			this.level = 0;
			this.key = key;
			left = right = ptr = null;
		}
		public Node(int key ){
			
			this.level = 0;
			this.key = key;
			left = right = ptr = null;
		}
		
		
	}
	
	
	
	
}
