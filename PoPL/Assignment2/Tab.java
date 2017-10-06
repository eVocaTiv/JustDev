import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * AUTHOR 2015A7PS0011G
 * KUNAL DEWAN.
 * 
 */
public class Tab implements ActionListener{


	//MAIN METHOD.

	Object tabobj = new Object();
	//TOTAL SIZE .
	int totalsize ;	
	int donesize  ;
	//NO. OF DOWNLOADS.
	int n;
	//NAME of the url.
	String url;

	int downloadsDone = 0;



	//list to hold the downloads.
	ArrayList<Download> downloadsList;

	//CONSTRUCTOR TO CREATE A NEW TAB.
	public Tab(int n , String url) {
		this.n = n;
		this.url = url;
		totalsize = 0;
		downloadsList = new ArrayList<>();	

		//initialize a Tab with n downloads
		//each has 2 fragments and 100 size.
		for(int i=0 ; i<n ; i++) {
			int nextsize =  100 + (int)(Math.random()* 1000);
			totalsize += nextsize;
			donesize = 0;
			downloadsList.add(new Download(this , 2 , nextsize));
		}

		System.out.println("Total size of tasks =" + totalsize);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//downloadsDone++;
		//if(downloadsDone == n)
		//System.out.println(donesize/totalsize)*100);
		//	System.out.println(url + " finished " + (donesize/totalsize)*100 + "% ");
		//else
			System.out.println(url + " Loaded " + (int)((double)((double)donesize/totalsize)*100) + "% ");
			if(donesize/totalsize == 1)
				System.out.println("( " + url + " ) " + " Tab Idle...");
			//LISTEN HERE FOR THE COMPLETED DOWNLOADS.
			//PRINT PERCENTAGE RATIO OF DONESIZE/TOTALSIZE;

	}



}
