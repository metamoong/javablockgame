package homework5;

import java.awt.Color;
import java.awt.Graphics;

class Block extends GameObject {
	float x,y;
	float w,h;
	Color color;
	boolean alive;
	
	Block(float _x, float _y, float _w, float _h, Color c){
		alive = true;
		x = _x;
		y = _y;
		w = _w;
		h = _h;
		color = c;
	}
	
	
	boolean isCollide(GameObject o) {
		
		Ball b = (Ball) o;
		if(b.y+b.r > y && b.y-b.r < y+h &&b.x+b.r > x && b.x-b.r <x+w) {
			alive = false;
			return true;
		}
		return false;		
	}
	
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillRect((int)x,  (int)y,  (int)w,  (int)h);
		if(!(this instanceof WallBlock)) {
			g.setColor(Color.LIGHT_GRAY);
			g.drawRect((int)x+4, (int)y+4, (int)w-8, (int)h-8);
			g.drawRect((int)x+5, (int)y+5, (int)w-10, (int)h-10);
		}
	}

	@Override
	void update(float dtime) {}

	@Override
	void collisionResolution(GameObject in) {}	
	
	boolean isDead() {
		return !alive;
	}
}