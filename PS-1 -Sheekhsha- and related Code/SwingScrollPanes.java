import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class Main {
	boolean flag1=false;
	boolean flag2=false;

	public Main(){

		JPanel panel = new JPanel();
	
		JFrame frame = new JFrame("My Frame ");
		JTextArea ta = new JTextArea();
		
		ta.setLineWrap(true);
		JScrollPane scroller = new JScrollPane(ta);
		
		
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scroller.setSize(5, 20);
		
		//panel.add(scroller);
		
		frame.setVisible(true);
		frame.setSize(500, 250);
		frame.add(scroller);
			
	}



	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Main();
				// TODO Auto-generated method stub

			}
		});
	}

}
