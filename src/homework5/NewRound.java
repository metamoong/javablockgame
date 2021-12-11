package homework5;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

public class NewRound{
		final int round;
		final int panel_width = 686;
		final int panel_height = 666;
		
		RacketBlock racket;
		LinkedList<GameObject> objs = new LinkedList<>();
		
		int ball_cnt;
		int score;
		int block_cnt;
		
		NewRound(int _round,int _score){
			round = _round;
			score = _score;
			ball_cnt = 1;
			block_cnt = (_round*2+1)*(_round*2+1);
			
			racket = new RacketBlock(panel_width,panel_height);
			objs = new LinkedList<>();
			
			objs.add(racket);
			objs.add(new WallBlock(0,0,panel_width,30));
			objs.add(new WallBlock(0,0,30,panel_height));
			objs.add(new WallBlock(panel_width-30,0,30,panel_height));
			objs.add(new Ball(racket.x+racket.w/2,racket.y-5));
			
			makeBlocks();
		}
		
		public void drawElements(Graphics g) {
			racket.draw(g);
			
			for(GameObject o : objs)
				o.draw(g);
		}

		public void makeBlocks() {

			float block_area_width = panel_width-60;
			float block_area_height = panel_height*0.6f;
			float block_x=30;
			float block_y=30;
			float block_width = block_area_width/(2*round+1);
			float block_height = block_area_height/(2*round+1);
			
			for(int i=0;i<2*round+1;i++) {
				block_x = 30;
				for(int j=0;j<2*round+1;j++) {
					int random = (int)(Math.random()*4);
					if(random == 1) {objs.add(new SpecialBlock(block_x,block_y,block_width,block_height,Color.pink));}
					else{objs.add(new Block(block_x,block_y,block_width,block_height,Color.cyan));}
					block_x +=block_width;
				}
				block_y+=block_height;
			
			}
			
		}
}
