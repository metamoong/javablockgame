package homework5;

import java.awt.Color;
import java.awt.Graphics;

class Ball extends GameObject{
	float x, y;
	float prev_x, prev_y;
	float vx, vy;
	float r;
	Color color;
	
	Ball(float _x, float _y){
		x = _x;
		y = _y;
		
		//float angle = (float)(Math.random()*360) * 3.141592f / 180.0f;
		vx = 50;
		vy =-300;
		//vx = (float) (speed*Math.cos(angle));
		//vy = (float) (speed*Math.sin(angle));
		r = 7;
		prev_x = x;
		prev_y = y;
		color = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
	}
	
	
	@Override
	void draw(Graphics g) {
		g.setColor(color);
		g.fillOval((int)(x-r), (int)(y-r),(int) (2*r), (int)(2*r));
	}
	@Override
	void update(float dtime) {
		prev_x = x;
		prev_y = y;
		x = x + vx*dtime;
		y = y + vy*dtime;
	}
	@Override
	void collisionResolution(GameObject in) {
		Block b = (Block) in;
		if(b.isCollide(this)==false) return;

		else {
			if(prev_y + r < b.y ) {y = b.y-r; vy = -vy;}; 
			if(prev_y - r > b.y + b.h) {y = b.y+ b.h + r; vy = -vy;};
			if(prev_x + r <b.x) { x = b.x - r; vx = -vx;};
			if(prev_x -r >b.x + b.w) { x= b.x +b.w +r; vx=-vx;}
		}
		
		if(b instanceof RacketBlock) {
			if(x<b.x+b.w/3) {
				if(vx>0) {
					vx = -vx; 
				}
			}
			else if(x>b.x+b.w/3*2) {
				if(vx<0) {
					vx = -vx;
				}
			}
		}
		
		
		
		if(b instanceof SpecialBlock) {
			Sound so = new Sound();
			so.play(4);
		}
		else if(b instanceof RacketBlock) {	
			Sound so = new Sound();
			so.play(1);
		}
		else if(b instanceof WallBlock) {return;}
		else {
			Sound so = new Sound();
			so.play(3);
		}
		
	}
	
	boolean isDead() {
		if(prev_x<0||prev_x>688||prev_y<0||prev_y>666) {
			return true;
		}
		return false;
	}

}
