
public class Tree {
	private Node root;

	public Tree(){
		root=null;
	}

	public Tree(int key){
		root = new Node(key);
	}

	public void Insert(int key){
		root = Insert(root , key);
	}

	private Node Insert(Node focus , int key){
		if(focus == null)
			focus = new Node(key);
		else
			if(key<=focus.key)
				focus.left= Insert(focus.left , key);
			else
				focus.right=Insert(focus.right ,key);

		return focus;
	}

	public static void main(String[] args){
		Tree t= new Tree();
		t.Insert(5);
		t.Insert(3);
		t.Insert(9);
		t.Insert(4);
		t.Insert(1);
		t.Insert(2);
		t.Insert(8);
		t.Insert(11);
		t.Insert(7);
		
		
		//t.Insert(4);
		//t.delete(9);
		t.Inorder(t.root);
		
		
		
	}


	public void delete(int k)
	{
		{
			root = delete(root, k);
			//System.out.println(k+ " deleted from the tree");
		}
	}


	private Node delete(Node root , int key){
		if(root.key==key){
			Node l , r , holder , p2;
			l=root.left;
			r=root.right;
			if(l==null && r==null)
				return null;
			if(l==null){
				//ONLY RIGHT CHILD EXISTS
				return r;
			}
			else if(r==null){
				return l;
			}
			else{
				holder=r;

				while(holder.left!=null)
					holder = holder.left;
					holder.left = l;
					return r;
				}
				
			


		}

		if(root.key>key){
			root.left = delete(root.left , key);		
		}

		else{
			root.right = delete(root.right , key);
		}

		return root;
	}

	public void Inorder(Node focus){
		if(focus.left!=null)
			Inorder(focus.left);
		System.out.println(focus.key);
		if(focus.right!=null)
			Inorder(focus.right);
	}





}


