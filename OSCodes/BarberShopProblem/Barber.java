
public class Barber extends Thread{
	BarberShop barberShop;

	public Barber(BarberShop barberShop){
		this.barberShop = barberShop;
	}
	public void cutHair() throws InterruptedException{
		System.out.println("Cutting hair # " + barberShop.customers_Attended + " !...");
		Thread.sleep(250);
		System.out.println("Haircut done!...");
	}
	public void run(){
		while(true){
			try {
				//WAIT FOR CUSTOMER.

				System.out.println("waiting for customer.");
				barberShop.is_Customer_There.acquire();

				//TAKE FROM QUEUE 
				barberShop.can_Modify_seats.acquire();
				barberShop.seats++;
				//System.out.println("Seats left : " + barberShop.seats);
				barberShop.can_Modify_seats.release();	 

				//CUT HAIR.
				cutHair();
				//barberShop.customers_Attended++;
				System.out.println("Hit : " + ++barberShop.customers_Attended);
				barberShop.is_Barber_Free.release();
				


			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
