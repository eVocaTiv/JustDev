import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class BarberShop {

	//QUEUE.
	private int n = 5;
	private Queue<Customer> q= new LinkedList();

	//SEMAPHORES.
	public int seats = 5;
	public Semaphore is_Barber_Free = new Semaphore(1);
	public Semaphore is_Customer_There = new Semaphore(0);
	public Semaphore can_Modify_seats = new Semaphore(1);

	
	public int customers_Attended = 0;
	//OPEN THE SHOP!
	public static void main(String [] args) throws InterruptedException{

		BarberShop barberShop = new BarberShop();
		new Barber(barberShop).start();
		for(int i=0 ; i<15 ; i++){
			
			int sleeptime =ThreadLocalRandom.current().nextInt(5, 250 + 1);
			Thread.sleep(sleeptime);
			System.out.println("Arrived after --------->" + sleeptime);
			new Customer(barberShop).start();
		}
	}
	
	




}
