package homework5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StartPage extends JPanel implements KeyListener,Runnable{
	HW5 fr;
	Sound sound = new Sound();
	BufferedImage img;
	
	JLabel title;
	JLabel subtitle;
	JLabel text;

	Thread t;
	
	int state = 0;
	
	int width = 686;
	int height = 666;
	
	StartPage(HW5 _fr){
		fr = _fr;
		
		t = new Thread(this);
		t.start();
		
		URL url = getClass().getClassLoader().getResource("game.png");
		try {
			img = ImageIO.read(url);
			
		} catch (IOException e) {System.out.println("image error");}
		
		this.setBackground(Color.black);
		
		title = new JLabel("Block Game");
		subtitle = new JLabel("JAVA Homework5");
		text = new JLabel("Press space to start");
	
		title.setFont(new Font("Serif",Font.BOLD,110));
		subtitle.setFont(new Font("Serif",Font.ITALIC,50));
		text.setFont(new Font("Serif",Font.ITALIC,30));
		
		title.setForeground(Color.white);
		subtitle.setForeground(Color.white);
		text.setForeground(Color.white);
		
		title.setBorder(BorderFactory.createEmptyBorder(20,30,0,30));
		subtitle.setBorder(BorderFactory.createEmptyBorder(0,100,310,100));
		
		add(title);
		add(subtitle);
		add(text);
		
		
		addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		
	}
	
	public void goToGamePage() {
		fr.state = 1;
		fr.changePanel();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
		
		g.fillRect(0,0,30,666);
		g.fillRect(0, 0, 686, 30);
		g.fillRect(0, 666-30, 686, 30);
		g.fillRect(686-30,0, 30, 666);
		g.drawImage(img, 150,270,400,300,null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {	
		//sound.stop();
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			goToGamePage();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
	

	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}
