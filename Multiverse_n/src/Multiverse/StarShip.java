package Multiverse;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class StarShip implements S_StarShip {

	protected final int SIZE_W, SIZE_H, HBOX_X, HBOX_Y;
	protected int x, y, vx = 0, vy = 0, sens = 1, index, life = 10, attack = 3,
			invul_curr_frame = -1;
	protected int FRAME_INVUL = 0;
	protected Rectangle HBOX;
	protected double direct = 0, v;
	protected boolean action_shoot = false, invulnerability = false;

	/* constructor */
	protected StarShip(int px, int py, int size_w, int size_h, int hbox_x,
			int hbox_y) {
		x = px;
		y = py;
		SIZE_W = size_w;
		SIZE_H = size_h;
		HBOX_X = hbox_x;
		HBOX_Y = hbox_y;
		HBOX = new Rectangle(x - HBOX_X / 2, y - HBOX_Y / 2, HBOX_X, HBOX_Y);
	}

	/* generic method */
	public void collide(ArrayList<StarShip> ships) {
		
		if(invulnerability == false ){
			for (int i = 0; i < ships.size(); i++) {
				if (HBOX.intersects(ships.get(i).HBOX)
						&& !ships.get(i).equals(this)) {
					setLife(life - ships.get(i).attack);
					if(getFRAME_INVUL() != 0) {
						invulnerability = true;
						invul_curr_frame = getFRAME_INVUL();
					}
				}
			}
		}
		else {
			invul_curr_frame --;
			if(invul_curr_frame <= 0){
				invulnerability = false;
			}
		}
	}

	protected void move() {
		vx = (int) (v * Math.cos(direct));
		vy = (int) (v * Math.sin(direct));
		x += vx * sens;
		y += vy * sens;
		HBOX = new Rectangle(x - HBOX_X / 2, y - HBOX_Y / 2, HBOX_X, HBOX_Y);
	}

	/* abstract method */
	public abstract void action(ArrayList<StarShip> ships, int frame);

	public abstract void draw(Graphics g);

	/* set & get */
	protected void setV(double speed) {
		v = speed;
	}

	public double getV() {
		return v;
	}

	protected void setLife(int l) {
		life = l;
	}

	public int getLife() {
		return life;
	}

	public void setDirect(double d) {
		direct = d;
	}

	public double getDirect() {
		return direct;
	}

	public void setSens(int s) {
		sens = s;
	}

	public int getSens() {
		return sens;
	}

	public int getFRAME_INVUL() {
		return FRAME_INVUL;
	}

	public void setFRAME_INVUL(int fRAME_INVUL) {
		FRAME_INVUL = fRAME_INVUL;
	}
}
