package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Board {

	private ArrayList<StarShip> m_ships;
	private Color m_backColor;

	public Board() {

		m_ships = new ArrayList<StarShip>();

	}

	public void addEnemy(int px, int py, double direct) {

		EnemyTest m_badGuy = new EnemyTest(px, py, direct);
		m_ships.add(m_badGuy);

	}

	public boolean clean() {
		
		for (int i = 0; i < m_ships.size(); i++) {
			if (m_ships.get(i).getLife() <= 0) {
				if (m_ships.get(i) instanceof Player) {
					return true;
				}
				m_ships.remove(m_ships.get(i));
			}
		}
		return false;
	}

	public void collide_board(ArrayList<StarShip> ships) {
		for (int i = 0; i < ships.size(); i++) {
			ships.get(i).collide(ships);
		}
	}

	public void action(int frame) {
		for (int i = 0; i < m_ships.size(); i++) {
			m_ships.get(i).action(m_ships);
		}
		collide_board(m_ships);
		clean();
	}

	public Color getBackColor() {return m_backColor;}
	
	public void setBackColor(Color color){m_backColor = color;}

	public Player getPlayer() {return null;}

	public ArrayList<StarShip> getShips() {return m_ships;}
	
}
