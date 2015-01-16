package Multiverse;

import java.util.ArrayList;

import Player.Player;

public abstract class Stage {
	
	protected static ArrayList<Board> m_boards ;
	protected static Board m_board;
	protected static Player m_player;
	
	public abstract void action(int frame);
	
	public Board getCurrentBoard(){return m_board;}
	public Player getCurrentPlayer(){return m_player;}

}
