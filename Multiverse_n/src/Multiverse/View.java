package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

import Player.Player;


@SuppressWarnings("serial")
public class View extends JPanel implements ActionListener {

	private static Stage m_stage;
	private static Board m_board;
	private static ArrayList<StarShip> m_ships = new ArrayList<StarShip>();
	private static Player m_player;
	private static Windows m_wind = new Windows();
	private static Color m_color = Color.PINK;

	public View() {
		m_wind.add(this);
		m_wind.addKeyListener(new TAdapter());
	}

	public void drawStage(Stage stage) {

		m_stage = stage;
		m_board = m_stage.getCurrentBoard();
		m_ships = m_board.getShips();
		m_player = m_stage.getCurrentPlayer();
		m_color = m_board.getBackColor();
		this.repaint();
	}

	public void paint(Graphics g) {
		this.setBackground(m_color);
		super.paint(g);

		if (!m_ships.isEmpty()) {
			for (int i = 0; i < m_ships.size(); i++) {
				m_ships.get(i).draw(g);
			}
		}
	}

	public void actionPerformed(ActionEvent e) {

		m_player.move();
		this.repaint();

	}
	
	public class TAdapter extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {
		
			m_player.keyPressed(e);

		}

		public void keyReleased(KeyEvent e) {
			
			m_player.keyReleased(e);

		}
	}


}
