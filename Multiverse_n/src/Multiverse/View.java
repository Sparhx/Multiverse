package Multiverse;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JPanel{
	
	private static Stage m_stage;
	private static Board m_board;
	private static ArrayList<StarShip> m_ships = new ArrayList<StarShip>();
	@SuppressWarnings("unused")
	private static Player m_player;
	private static Windows m_wind =  new Windows();
	private static Color m_color = Color.PINK;
	
	public View(){
		m_wind.add(this);
	}
	
	public void drawStage(Stage stage){
		
		m_stage = stage;
		m_player = m_stage.getCurrentPlayer();
		m_board = m_stage.getCurrentBoard();
		m_ships = m_board.getShips();
		m_player = m_board.getPlayer();
		m_color = m_board.getBackColor();
		this.repaint();
	}
	
	public void paint(Graphics g) {
		this.setBackground(m_color);
		super.paint(g);
		
		if (!m_ships.isEmpty())
		{
			for (int i = 0; i < m_ships.size(); i++)
			{
				m_ships.get(i).draw(g);
			}
		}
	}
}

