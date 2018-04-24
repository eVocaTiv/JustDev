import java.util.concurrent.locks.ReentrantLock;

public class Runner implements Runnable {
	//	private static int partSize;
	private static Driver d;
	private static double[] arr;
	private static int sno;
	private static ReentrantLock lock;
	public Runner(Driver d , int sno) {

		this.d = d;

		this.sno = sno;

	}
	public void run() {
		//sum the array
		double tempsum = 0;
		arr = d.getArray();
		//System.out.println(arr.length);
		//assuming size = 5;
	
		for (int i=sno*5 ; i<sno*5+5 ; i++)
			tempsum+=arr[i];
		lock = new ReentrantLock();
		lock.lock();
		d.addToSum(tempsum);
     	lock.unlock();
	}

}
