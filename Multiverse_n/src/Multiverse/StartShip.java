package Multiverse;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class StartShip implements S_StartShip {

	protected final int SIZE_W, SIZE_H, HBOX_X, HBOX_Y;
	protected int vx, vy, x, y, sens = 1, index, life = 1, attack = 1;
	protected Rectangle HBOX;
	protected double direct = 0, v = 2;
	protected boolean action_shoot = false, invulnerability = false;

	protected StartShip(int px, int py, int size_w, int size_h, int hbox_x,
			int hbox_y) {
		x = px;
		y = py;
		SIZE_W = size_w;
		SIZE_H = size_h;
		HBOX_X = hbox_x;
		HBOX_Y = hbox_y;
		HBOX = new Rectangle(x - HBOX_X/2, y - HBOX_Y/2, HBOX_X, HBOX_Y);
	}

	protected void setV(double speed) {
		v = speed;
	}

	public double getV() {
		return v;
	}
	
	protected void setLife(int l){
		life = l;
	}
	
	public int getLife(){
		return life;
	}

	protected void setDirect(double d) {
		direct = d;
	}

	public double getDirect() {
		return direct;
	}

	protected void setSens(int s) {
		sens = s;
	}

	public int getSens() {
		return sens;
	}


	public boolean collide(ArrayList<StartShip> ships) {
		for (int i = 0; i < ships.size(); i++) {
			if (HBOX.intersects(ships.get(i).HBOX) && !ships.get(i).equals(this)) {
				setLife(life - ships.get(i).attack);
				return true;
			}
		}
		return false;
	}

	protected void move() {
		vx = (int) (v * Math.cos(direct));
		vy = (int) (v * Math.sin(direct));
		x += vx * sens;
		y += vy * sens;
		HBOX = new Rectangle(x - HBOX_X/2, y - HBOX_Y/2, HBOX_X, HBOX_Y);
	}

	public abstract void action(ArrayList<StartShip> ships);

	public abstract void draw(Graphics g);
}


