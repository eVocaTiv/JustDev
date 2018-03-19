import java.util.Scanner;


public class Main {

	static int maxBSTsize =1;
	static int[] parentArray = new int[1000001];
	static int N;
	static Node root = null;
	static Node[] nodeList  = new Node[1000001];

	public static void main(String[] args) {



		for(int i=0 ; i<1000001 ; i++)
			nodeList[i] = new Node(i);

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		//GET THE PARENT ARRAY.
		for(int i=0 ; i<N ; i++){
			parentArray[i]=sc.nextInt();
		}

		generateBT();

		//InOrder(root);

		//Node root2 = new Node(7);
		//root2.left = new Node(2);
		//root2.right = new Node(6);

		go(root);

		//System.out.println(maxBSTsize);
		//System.out.println(checkBST(root, -1 , Integer.MAX_VALUE));


		//System.out.println(root.right.right.right.key);
	}

	public static void go(Node focus){
		if(focus == null)
			return ;
		else{
			getAns(focus.left);
			getAns(focus.right);
		}
	} 

	public static int getSize(Node focus){
		if(focus == null)
			return 0;
		else
			return 1+ getSize(focus.left)+getSize(focus.right);
	}

	public static void getAns(Node focus){
		if(checkBST(focus , -1  , Integer.MAX_VALUE)){
			System.out.println(focus.key + " + ");
			System.out.println(getSize(focus));
			//int res = getSize(focus);
			//maxBSTsize = Math.max(maxBSTsize, res);
			//System.out.println(maxBSTsize);
		}	
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

	//FUNCTION TO CONSTRUCT BST FROM THE GIVEN ARRAY.
	public static void generateBT(){
		//boolean rightflag = false;
		int lastparent = -2;
		//connect the parents to the children.
		for(int i=0 ; i<N ; i++){

			int parent = parentArray[i];

			if(parent == -1){
				root = nodeList[i];
				//	System.out.println("yes");
			}
			else
				if(lastparent == parent){

					nodeList[parent].right = nodeList[i];
					
				}
				else{
					nodeList[parent].left  = nodeList[i];
					
				}

			lastparent = parent;

		}
	}

	//FUNCTION TO CHECK IF THE TREE IS A BST AT THE GIVEN NODE.
	public static boolean checkBST(Node focus , int min , int max){
		if(focus == null)
			return true;
		if(focus.key > max || focus.key < min)
			return false;

		return checkBST(focus.left , min , focus.key) 
				&& 
				checkBST(focus.right , focus.key , max);


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

