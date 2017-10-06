import javax.swing.JButton;

/*
 * AUTHOR 2015A7PS0011G
 * KUNAL DEWAN.
 * 
 */

public class Task extends Thread {


	//TIME SIZE.
	long timesize;
	
	Download parentD;
	
	JButton taskButton = new JButton();
	
	public Task(Download parentD , int timesize) {
		//System.out.println("new task created!");
		this.timesize = timesize;
		this.parentD = parentD;
		
		taskButton.addActionListener(parentD);
	}

	@Override
	public void run() {
		synchronized(parentD.parentTab.tabobj) {
		try {
			//WAIT TO COMPLETE THE TASK.
			Thread.sleep(50);
			taskButton.doClick();
			//System.out.println("Task completed.");
			//TASK IS COMPLETED , GO BACK.
			
		}// TODO Auto-generated method stub
		catch(Exception e) {
			System.err.println("Error while downloading!");
		}
		
		}
	}

}
