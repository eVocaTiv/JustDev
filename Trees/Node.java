
public class Node {
	int key;
	Node left;
	Node right;
	int level;
	
	Node(int key){
		this.key = key;
		left=right=null;
		level=0;
	}

}
