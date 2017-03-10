
public class Node {
	Node left , right;
	int key;
	
	
	public Node(int key){
		left=null;
		right=null;
		this.key=key;
	}
	
	public void setRight(Node n){
		right = n;
	}
	
	public void setLeft(Node n){
		left = n;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setKey(int key){
		this.key=key;
	}
	
	public int getKey(){
		return key;
	}
	
	
	
	
}
