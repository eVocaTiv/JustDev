
public class Main {
	static int res = 0;

	public static class Node{
		Node left , right = null;
		int key ;

		public Node(int key) {
			this.key = key;
		}
	}

	public static class V{
		int mini , maxi;
		int size;
		boolean isBST;
		public V() {
			isBST = true;
			mini = Integer.MAX_VALUE;
			maxi = Integer.MIN_VALUE;
			size = 0;
		}

	}

	static Node root;
	static Node theroot;
	public static void main(String[] args) {


		

		root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		
		
		int mini = Integer.MIN_VALUE;
		int maxi = Integer.MAX_VALUE;

		V myV = new V();
		largestBST(root );
		//System.out.println("hello");
		System.out.println("The largest size of bst is " + res );
		//System.out.println(theroot.key);
	}



	public static V largestBST(Node focus ) {
		V LeftV , RightV , rv;
		rv = new V();

		LeftV = new V();
		RightV = new V();

		//rv.size = 0;

		boolean lflag = false , rflag = false;
		//BASE CASE EMPTY BST.
		if(focus == null) {
			//System.out.println("x");
			rv.isBST = true;
			return rv;


		}

		//CHECK IF LEFT SUBTREE IS BST.	
		int lsize , rsize;
		LeftV =  largestBST(focus.left) ;

		if(LeftV.isBST &&  focus.key > LeftV.maxi  ){
			lflag = true;
			if(focus.key == 6) 
				System.out.println("lf");

		}

		RightV =  largestBST(focus.right) ;
		if(RightV.isBST && focus.key < RightV.mini ){
			rflag = true;
			if(focus.key == 6)
				System.out.println("rf");
		}

		if(lflag && rflag) {
			if(rv.size < LeftV.size + RightV.size + 1)
				rv.size = LeftV.size + RightV.size + 1;
			res = Math.max(res, rv.size);
			//System.out.println(RightV.maxi);
			//System.out.println(LeftV.maxi);
			if(focus.left == null && focus.right == null) {
				rv.maxi = focus.key;
				rv.mini = focus.key;
			}else {
				rv.maxi = Math.max(Math.max(focus.key, LeftV.maxi) , RightV.maxi);
				rv.mini = Math.min(Math.min(focus.key, LeftV.mini) , RightV.mini);
				if(focus.key == 9) {
					System.out.println(rv.maxi );
					System.out.println(rv.mini);
				}
			}
			//System.out.println(rv.maxi);
			//System.out.println(rv.mini);
		}
		else {
			rv.isBST = false;
			rv.size = 0;
		}
		return rv;
	}

}
