package homework5;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class HW5 extends JFrame{
	
	int state;
	
	JPanel start_page;
	JPanel game_page;
	JPanel gameover_page;
	
	int score;
	int max_score;
	
	Sound sound;

	HW5(){
		setSize(700,700);
		
		setResizable(false);
		setTitle("Homework5 Practice");
		
		state = 0;
		score = 0;
		
		start_page = new StartPage(this);
		add(start_page);
		sound = new Sound();
		sound.play(0);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new HW5();
	}
	
	public void changePanel() {
		this.getContentPane().removeAll();
		
		if(state == 0) {
			start_page = new StartPage(this);
			this.add(start_page);
			sound = new Sound();
			sound.play(0);
			start_page.setFocusable(true);
			start_page.requestFocus();
		}
		else if(state == 1) {
			sound.stop();
			game_page = new BreakingBlocks(this);
			this.add(game_page);
			
			game_page.setFocusable(true);
			game_page.requestFocus();
		}
		else if(state == 2) {
			if(score>max_score) {
				max_score = score;
			}
			
			gameover_page = new GameResult(this,score,max_score);
			this.add(gameover_page);

			gameover_page.setFocusable(true);
			gameover_page.requestFocus();
		}
		revalidate();
		repaint();
	}
	
	
}