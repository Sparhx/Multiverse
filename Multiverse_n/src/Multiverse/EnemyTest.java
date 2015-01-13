package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class EnemyTest extends StarShip{
	
	protected static final int V = 8 , LIFE = 10 , SIZE_H = 20 , SIZE_W = 20 , HBOX_W = 18, HBOX_H = 18;

	
	int t = 0;

	public EnemyTest(int px, int py, double direct) {
		super(px, py, SIZE_W, SIZE_H, HBOX_W, HBOX_H);
		setLife(LIFE);
		setV(V);
		setDirect(direct);
	}
	
	public void action(ArrayList<StarShip> ships) {
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
	
	private void shoot(ArrayList<StarShip> ships){
		PiouPiou bullet = new PiouPiou(
				(int) (x + Math.cos(direct)*this.sens*this.HBOX_W/2),
				(int) (y + Math.sin(direct)*this.sens*this.HBOX_H/2), 3, 3);
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
