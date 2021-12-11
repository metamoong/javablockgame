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

public class GameResult extends JPanel implements KeyListener,Runnable {
	int score;
	int max_score;
	
	HW5 fr;
	JLabel text_gameover;
	JLabel text_score;
	JLabel text_info;
	JLabel text_info2;
	
	Thread t;
	BufferedImage img;
	
	GameResult(HW5 _fr,int _score,int _max_score){
		t = new Thread(this);
		t.start();
		
		URL url = getClass().getClassLoader().getResource("crying1.png");
		try {
			img = ImageIO.read(url);
			
		} catch (IOException e) {System.out.println("image error");}
		
		fr = _fr;
		score = _score;
		max_score = _max_score;
		
		this.setBackground(Color.black);
		
		text_gameover = new JLabel("Game Over");
		text_score = new JLabel("Your Score:"+score);
		text_info = new JLabel("Press space!!");
		text_info2 = new JLabel("1st score : "+max_score);
		
		text_gameover.setForeground(Color.white);
		text_score.setForeground(Color.white);
		text_info.setForeground(Color.white);
		text_info2.setForeground(Color.white);
		
		text_gameover.setFont(new Font("Serif",Font.BOLD,100));
		text_score.setFont(new Font("Serif",Font.BOLD,50));
		text_info.setFont(new Font("Serif",Font.ITALIC,30));
		text_info2.setFont(new Font("Serif",Font.ITALIC,20));
		
		text_gameover.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		text_score.setBorder(BorderFactory.createEmptyBorder(10,100,10,100));
		text_info.setBorder(BorderFactory.createEmptyBorder(200,200,15,200));
		text_info2.setBorder(BorderFactory.createEmptyBorder(0,200,15,200));
		
		add(text_gameover);
		add(text_score);
		add(text_info2);
		add(text_info);
		
		addKeyListener(this);
	}
	
	public void scoreUp() {
		score ++;
	}
	
	public void goToStartPage() {
		fr.state = 0;
		fr.changePanel();
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,270,370,150,150,null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			fr.state = 0;
			fr.changePanel();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void run() {
		while(true) {
			URL url = getClass().getClassLoader().getResource("crying1.png");
			try {
				img = ImageIO.read(url);
				
			} catch (IOException e) {System.out.println("image error");}
			repaint();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			url = getClass().getClassLoader().getResource("crying2.png");
			try {
				img = ImageIO.read(url);
				
			} catch (IOException e) {System.out.println("image error");}
			repaint();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
