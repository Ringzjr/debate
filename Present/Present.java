import java.applet.Applet;
import java.applet.AppletContext;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class Present extends Applet implements KeyListener, ActionListener {

		private AppletContext context;
		private AudioClip clip1;
		private AudioClip clip2;
		private AudioClip clip3;
		JLabel label;
		String s = "";
		JLabel string;
		JButton button1;
		JButton button2;
		JButton button3;
		boolean paint = false;
		boolean second = false;
		boolean third = false;
	
	public void init() {
		//setLayout(null);
		button1 = new JButton("one");
		button2 = new JButton("two");
		button3 = new JButton("three");
		add(button1);
		add(button2);
		add(button3);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button1.setFocusable(false);
		button2.setFocusable(false);
		button3.setFocusable(false);
		label = new JLabel("");
		add(label);
		label.setFont(new Font("Sans Serif", Font.PLAIN,30));
		label.setForeground(Color.white);
		this.setLayout(null);
		label.setBounds(620, 50, 600, 50);
		button1.setBounds(250,350, 150, 60);
		button2.setBounds(600, 350, 150, 60);
		button3.setBounds(950,350,150,60);
		button1.setVisible(false);
		button2.setVisible(false);
		button3.setVisible(false);
		setFocusable(true);
		requestFocusInWindow(true);
		addKeyListener(this);
		setVisible(true);
		setBackground(Color.black);

		clip1 = getAudioClip(getDocumentBase(), "HappyBirthdayOne.wav");
		clip2 = getAudioClip(getDocumentBase(), "HappyBirthdayTwo.wav");
		clip3 = getAudioClip(getDocumentBase(), "HappyBirthdayThree.wav");
		}

	public void start() {
		//System.out.println("bww
		setVisible(true);
		//label.setText("What is your name?");
	    setFocusable(true);
		try {
			run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	public void run() throws InterruptedException {
		paint = true;		
		//if (paint)
			//wait();
		//run2();
		
		
		}
	

	public void run2() {
		//second = true;
		repaint();
		label.setFont(new Font("Sans Serif", Font.PLAIN,20));
		label.setBounds(450, 50, 600, 50);
		label.setText("Hello, " +s+"- choose a button for a special birthday message.");
		delay();
		button1.setVisible(true);
		button2.setVisible(true);
		button3.setVisible(true);
			
		
	}
	
	public void run3() {
		//if (second == false)
		third = true;
		//repaint();

		
	}
	
	public void delay() {
		try {
				Thread.sleep(800);
		} catch (Exception e)
		{
			return;
		}
	}
	
	
		public void keyTyped(KeyEvent e) {
			char c = e.getKeyChar();
			
			if (c!= KeyEvent.CHAR_UNDEFINED) {
				paint = true;
				s = s + c;
				repaint();	
				if (c==KeyEvent.VK_ENTER) {
						paint = false;
						run2();
				}
				e.consume();
				
				
			}
		
	}
	
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(button1))
				clip1.play();
			else if (e.getSource().equals(button2))
				//System.out.println("button 2 clicked");
				clip2.play();
			else if (e.getSource().equals(button3))
				clip3.play();
			 
			
		}
	
	public void keyPressed(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }
	
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(50));
		if (paint) 
		label.setText("Enter Your Name: "+s);
		if (second) {
		label.setText("Hello, " +s+".");
		second = false;
		}
		if (third)
		label.setText("Choose a button for a special birthday message.");

			
		//if (!paint) {
			//label.setText(" ");
			
		//}
		//g.drawString(s, 620, 150);
				
	}
	
	
	
	
}
