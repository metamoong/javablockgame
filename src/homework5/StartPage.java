package homework5;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

class StartPage extends JPanel implements KeyListener{
	HW5 fr;
	Sound sound = new Sound();
	
	JLabel title;
	JLabel subtitle;
	JLabel text;
	
	Thread t;
	
	int state = 0;
	
	int width = 686;
	int height = 666;
	
	StartPage(HW5 _fr){
		fr = _fr;
		
		title = new JLabel("JAVA");
		subtitle = new JLabel("Homework5");
		text = new JLabel("Press space to start");
	
		title.setFont(new Font("Serif",Font.BOLD,150));
		subtitle.setFont(new Font("Serif",Font.ITALIC,80));
		text.setFont(new Font("Serif",Font.ITALIC,30));
		
		title.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		subtitle.setBorder(BorderFactory.createEmptyBorder(10,100,150,100));
		
		add(title);
		add(subtitle);
		add(text);
		
		addKeyListener(this);
		this.setFocusable(true);
		this.requestFocus();
		
		sound.play(0);
		
	}
	
	public void goToGamePage() {
		fr.state = 1;
		fr.changePanel();
	}
	
	protected void paintComponent(Graphics g) {
		g.setColor(Color.black);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {	
		sound.stop();
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			goToGamePage();
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}
}
