package enemies;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import bullets.PiouPiou;
import Multiverse.StarShip;

public class EnemyTest extends StarShip {

	protected static final int V = 6, LIFE = 12, SIZE_H = 20, SIZE_W = 20,
			HBOX_W = 18, HBOX_H = 18, FRAME_INVUL = 1, RELOAD = 4;
	private int m_frame = 0, switch_direct = -3;

	public EnemyTest(int px, int py, double direct) {
		super(px, py, SIZE_W, SIZE_H, HBOX_W, HBOX_H);
		setLife(LIFE);
		setV(V);
		setDirect(direct);
		setFRAME_INVUL(FRAME_INVUL);
		action_shoot = true;
	}

	public void action(ArrayList<StarShip> ships, int frame) {
		double tmp_direct = getDirect();
		m_frame ++;

		if(m_frame % 4 == 0) {
	
			if(switch_direct >= 0){
				tmp_direct += Math.PI/12*getSens();
			}
			else if (switch_direct < 0){
				tmp_direct -= Math.PI/12*getSens();
			}
				
			switch_direct ++;
			if(switch_direct == 6){
				switch_direct = -6;
			}
		}
			
		setDirect(tmp_direct);
		
		move();
			
		if(RELOAD == 0) {
			shoot(ships);
		}
		else if (action_shoot && m_frame % RELOAD == 0) {
			shoot(ships);
		}
	}

	private void shoot(ArrayList<StarShip> ships) {
		PiouPiou bullet = new PiouPiou((int) (x + Math.cos(direct) * this.sens
				* EnemyTest.HBOX_W / 2), (int) (y + Math.sin(direct)
				* this.sens * EnemyTest.HBOX_H / 2), 1, 1);
		bullet.setSens(getSens());
		bullet.setDirect(direct);
		ships.add(bullet);
		bullet.who_shoot = ships.size();
	}

	public void draw(Graphics g) {
		if (invulnerability) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.gray);
		}
		g.fillRect(x - SIZE_W / 2, y - SIZE_H / 2, SIZE_W, SIZE_H);
	}
}
