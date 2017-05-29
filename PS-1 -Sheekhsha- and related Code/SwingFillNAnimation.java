import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	static int x=25;
	static int y=50;
	static JLabel label;
	static JButton button;
	boolean flag = false;

	public Main(){
		label = new JLabel("New label");

		JFrame frame = new JFrame("No title");

		frame.setVisible(true);
		frame.setSize(800, 500);
		MyPanel mp = new MyPanel();

		frame.setLayout(new BorderLayout());

		button = new JButton("Change Color!");


		button.setSize(50, 50);
		//sbutton.setsize
		MovingPanel movingpanel = new MovingPanel();
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				movingpanel.repaint();

				// TODO Auto-generated method stub

			}
		});



		frame.getContentPane().add(BorderLayout.CENTER, movingpanel);

		frame.getContentPane().add(BorderLayout.SOUTH	,button);





	}

	class MovingPanel extends JPanel{
		public void paintComponent(Graphics g){

			if(flag==false)
				for(int i=0 ; i<20 ; i++){
					flag=true;
					g.setColor(Color.white);
					g.fillOval(x, y, 100 , 100);
					y+=5;
					x+=5;
					g.setColor(Color.green);
					g.fillOval(x, y, 100, 100);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			else{
				g.setColor(Color.white);
				g.fillOval(x, y, 100 , 100);
				y+=5;
				x+=5;
				g.setColor(Color.green);
				g.fillOval(x, y, 100, 100);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}


	class MyPanel extends JPanel{
		public void paintComponent(Graphics g){





			Graphics2D g2d = (Graphics2D) g;
			if(flag==false){
				flag=true;
				GradientPaint gradient = new GradientPaint(0 , 0 , Color.blue , 150 , 150 , Color.green);
				g2d.setPaint(gradient);
				g2d.fillRect(0	,0  ,this.getWidth(), this.getHeight());
			}
			else{
				flag=false;
				GradientPaint gradient = new GradientPaint(0 , 0 , Color.yellow , 150 , 150 , Color.red);
				g2d.setPaint(gradient);
				g2d.fillRect(0	,0  ,this.getWidth(), this.getHeight());

			}


		}
	}

	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			Image image = new ImageIcon("F://sample.jpg").getImage();
			g.drawImage(image, 0 , 0 , this);
		}
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
