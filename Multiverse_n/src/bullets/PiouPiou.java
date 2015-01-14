package bullets;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import Multiverse.StarShip;

public class PiouPiou extends StarShip {

	private static final int V = 10;
	public int who_shoot = 0;

	public PiouPiou(int px, int py, int size_w, int size_h) {
		super(px, py, size_w, size_h, size_w, size_h);
		v = V;
	}

	public void action(ArrayList<StarShip> ships, int frame) {
		move();
	}

	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x - SIZE_W / 2, y - SIZE_H / 2, SIZE_W, SIZE_H);
	}
	
	public void setShoot(int s) {
		who_shoot = s;
	}

	public int getShoot() {
		return who_shoot;
	}
}
