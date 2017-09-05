
public class Main {

	static Node root;


	public static void main(String[] args){
		Main tree = new Main();
		tree.root = tree.Insert(5, tree.root);
		tree.root = tree.Insert(3, tree.root);
		tree.root = tree.Insert(9, tree.root);
		tree.root = tree.Insert(1, tree.root);
		tree.root = tree.Insert(2, tree.root);
		tree.root = tree.Insert(8, tree.root);
		tree.root = tree.Insert(11, tree.root);
		tree.root = tree.Insert(7, tree.root);



		tree.root = tree.Delete(7 ,  tree.root);
		tree.root = tree.Delete(12 ,  tree.root);
		tree.root = tree.Delete(13 , tree.root);
		tree.root = tree.Delete(5, tree.root);

		tree.Inorder(tree.root);



	}


	public static void Inorder(Node focus){

		if(focus!=null){
			if(focus.left!=null)
				Inorder(focus.left);
			System.out.println(focus.key);
			if(focus.right!=null)
				Inorder(focus.right);
		}
	}



	public static class Node{
		int key ;
		Node left = null, right = null;

		public Node(int key){
			this.key = key ; 
		}
	}

	public static Node Insert(int x , Node focus){
		if(focus==null)
			return focus = new Node(x);
		else
			if(x < focus.key)
				focus.left = Insert(x , focus.left);
			else
				focus.right = Insert(x , focus.right);

		return focus;
	}


	public static Node Delete(int x , Node focus){

		if(focus==null)
			return null;
		else
		if(x > focus.key)

			focus.right = Delete( x , focus.right);
		else
		if(x < focus.key)

			focus.left = Delete ( x , focus.left );

		else{

			//KEYS EQUAL , PERFORM THE DELETION.
			Node l , r  , t;

			l = focus.left;
			r = focus.right ;


			if(l == null && r == null)
				return null;

			if(l==null)
				return r;

			if(r==null)
				return l;

			//ELSE BOTH THE CHILDS ARE PRESENT.
			//FIND THE MIN. VALUE IN THE RIGHT SUBTREE AND ATTACH L TO IT.

			//AND RETURN THIS BRANCH.

			t = r;

			while(t.left!=null)
				t=t.left;

			t.left = l;
			return r;



		}
	
		
		return focus;

	}





}
