import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class Tree {
	private static Node root;
	private static ArrayList<Integer> list = new ArrayList<>();
	private static ArrayList<Integer> seq = new ArrayList<>();
	private static HashMap<Integer , Integer> map = new HashMap<>();
	
	public static boolean CheckRP(Node f , ArrayList<Integer> seq , int index){
		if(f==null)
			return (seq.size()==0);
		if(index == seq.size())
			return true;
		if (seq.get(index)== f.key)
			return (CheckRP(f.left , seq , index+1) || CheckRP(f.right , seq , index+1));
		
		return CheckRP(f.left , seq , 0) || CheckRP(f.right , seq , 0 );
		
		
		
	}

	public static void main(String[] args){
		//Scanner s = new Scanner(System.in);
		//int k = s.nextInt();
		root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(2);
		root.right.left= new Node(6);
	//	root.left.right = new Node(4);
		root.right.right = new Node(11);
		root.left.left.left = new Node(1);
		seq.add(5);
		seq.add(2);
		System.out.println(CheckRP(root , seq , 0));
		//Inorder(root);
		//RootToLeaf(root , 0);

		//for(int i : map.keySet())
		//	System.out.println("No. of root paths with length " + i + " are " + map.get(i) );
	} 
	
	public static void RootToLeaf(Node focus , int level){
		if(focus==null)
			return;
		if(focus.left==null && focus.right == null)
			if(!map.containsKey(level))
				map.put(level, 1);
			else
				map.put(level, map.get(level)+1);	
		else{
			RootToLeaf(focus.left , level+1);
			RootToLeaf(focus.right , level +1);
		}
	}
	


	public static void Inorder(Node focus){
		if(focus.left!=null)
			Inorder(focus.left);
		System.out.print(focus.key + " ");
		if(focus.right!=null)
			Inorder(focus.right);
	}

	public static boolean CheckBST(Node focus , int max , int min){
		if(focus==null)
			return true;
		if(focus.key < min || focus.key > max)
			return false;

		return ( CheckBST(focus.left , focus.key-1 , min) && CheckBST(focus.right , max , focus.key+1));	
	}


	public static int KNodes(Node focus , int k){
		if(focus==null)
			return 0;
		if(focus.left==null && focus.right == null){
			if(k==0)
				if(!list.contains(focus.key))
					list.add(focus.key);
			return 1;
		}

		if(KNodes(focus.left , k)+ KNodes(focus.right , k)==k)
			if(!list.contains(focus.key))
				list.add(focus.key);
		return KNodes(focus.left , k)+ KNodes(focus.right , k);	
	}


}
