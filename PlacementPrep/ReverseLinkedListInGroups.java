import java.util.Scanner;

public class GFG {
	static Scanner sc = new Scanner(System.in);
	static Node head;
	
	public static class Node {
		Node next;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	public static void displayList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+ " ");
			temp = temp.next;
		}
	}
	
	public static void reverse(Node focus, int k) {
		if( focus == null )
			return;
		int i = 0;
		int tempData  = focus.data;
		while(i < k-1 ) {
			focus.data = focus.next.data;
			i++;
			focus = focus.next;
		}
		focus.data = tempData;
		reverse(focus.next, k);
	}
	
	public static void addAtLast(int data) {
		Node temp = head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data); 
	}
	public static void main(String [] args) {
		head = new Node(5);
		addAtLast(2);
		addAtLast(3);
		addAtLast(9);
		addAtLast(10);
		addAtLast(1);
//		displayList();
		reverse(head, 2);
		displayList();
	}
}
