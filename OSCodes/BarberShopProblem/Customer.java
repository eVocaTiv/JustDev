
public class Customer extends Thread{
	BarberShop barberShop;

	public Customer(BarberShop barberShop){
		this.barberShop = barberShop;
	}

	public void get_haircut(){
		try {
			sleep(250);
		} catch (InterruptedException ex) {}
	}

	public void run(){
		try {
			//CHECK IF THERE'S A SEAT LEFT.
			if(barberShop.seats==0){
				System.out.println("Customer came & left!");
			}
			else{
				barberShop.is_Customer_There.release();
				barberShop.can_Modify_seats.acquire();
				barberShop.seats--;
				barberShop.can_Modify_seats.release();
				
				
				if(barberShop.seats==0)
					barberShop.is_Customer_There.acquire();
				//System.out.println("Seats left are : " + barberShop.seats);



				barberShop.is_Barber_Free.acquire();
				this.get_haircut();
				barberShop.is_Barber_Free.release();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}



}
