
/*
 * AUTHOR 2015A7PS0011G
 * KUNAL DEWAN.
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

/*
 * AUTHOR 2015A7PS0011G
 * KUNAL DEWAN.
 * 
 */
public class Download implements ActionListener{
	//NAME OF PARENT TAB.
	Tab parentTab;
	//NO. OF FRAGMENTS.
	int frag;
	
	//to trigger the event.
	JButton b = new JButton();
	//total size of the download;
	int downloadsize ;
	int completedtasks = 0;
	
	//LIST TO HOLD THE TASKS ASSOCIATED WITH THIS DOWNLOAD.
	
	//object to synchronize.
	Object dummy = new Object();
	
	ArrayList<Task> tasksList ;
	
	public Download(Tab parentTab , int frag , int downloadsize) {
	
		
		b.addActionListener(parentTab);
	
		//System.out.println("download created with size : " + downloadsize);
		this.parentTab = parentTab;
		this.frag = frag;
		this.downloadsize = downloadsize;
		tasksList = new ArrayList<>();
		
		
		//ADD TASKS AND GIVE THEM TIMEREQD.
		for(int i=0 ; i<frag ; i++) {
			tasksList.add(new Task(this , 100));
		}
		
		for(int i=0 ; i<frag ; i++) {
			tasksList.get(i).start();
		}
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//fire upon completion
		completedtasks++;
		if(completedtasks == frag) {
		//	System.out.println("downloadsize is " + downloadsize);
			parentTab.donesize+=downloadsize;
			
			b.doClick();
		}
		// TODO Auto-generated method stub
		
	}
	

	
	
}
