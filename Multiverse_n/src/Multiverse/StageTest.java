package Multiverse;

import java.awt.Color;
import java.util.ArrayList;

public class StageTest extends Stage {
	
	public StageTest(){
		
		m_boards = new ArrayList<Board>();
		m_board = new Board();
		m_board.addEnemy(50, 50, 0);
		m_board.addEnemy(800, 50, Math.PI);
		m_board.setBackColor(Color.black);
		m_boards.add(m_board);
		
	}
	
	public void action(int frame){
		
		for(int i = 0 ; i < m_boards.size() ; i ++){
			m_board = m_boards.get(i);
			m_board.action(frame);
		}
		
	}

}
