package Multiverse;

import java.awt.Color;
import java.util.ArrayList;

import Player.Player;

public class StageTest extends Stage {
	
	public StageTest(){
		
		m_boards = new ArrayList<Board>();
		m_board = new Board();	
		m_player = new Player(490,230);
		m_board.setBackColor(Color.black);	
		m_boards.add(m_board);
		
	}
	
	public void action(int frame){
			
		for(int i = 0 ; i < m_boards.size() ; i ++){
			m_board = m_boards.get(i);
			
			if(frame % 100 == 0){
				/*for(int i1 = 0; i1 < 10; i1 ++) {
					m_boards.get(i).addEnemy(1000, i1*50, Math.PI);
				}
				for(int i1 = 0; i1 < 8; i1 ++) {
					m_boards.get(i).addEnemy(0, i1*50 + 50, 0);
				}*/
				m_boards.get(i).setPlayer(m_player);
			}
	
			m_board.action(frame);
		}
		
	}

}
