package Player;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import bullets.PiouPiou;
import Multiverse.StarShip;

public class Player extends StarShip {

	protected static final int V = 0, LIFE = 20, SIZE_H = 20, SIZE_W = 20,
			HBOX_W = 18, HBOX_H = 18, FRAME_INVUL = 1, RELOAD = 4;

	private int m_frame = 0, m_dx = 0, m_dy = 0;

	public Player(int px, int py) {
		super(px, py, SIZE_W, SIZE_H, HBOX_W, HBOX_H);
		setLife(LIFE);
		setV(V);
		setDirect(direct);
		setFRAME_INVUL(FRAME_INVUL);
		action_shoot = false;
	}

	public void action(ArrayList<StarShip> ships, int frame) {

		move();
		
		if (action_shoot && (m_frame % RELOAD == 0)) {
			shoot(ships);
		}
	}

	public void move() {
		x += m_dx;
		y += m_dy;
		HBOX = new Rectangle(x - HBOX_X / 2, y - HBOX_Y / 2, HBOX_X, HBOX_Y);
	}

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			m_dx = -10;
		}

		if (key == KeyEvent.VK_RIGHT) {
			m_dx = 10;
		}

		if (key == KeyEvent.VK_UP) {
			m_dy = -10;
		}

		if (key == KeyEvent.VK_DOWN) {
			m_dy = 10;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			m_dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			m_dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			m_dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			m_dy = 0;
		}
	}

	private void shoot(ArrayList<StarShip> ships) {
		PiouPiou bullet = new PiouPiou((int) (x + Math.cos(direct) * this.sens
				* Player.HBOX_W / 2), (int) (y + Math.sin(direct) * this.sens
				* Player.HBOX_H / 2), 1, 1);
		bullet.setSens(getSens());
		bullet.setDirect(direct);
		ships.add(bullet);
		bullet.who_shoot = ships.size();
	}

	public void draw(Graphics g) {
		if (invulnerability) {
			g.setColor(Color.green);
		} else {
			g.setColor(Color.red);
		}
		g.fillRect(x - SIZE_W / 2, y - SIZE_H / 2, SIZE_W, SIZE_H);
	}

}
