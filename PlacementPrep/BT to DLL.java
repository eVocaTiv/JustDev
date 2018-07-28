import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Node {
		int data, level;
		Node left, right;

		Node (int data) {
			this.data = data;
			left = right = null;
			level = 0;
		}
	}
	
	Node root;
	
	
	public static Node getHeadtoDLL(Node focus) {
		Node root = toDLL(focus);
		while(root.left!=null) {
			root = root.left;
		}
		return root;
	}
	public static void printDLL(Node focus) {
		while(focus.right!=null) {
			System.out.println(focus.data);
			focus = focus.right;
		}
		System.out.println(focus.data);
	}
	
	public static Node toDLL(Node focus) {
		if(focus == null)
			return focus;
		
		if(focus.left!=null) {
			Node left = toDLL(focus.left);
			for(; left.right!=null ; left  = left.right);
			left.right = focus;
			focus.left = left;
		}
		if(focus.right!=null) {
			Node right = toDLL(focus.right);
			for(; right.left!=null ; right = right.left);
			focus.right =right;
			right.left = focus;
		}
		return focus;
	}
	
	public static void levelTraversal(Node focus) {
		Queue<Node> q = new LinkedList();
		
		q.add(focus);
		int clevel = 0;
		while(!q.isEmpty()) {
			
			Node top = q.poll();
			
			if(clevel == top.level) {
				System.out.println(top.data);
				clevel ++;
			}
			if(top.left!=null) {
				top.left.level = top.level+1;
				q.add(top.left);
			}
			if(top.right!=null) {
				top.right.level = top.level+1;
				q.add(top.right);
			}
		}
		
		
		
	}
	
	public static void InOrder(Node focus) {
		if(focus.left!=null)
			InOrder(focus.left);
		System.out.println(focus.data);
		if(focus.right!=null)
			InOrder(focus.right);
	}
	
	public static boolean checkBST(Node focus, int min , int max) {
		if(focus == null)
			return true;
		if(focus.data < min || focus.data > max)
			return false;
		if(focus.left == null && focus.right == null)
			return true;
		return ( checkBST(focus.left, min, focus.data) && checkBST(focus.right, focus.data, max));
		
	}
	
	public static void main(String[] args) {
		Main t1 = new Main();
		Main t2 = new Main();
		
		t1.root = new Node(1);
		t1.root.left = new Node(2);
		t1.root.right = new Node(3);
		t1.root.right.right = new Node(4);
		t1.root.right.right.right = new Node(5);
		t1.root.right.right.right.right = new Node(6);
		t2.root = new Node(1);
		t2.root.right = new Node(9);
		
		System.out.println(checkBST(t1.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		Node dllroot = getHeadtoDLL(t1.root);
		printDLL(dllroot);
//		levelTraversal(t1.root);
//		mergeAdd(t1.root, t2.root);
//		InOrder(t1.root);
	}

	public static void mergeAdd(Node f1, Node f2) {
		if(f2 == null && f1 == null)
			return;
		else
		if (f1 == null)
			f1 = new Node(f2.data);
		else
		if(f2 != null) {
			f1.data += f2.data;
			mergeAdd(f1.left, f2.left);
			mergeAdd(f1.right, f2.right);
		}
	}
	
}


