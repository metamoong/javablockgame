package homework5;

import java.awt.Graphics;

abstract class GameObject{
	abstract void draw(Graphics g);
	abstract void update(float dtime);
	abstract void collisionResolution(GameObject in);
	abstract boolean isDead();
}
