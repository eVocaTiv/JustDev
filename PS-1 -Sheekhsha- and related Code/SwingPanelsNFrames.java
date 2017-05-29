import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	boolean flag1=false;
	boolean flag2=false;

	public Main(){

		JFrame frame = new JFrame("My Frame ");

		JButton button1 = new JButton("A Button!");
		JButton button2 = new JButton("A Button again!!");

		JPanel panel = new JPanel();
			
		
		
		panel.add(BorderLayout.NORTH , button1);
		panel.add(BorderLayout.WEST , button2);
		button2.setBackground(Color.blue);
		button1.setBackground(Color.red);

		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(BorderLayout.SOUTH , panel);

		frame.setVisible(true);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);


		class MyImagePanel extends JPanel{
			public void paintComponent(Graphics g){
				Image i = new ImageIcon("F:\\sample.jpg").getImage();
				g.drawImage(i, 0, 0, this);
				
			}
			
		}
		
		MyImagePanel imagepanel = new MyImagePanel();
		
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(flag1==false){
					button2.setBackground(Color.yellow);
					flag1=true;
				}// TODO Auto-generated method stub

				else{
					button2.setBackground(Color.blue);
					flag1=false;
				}
			}
		});




		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(flag2==false){
				button1.setBackground(Color.green);
				flag2=true;
				// TODO Auto-generated method stub
				}
				else{
					flag2=false;
					button1.setBackground(Color.red);
				}
			}
		});
		
		
		frame.getContentPane().add(BorderLayout.WEST, new MyImagePanel());
		
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
