
public class AVLTree {
	Node root;



	public class Node {
		int key, height;
		Node left , right;

		public Node(int key){
			this.key = key;

			//IMPORTANT , SET INITIAL HEIGHT = 1 , if 0 , code bugs off.
			height = 1;
			left = right = null;
		}

	}



	public static void main(String[] args){
//		AVLTree tree = new AVLTree();
		AVLTree tree2= new AVLTree();

		tree2.root = tree2.Insert(tree2.root, 10);
		tree2.root = tree2.Insert(tree2.root, 20);
		tree2.root = tree2.Insert(tree2.root, 30);
		tree2.root = tree2.Insert(tree2.root, 40);
		tree2.root = tree2.Insert(tree2.root, 50);
		tree2.root = tree2.Insert(tree2.root, 60);


		//System.out.println(tree2.root.right.left.key);
		System.out.println(tree2.root.key);
		System.out.println(tree2.root.height);

		//	Node newroot = tree.MergeStart(tree.root, tree2.root);
		//	System.out.println("New Tree's height is " + newroot.height);
	}


	// GET NUMBER OF  NODES IN A TREE.
	public int Nodes(Node focus){
		if(focus==null)
			return 0;
		return 1+Nodes(focus.left)+Nodes(focus.right);
	}

	//ROTATE LEFT
	public Node RL(Node pivot){

		//INITIALIZE
		Node x  = pivot.right;
		Node T2 = x.left;

		//ROTATE

		pivot.right = T2;
		x.left = pivot;

		//UPDATE HEIGHTS.
		ModifyHeight(pivot);
		ModifyHeight(x);

		// SET NEW PIVOT AS X (PROMOTED)
		return x;			
	}

	//ROTATE RIGHT
	public Node RR(Node pivot){

		//INITIALIZE
		Node x  = pivot.left;
		Node T2 = x.right;

		//ROTATE
		pivot.left = T2;
		x.right = pivot;


		//UPDATE HEIGHTS
		ModifyHeight(pivot);
		ModifyHeight(x);

		// SET NEW PIVOT AS X (PROMOTED)
		return x;			
	}

	//TAKE OUT MAX VALUE FROM AN AVL TREE.
	public Node GetMax(Node focus){
		Node root = focus;
		while(focus.right!=null)
			focus = focus.right;
		//STORE MAX VALUE IN A TEMP VARIABLE.
		Node temp = focus;

		//DELETE THE MAX VALUE.
		root = Delete(root , focus.key);

		//RETURN THE VALUE REMOVED.
		return temp;
	}

	//MERGE 2 TREES GIVEN A ROOT
	public Node Merge(Node t1 , Node t2 , Node newroot){
		newroot.left = t1;
		newroot.right = t2;

		ModifyHeight(newroot);

		return root;
	}

	public Node MergeStart(Node t1, Node t2){

		Node newroot = GetMax(t1);
		Merge(t1 , t2 , newroot);

		return newroot;
	}

	public void ModifyHeight(Node focus){
		if(focus==null)
			return ;
		else
			focus.height = 1+UpdateHeight(focus.left , focus.right);

	}


	public int UpdateHeight(Node a , Node b){

		if(a==null && b==null)
			return 0;
		if(a==null)
			return b.height;
		if(b==null)
			return a.height;
		return Math.max(a.height, b.height);

	}




	public Node Insert(Node focus , int x){

		if(focus==null)
			return(new Node(x));
		else{
			if(focus.key > x){
				//	System.out.println(true);
				focus.left = Insert(focus.left , x);
			}
			else
				if(focus.key < x){
					focus.right = Insert(focus.right , x);
				}
				else
					return focus;
		}
		//System.out.println(focus.key);
		return DoBalance(focus , x);

	}


	public int getBalance(Node N) {
		if (N == null)
			return 0;

		if(N.left==null && N.right==null)
			return 0;
		if(N.left == null)
			return -1*N.right.height;
		if(N.right==null)
			return N.left.height;


		return N.left.height - N.right.height;
	}



	public void Inorder(Node focus){
		if(focus.left!=null)
			Inorder(focus.left);
		System.out.println(focus.key);	
		if(focus.right!=null)
			Inorder(focus.right);

	}


	public Node DoBalance (Node focus , int key){

		ModifyHeight(focus);
		//	System.out.println("Modified height at key " + focus.key + " is " + focus.height);
		//
		int balance = getBalance(focus);

		// NOW WE CAN HAVE 4 CASES OF IMBALANCE OR BALANCED.

		//CASE1 ( LEFT LEFT ) 
		if((balance)>1){
			//System.out.println("left height is " + focus.left.height);
			//System.out.println("Imbalance" + focus.key);
		}


		if(balance > 1 && focus.left!=null && key < focus.left.key){
			//System.out.println("LEFT LEFT");
			return RR(focus);
		}


		//CASE2 ( LEFT RIGHT) 

		if(balance > 1 &&  focus.left!=null && key > focus.left.key){
			//System.out.println("LEFT RIGHT");
			focus.left = RL(focus.left);
			return RR(focus);
		}

		//CASE3 ( RIGHT RIGHT ) 

		if(balance < -1 && focus.right!=null && key > focus.right.key){
			//System.out.println("RIGHT RIGHT");
			return RL(focus);
		}

		//CASE4 ( RIGHT LEFT ) 

		if(balance < -1 && focus.right!=null && key < focus.right.key){
			//System.out.println("RIGHT LEFT");
			focus.right = RR(focus.right);
			return RL(focus);
		}

		return focus;
	}

	public Node Delete(Node focus , int key){
		if(focus==null)
			return focus;
		if(focus.key < key)
			focus.right = Delete(focus.right , key);
		else
			if(focus.key > key)
				focus.left = Delete(focus.left , key);

		// THE KEY OF FOCUS IS TO BE DELETED.


			else{

				// EITHER ONE CHIELD OR NONE.
				if(focus.left == null  || focus.right == null){
					if(focus.left == null && focus.right==null)
						focus = null;
					else
						if(focus.left==null){
							focus = focus.right;
						}
						else
							focus = focus.left;
				}

				//TWO CHILDS.
				//GET THE SUCCESSOR VALUE OF FOCUS.
				//AND PUT IT'S KEY INTO FOCUS
				// REMOVE SUCCESSOR.

				else{
					Node temp = minValue(focus.right);
					focus.key = temp.key;
					focus.right = Delete(focus.right , temp.key);
				}
			}

		if(focus==null)
			return focus;

		return DoBalance(focus , key);
		// BALANCED CASE


	}


	public Node minValue(Node focus){
		if(focus.left!=null)
			return minValue(focus.left);
		else
			return focus;
	}

}
