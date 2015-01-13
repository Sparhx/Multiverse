package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class PiouPiou extends StartShip{
	
	protected int who_shoot = 0;

	protected PiouPiou(int px, int py, int size_w, int size_h) {
		super(px, py, size_w, size_h, size_w, size_h);
	}
	
	public void setShoot(int s){
		who_shoot = s;
	}
	
	public int getShoot(){
		return who_shoot;
	}

	
	public void action(ArrayList<StartShip> ships) {
		move();
	}

	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x - SIZE_W / 2, y - SIZE_H / 2, SIZE_W, SIZE_H);
	}

}
