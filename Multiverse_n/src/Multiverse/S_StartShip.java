package Multiverse;

import java.awt.Graphics;
import java.util.ArrayList;

public interface S_StartShip {
	
	boolean collide(ArrayList<StartShip> ships);
	void action(ArrayList<StartShip> ships);
	void draw(Graphics g);
}
