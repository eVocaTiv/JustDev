//Class NameSearchDemo demonstrates the NameSearch class 
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class NameSearchDemo
{


	public static void main(String aggs[]) throws 
	IOException
	{

		int answer;
		String searchName; // name for searching 
		String input; // for user choice

		// create Scanner object for keyboard input 
		Scanner keyboard = new Scanner(System.in);

		// create an object for NameSearch class 
		NameSearch ns = new NameSearch();

		// create an of 65 String objects
		String firstNames[] = new String[65];

		// open the names file and catch all possible exceptions/errors

		String[] ans=new String[1];

		try {
			ans[0]=JOptionPane.showInputDialog(null, "Please enter file location", "File location", 
					JOptionPane.QUESTION_MESSAGE);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "This file doesnt exist", "Try two backslashes", JOptionPane.INFORMATION_MESSAGE);
		}

		File file = new File(ans[0]); 

		if(file.exists())
			JOptionPane.showMessageDialog(null, "The file exists!", "Good Job", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "This file doesnt exist", "Try two backslashes", JOptionPane.INFORMATION_MESSAGE);
		//System.exit( 0 );
		Scanner names = new Scanner(file);


		/* read lines from the names file until no more 
    are left */
		for(int i = 0; i < 65; i++)
		{
			// read the next line 
			firstNames[i] = names.nextLine();
			//convert array to string
			firstNames.toString();
		}

		//scroll.setPreferredSize(new Dimension( 500, 1000));
		JPanel beforePanel = new  JPanel();
		JOptionPane  beforePane = new JOptionPane();
		// print the names in the array before sorting 
		JOptionPane.showMessageDialog(null, "Before sorting, 65 most popular female first names: ", "Output", JOptionPane.INFORMATION_MESSAGE) ; 

		JList checkBoxesJList = new JList(firstNames);
		checkBoxesJList.setBounds(10,30,80,600);
		JScrollPane scroll = new JScrollPane(checkBoxesJList);
		beforePanel.setLayout(new GridLayout());
		for(int i = 0; i < 65; i++)
		{

			//	scroll.add(new JLabel(firstNames[i]));
			//			JLabel label = new JLabel("Name " + i + " "+ firstNames[i]);
			//			label.setVerticalAlignment(5);
			//	label.setBounds(100,100, 100 , i*10);
			//	beforePanel.add(scroll);
			//				JOptionPane.showMessageDialog(null, (firstNames[i]), 
			//					"Before Sorting", JOptionPane.INFORMATION_MESSAGE);
		}

		beforePanel.add(scroll);
		beforePane.showMessageDialog(scroll, beforePanel);
		// call to quickSort method 
		ns.quickSort(firstNames);

		// print the names in the array after sorting 
		JPanel myPanel = new JPanel();
		JOptionPane pane = new JOptionPane();
		JList sortedList = new JList(firstNames);
		JScrollPane sortedscroll = new JScrollPane(sortedList);
		sortedList.setBounds(10,30,80,600);
		myPanel.add(sortedscroll);

		JOptionPane.showMessageDialog(null, "After sorting, 65 most popular female first names: ");
		//		for(int i = 0; i < 65; i++)
		//		{
		//			
		//			myPanel.add(new JLabel("Name " + i + " "+ firstNames[i]));
		////			JOptionPane.showMessageDialog(null, firstNames[i]);
		//		}

		pane.showMessageDialog(sortedscroll , myPanel);


		// search about a name 
		do {
			/* prompt the user input for the name to 
       search */
			String[] anss=new String[1];

			anss[0]=JOptionPane.showInputDialog(null, "Please enter a name to search: ", "Message", JOptionPane.QUESTION_MESSAGE);
			searchName = anss[0];




			// call to binarySearch method
			int result = ns.binarySearch(firstNames, 
					searchName);

			// print the result of the search
			if (result == -1) 
				JOptionPane.showMessageDialog(null, searchName + " was not found.");
			else
				JOptionPane.showMessageDialog(null, searchName + " was found at the position of " + (result + 1));

			// does the user want to search again? 
			//			JOptionPane.showMessageDialog(null, "Do you want to search again? (Y or N): ");
			//			input = keyboard.nextLine();

			answer = JOptionPane.showConfirmDialog(new JFrame("Confirm Please"), "Yes or no") ;


		} while(answer == JOptionPane.YES_OPTION  ) ;
	} // end of main method
} // end of NameSearchDemo class 
