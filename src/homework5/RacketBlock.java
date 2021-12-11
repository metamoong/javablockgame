package homework5;

import java.awt.Color;

class RacketBlock extends Block{
	int screen_width;
	int screen_height;
	float min;
	float max;
	
	RacketBlock(int width,int height){
		super(width/2f-width/5/2 , 0.8f*height, width/5f,30f,Color.gray);
		screen_width = width;
	}
	
	public void move(int dir) {
		if(x+dir+w>screen_width-30) {
			x = screen_width-30-w;
			return;
		}
		else if(x+dir<30) {
			x = 30;
			return;
		}
		x= x+dir*20;
	}
	
	@Override
	boolean isCollide(GameObject o) {
			Ball b = (Ball) o;
			if(b.y+b.r > y && b.y-b.r < y+h && b.x+b.r > x && b.x-b.r <x+w) {
				return true;
			}
			return false;		
		}

	@Override
	boolean isDead() {
		return false;
	}
	
}