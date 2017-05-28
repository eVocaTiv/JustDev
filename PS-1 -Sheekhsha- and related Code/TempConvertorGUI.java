import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {
	JLabel templabel , outlabel;
	JTextField tf;
	JButton b;
	String[] temps;
	JList list;
	int tempindex;

	public static double convert(int temp , String scale){
		if (scale.equals("Celsius")){
			return(temp-32.0)*(5.0/9.0);
		}
		else
			return temp*(9.0/5.0) + 32.0;

	}

	public Main(){
		templabel = new JLabel("Temperature : ");
		outlabel = new JLabel("");
		tf = new JTextField(5);
		b = new JButton("Convert");

		temps = new String[]{"Celsius" , "Fahreinheit"};
		list = new JList(temps);
		JFrame frame = new JFrame("Welcome to the Temperature Convertor");

		frame.setLayout(new GridLayout(3,2));

		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				tempindex = list.getSelectedIndex();

				// TODO Auto-generated method stub

			}
		});


		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int temp = Integer.parseInt(tf.getText());
				String scale = temps[tempindex];
				outlabel.setText(Double.toString(convert(temp, scale)));
				// TODO Auto-generated method stub

			}
		});

		frame.add(b);
		frame.add(tf);
		frame.add(templabel);
		frame.add(outlabel);
		frame.add(list);
		frame.setVisible(true);



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
