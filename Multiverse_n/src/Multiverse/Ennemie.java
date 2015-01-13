package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Ennemie extends StartShip{
	
	protected static final int V = 8;
	
	int t = 0;

	protected Ennemie(int px, int py, int size_w, int size_h, int hbox_w, int hbox_h) {
		super(px, py, size_w, size_h, hbox_w, hbox_h);
		setLife(10);
	}
	
	public void action(ArrayList<StartShip> ships) {
		t ++;
		action_shoot = false;
		
		if(t == 4){
			action_shoot = true;
			t = 0;
		}
		
		move();
		
		if(action_shoot){
			shoot(ships);
		}	
	}
	
	private void shoot(ArrayList<StartShip> ships){
		PiouPiou bullet = new PiouPiou(
				(int) (x + Math.cos(direct)*this.sens*this.HBOX_X/2),
				(int) (y + Math.sin(direct)*this.sens*this.HBOX_Y/2), 3, 3);
		bullet.setSens(this.getSens());
		bullet.setV(11);
		bullet.setDirect(this.getDirect());
		ships.add(bullet);
		bullet.who_shoot = ships.size();
	}
	
	public void draw(Graphics g) {
		if(invulnerability) {
			g.setColor(Color.green);
		}
		else {
			g.setColor(Color.gray);
		}
		g.fillRect(x - SIZE_W / 2, y - SIZE_H / 2, SIZE_W, SIZE_H);
	}
}
