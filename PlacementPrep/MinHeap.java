import java.util.Scanner;

public class Heap {
	static Scanner sc = new Scanner(System.in);
	static int[] heap;
	static int size=0;
	static int maxsize;
	
	private static int parent(int i) {
		return i/2;
	}
	private static int leftChild(int i) {
		return 2*i;
	}
	private static int rightChild(int i) {
		return 2*i + 1;
	}
	private static boolean isLeaf(int pos) {
		if ( pos >= (size/2) && pos <= size) {
			return true;
		}
		return false;
	}
	private static void swap(int fpos, int spos) {
		int tmp = heap[fpos];
		heap[fpos] = heap[spos];
		heap[spos] = tmp;
	}
	private static void bubbleDown(int pos) {
		if(!isLeaf(pos)) {
			if(heap[leftChild(pos)] < heap[pos] || heap[rightChild(pos)] < heap[pos] ) {
				
				if(heap[leftChild(pos)] < heap[pos]) {
					swap(pos,leftChild(pos));
					bubbleDown(leftChild(pos));
				} else {
					swap(pos,rightChild(pos));
					bubbleDown(rightChild(pos));
				}
				
			}
		}
	}
	private static void bubbleUp(int pos) {
		while(heap[pos] < heap[parent(pos)]) {
			swap(pos, parent(pos));
			pos = parent(pos);
		}
	}
	public static void insert(int element) {
		heap[++size] = element;
		bubbleUp(size);
	}
    public static void print()
    {
        for (int i = 1; i <= size / 2; i++ )
        {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " + heap[2*i] 
                + " RIGHT CHILD :" + heap[2 * i  + 1]);
            System.out.println();
        } 
    }
    
    public static void createHeap() {
    	heap = new int[20];
    	for(int pos = size/2; pos >=1 ; pos -- ) {
    		bubbleDown(pos);
    	}
    }
 
	public static void main(String [] args) {
		createHeap();
		insert(5);
		insert(3);
		insert(17);
		System.out.println(size);
		print();
	}
}
