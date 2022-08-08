package homework5;

import java.awt.Color;

class WallBlock extends Block {
	
	WallBlock(float _x,float _y,float _w, float _h){
		super(_x,_y,_w,_h,Color.black);
	}
	
	@Override
	boolean isDead() {
		return false;
	}
	
boolean isCollide(GameObject o) {
		
		Ball b = (Ball) o;
		if(b.y+b.r >= y && b.y-b.r <= y+h &&b.x+b.r >= x && b.x-b.r <=x+w) {
			return true;
		}
		
		return false;		
	}

}
