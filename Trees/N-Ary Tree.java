import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NTree {
	static ArrayList<Integer> sumlist = new ArrayList<>();
	static HashMap<Node , Integer> sumMap = new HashMap<>();

	static Node root = new Node();


	public static void getMaxSumNode() {
		Queue<Node> q = new LinkedList();
		q.add(NTree.root);
		while(!q.isEmpty()) {
			Node top = q.poll();

			int sum = top.key;

			//System.out.println(top.key);
			for(Node c: top.child) {
				sum+=c.key;
				q.add(c);
			}
			sumlist.add(sum);




		}
		
		
		for(int s : sumlist)
			System.out.println(s);
		
	}

	public static void main(String [] args) {
		//CONSTRUCTING TREE.

		NTree.root = new Node(4);
		NTree.root.child.add(new Node(2));
		NTree.root.child.get(0).child.add(new Node(5));
		NTree.root.child.get(0).child.add(new Node(12));
		NTree.root.child.add(new Node(1));
		NTree.root.child.add(new Node(0));



		NTree.getMaxSumNode();



	}




	public static class Node{
		ArrayList<Node> child ;
		int key;

		public Node() {
			child = new ArrayList<>();
			key = -1;
		}

		public Node(int key) {
			this.key = key;
			child = new ArrayList<>();
		}


	}
}
