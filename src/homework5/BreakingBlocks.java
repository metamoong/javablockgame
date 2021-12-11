package homework5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JPanel;

class BreakingBlocks extends JPanel implements Runnable, KeyListener{
	HW5 fr;
	NewRound game;
	Sound sound;
	
	final float dtime = 1/30.0f;
	int round;
	int score;
	
	RacketBlock racket;
	LinkedList<GameObject> objs;

	
	BreakingBlocks(HW5 _fr) {
		sound = new Sound();
		fr = _fr;
		round = 1;
		game = new NewRound(1,round);//√π ∞‘¿”
		
		Thread t = new Thread(this);
		t.start();
		addKeyListener(this);	
		
		racket = game.racket;
		objs = game.objs;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.drawElements(g);
	}
	@Override
	public void run() {
		try {
			while(true) {
				for(GameObject o : objs)
					o.update(dtime);
				
				for(GameObject o1: objs)
				{
					if(o1 instanceof Ball) {
						for(GameObject o2: objs) {
							if(o1==o2) continue;
							if(o2 instanceof Block)
								o1.collisionResolution(o2);
						}		
					}
				}
				
				for(int i=0;i<objs.size();i++) {
					GameObject ob = objs.get(i);
					if(ob instanceof SpecialBlock) {
						SpecialBlock sp = (SpecialBlock)objs.get(i);
						if(sp.isDead()) {
							Ball b = new Ball(sp.x+sp.w/2,sp.y+sp.h+3);
							b.vy = 300;
							objs.add(b);
							b= new Ball (sp.x+sp.w/2,sp.y+sp.h+3);
							b.vy = 300;
							b.vx = 100;
							objs.add(b);
							game.ball_cnt+=2;
						}
					}
				}
				
				var it = objs.iterator();
				while(it.hasNext()) {
					GameObject ob;
					ob = it.next();
					if(ob.isDead() == true) {
						if(ob instanceof Ball) {game.ball_cnt--;}
						else if(ob instanceof Block) {
							game.score ++;
							game.block_cnt--;
						}
						it.remove();
					}
				}
				
				if(game.block_cnt == 0) {
					Sound so = new Sound();
					so.play(5);
					Thread.sleep(1000);
					round++;
					score = game.score;
					
					game = new NewRound(round,score);
					objs = game.objs;
					racket = game.racket;
				}
				else if(game.ball_cnt == 0) {
					Sound so = new Sound();
					so.play(2);
					
					fr.score = game.score;
					goToResultPage();
					break;
				}
				repaint();
				Thread.sleep((int)(dtime*1000));
			}
		}
		catch(InterruptedException e) {return;}
	}

	public void goToResultPage() {
		fr.state = 2;
		fr.changePanel();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			racket.move(-1);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			racket.move(1);
		}	
	}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
}