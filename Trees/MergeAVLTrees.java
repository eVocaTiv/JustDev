import java.util.ArrayList;
public class Main {
	Node root;
	static ArrayList<Integer> s1 , s2 , s3;



	public static class Node {
		int key, height;
		Node left , right;

		public Node(int key){
			this.key = key;

			//IMPORTANT , SET INITIAL HEIGHT = 1 , if 0 , code bugs off.
			height = 1;
			left = right = null;
		}

	}
	
	
	public void XInorder(Node focus){
		if(focus.left!=null)
			XInorder(focus.left);
        System.out.print(focus.key + " ");
		if(focus.right!=null)
			XInorder(focus.right);

	}




	public static void main(String[] args){
    	Main tree1 = new Main();
		Main tree2= new Main();
		Main tree3 = new Main();
        s1 = new ArrayList<>();
        s2 = new ArrayList<>();
        s3 = new ArrayList<>();


        tree1.root = tree1.Insert(tree1.root, 28);
        tree1.root = tree1.Insert(tree1.root, 15);
        tree1.root = tree1.Insert(tree1.root, 25);
        tree1.root = tree1.Insert(tree1.root, 65);
        tree1.root = tree1.Insert(tree1.root, 40);
        tree1.root = tree1.Insert(tree1.root, 55);

        
		tree2.root = tree2.Insert(tree2.root, 10);
		tree2.root = tree2.Insert(tree2.root, 79);
		tree2.root = tree2.Insert(tree2.root, 30);
		tree2.root = tree2.Insert(tree2.root, 40);
		tree2.root = tree2.Insert(tree2.root, 50);
		tree2.root = tree2.Insert(tree2.root, 60);

        tree1.Inorder(tree1.root , s1);
        tree2.Inorder(tree2.root , s2);
        
        //NOW S1 ANS S2 CONTAIN THE INORDERS OF THE ORIGINAL TREES.
        //MERGE THEM IN O(M+N) TO CREATE A SINGLE SORTED LIST.
        MergeArrays(s1 , s2);
        
        
        //CONSTRUCT THE TREE IN O(M+N) FROM THIS LIST USING RECURSION.
        tree3.root = CreateTree(s3 , 0 , s3.size()-1);
        tree3.XInorder(tree3.root);
		//System.out.println(tree2.root.right.left.key);
	    //for(int x : s3)
	    //  System.out.print(x + " ");

		//	Node newroot = tree.MergeStart(tree.root, tree2.root);
		//	System.out.println("New Tree's height is " + newroot.height);
	}
	public static Node CreateTree(ArrayList<Integer> s3 , int start , int end ){
	    if(start > end )
            return null;
        else{
            
            int mid = (start + end) / 2;
            Node n = new Node(s3.get(mid));
            
            n.left = CreateTree(s3 , start , mid-1);
            n.right = CreateTree(s3 , mid+1 , end);
            
            
            return n;
        }    
		
	}
	
	public static void MergeArrays(ArrayList<Integer> list1 , ArrayList<Integer> list2 ){
	    int counter = 0;
	    int size1 = list1.size();
	    int size2 = list2.size();
	    int size = list1.size() + list2.size();
	    int p1 =0;
	    int p2 =0;
	    
	    //IF EITHER OF THE LIST IS EMPTY.
	    if(size1==0){
	        for(int i=0 ; i<size2 ; i++)
	            s3.add(list2.get(i));
	    }
	    
	    if(size2==0){
	        for(int i=0 ; i<size1 ; i++)
	            s3.add(list1.get(i));
	    }
	    
	    
	    
	    //BOTH LISTS UNEMPTY.
	    
	    else
	    while(counter<size){
	        //EITHER LIST FINISHED PROCESSING.
	        if(p1==size1)
	            s3.add(list2.get(p2++));
	        else
	        if(p2==size2)
                s3.add(list1.get(p1++));
	        else
	        //ELEMENTS REMAINING IN BOTH LISTS.
	        if(list1.get(p1)<list2.get(p2))
	            s3.add(list1.get(p1++));
	        else
	            s3.add(list2.get(p2++));
	        
	        
	        counter++;
	        
	        
	    }
	    
	    
	    
	    
	    
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



	public void Inorder(Node focus , ArrayList<Integer> list){
		if(focus.left!=null)
			Inorder(focus.left , list);
        list.add(focus.key);
		if(focus.right!=null)
			Inorder(focus.right , list);

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
