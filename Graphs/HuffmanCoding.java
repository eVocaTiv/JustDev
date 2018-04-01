import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	private static ArrayList<Character> charlist;
	private static ArrayList<Integer>freqlist;
	private static Scanner sc;
	private static int n;
	private static Node root;
	
	public static void readInp() {
		sc = new Scanner(System.in);
		charlist = new ArrayList<>();
		freqlist = new ArrayList<>();
		
		n = sc.nextInt();
		
		for(int i=0 ; i<n ; i++) {
			charlist.add(sc.next().charAt(0));
			freqlist.add( sc.nextInt());
		}

	}
	

	public static void makeHuffTree () {
		
		root = null;
		
		PriorityQueue<Node> q = new PriorityQueue<>(10 , new Comparator<Node>() {
			public int compare(Node a , Node b) {
				return a.freq - b.freq;
			}
		});
		
		for(int i=0 ; i<n ; i++) {
		q.add(new Node(charlist.get(i), freqlist.get(i)));
		}
		
		while(q.size()>1) {
			
			Node x = q.poll();
			Node y = q.poll();
			
			Node z = new Node('-' , x.freq+y.freq);
			z.left = x;
			z.right = y;
			
			root = z;
			q.add(z);
			
		//	System.out.println(z.freq);
		}
	//	System.out.println(root.freq);
		printCode(root , "");
		
	}
	
	public static void printCode(Node focus , String s) {
		if(focus.left == null && focus.right == null) {
			System.out.println("Character " + focus.c + "  ---> " + s) ;
		}
		else {
			printCode(focus.left, s + "0");
			printCode(focus.right, s + "1");
		}
	}
	
	
	public static class Node {
		Node left , right;
		int freq;
		char c;
		
		
		public Node(char c, int freq) {
		 this.c = c;
		 this.freq  = freq;
		}
	}
	
	public static void main(String [] args) {
		readInp();
		makeHuffTree();
	//	System.out.println(root.freq);
		
	}
}
