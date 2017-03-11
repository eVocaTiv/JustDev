import java.util.ArrayList;


public class Tree {
	private Node root;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args){
		Tree t= new Tree();
		t.root = new Node(5);
		t.root.left= new Node(2);
		t.root.left.right = new Node(1);
		t.root.right = new Node(9);
		t.root.left.left = new Node(3);
		t.RootToLeafSum(t.root, 0);
		int res=0;
		for(int i:t.list){
			res+=i;
		}
		System.out.println("The required sum is " + res);

	}

	public void RootToLeafSum(Node focus , int sum){
		if(focus==null)
			return;

		sum=sum*10;
		sum+=focus.key;

		if(focus.left==null && focus.right == null){
			list.add(sum);
			return;
		}		
		RootToLeafSum(focus.left , sum);
		RootToLeafSum(focus.right , sum);
	}
}
