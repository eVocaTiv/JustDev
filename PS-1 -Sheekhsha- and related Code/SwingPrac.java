import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main {
	private JScrollPane spane;

	public Main(){
		
		//add frame.
		JFrame frame = new JFrame("Hello world title!");
		frame.setSize(800,500 );
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		
		//add label.
		JLabel label = new JLabel("JLabel over here!!!");
		label.setForeground(new Color(200 , 0 , 200));
		label.setBackground(new Color(200 , 200 , 0));
		frame.add(label);
		
		frame.setLayout(new FlowLayout());
		
		//add text field
		
		JTextField textField = new JTextField("Text Field over here!");
		
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText(textField.getText());
				// TODO Auto-generated method stub
				
			}
		});
		
		
		JButton button = new JButton("Don't click this buttom!");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				label.setText(textField.getText());
				// TODO Auto-generated method stub
				
			}
		});
		
		
		frame.add(button);
		frame.add(textField);
			
		
		//add button.
		

		//initiate list
		
		String[] nycsites = new String[]{"sasasasasaAB" , "CsasasasD" , "EFsasasasa" , "GH"};
		//Integer[] nycsites = new Integer[]{5 , 6,  7 , 2};
		JList list = new JList(nycsites);
		
		
		//single selector list.
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int index = list.getSelectedIndex();
				if(index!=-1){
					label.setText("Site to visit " + nycsites[index]);
				}
				// TODO Auto-generated method stub
				
			}
		});
		
		frame.add(list);
			
		
		spane = new JScrollPane(list);
		spane.setPreferredSize(new Dimension(100 ,36));
	
		frame.add(spane);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//RUN THE PROGRAM
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
