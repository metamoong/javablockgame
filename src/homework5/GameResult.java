package homework5;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameResult extends JPanel implements KeyListener {
	int score;
	int max_score;
	
	HW5 fr;
	JLabel text_gameover;
	JLabel text_score;
	JLabel text_info;
	JLabel text_info2;
	
	GameResult(HW5 _fr,int _score,int _max_score){
		fr = _fr;
		score = _score;
		max_score = _max_score;
		
		text_gameover = new JLabel("Game Over");
		text_score = new JLabel("Your Score:"+score);
		text_info = new JLabel("Press space!!");
		text_info2 = new JLabel("1st score : "+max_score);
		
		
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
}
