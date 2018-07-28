
public class Main {
	static class Node {
		int data;
		Node left, right;

		Node (int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	Node root;
	
	public static void InOrder(Node focus) {
		if(focus.left!=null)
			InOrder(focus.left);
		System.out.println(focus.data);
		if(focus.right!=null)
			InOrder(focus.right);
	}
	
	public static void main(String[] args) {
		Main t1 = new Main();
		Main t2 = new Main();
		
		t1.root = new Node(5);
		t1.root.left = new Node(2);
		t1.root.right = new Node(7);
		
		t2.root = new Node(1);
		t2.root.right = new Node(9);
		
		mergeAdd(t1.root, t2.root);
		InOrder(t1.root);
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


