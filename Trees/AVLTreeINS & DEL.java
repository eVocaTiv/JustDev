
public class AVLTree {
	static Node root;


	public static void main(String[] args){
		AVLTree tree = new AVLTree();

		tree.root = tree.Insert(tree.root, 70);
		tree.root = tree.Insert(tree.root, 1);
		tree.root = tree.Insert(tree.root , 0);
		
		
		System.out.println("Total number of nodes : " + tree.Nodes(tree.root));
		System.out.println("Height of the tree is " + tree.root.height);
		System.out.println("Root key is " +tree.root.key);
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
	
	public void ModifyHeight(Node focus){
		if(focus==null)
			return ;
		else
			focus.height = 1+UpdateHeight(focus.left , focus.right);
		
	}


	public int UpdateHeight(Node a , Node b){
		
		if(a==null && b==null)
			return -1;
		if(a==null)
			return b.height;
		if(b==null)
			return a.height;
		return Math.max(a.height, b.height);
	
	}

	


	public Node Insert(Node focus , int x){

		if(focus==null)
			return(new Node(x));
		else
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
		
		return DoBalance(focus , x);

	}


	public int getBalance(Node N) {
		if (N == null)
			return 0;

		if(N.left==null && N.right==null)
			return 0;
		if(N.left == null)
			return N.right.height;
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


	public Node DoBalance (Node focus , int key){
		focus.height = 1+ UpdateHeight(focus.left, focus.right);

		int balance = getBalance(focus);
		
		// NOW WE CAN HAVE 4 CASES OF IMBALANCE OR BALANCED.

		//CASE1 ( LEFT LEFT ) 
		
		if(balance > 1 && key < focus.left.key){
			return RR(focus);
		}


		//CASE2 ( LEFT RIGHT) 

		if(balance > 1 && key > focus.left.key){
			focus.left = RL(focus.left);
			return RR(focus);
		}

		//CASE3 ( RIGHT RIGHT ) 

		if(balance < -1 && key > focus.left.key){
			return RL(focus);
		}

		//CASE4 ( RIGHT LEFT ) 

		if(balance < -1 && key < focus.left.key){
			focus.right = RR(focus.right);
			return RL(focus);
		}

		return focus;
	}


	public Node minValue(Node focus){
		if(focus.left!=null)
			return minValue(focus.left);
		else
			return focus;
	}

}
