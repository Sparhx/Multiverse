package Multiverse;

import java.awt.Graphics;
import java.util.ArrayList;

public interface S_StarShip {
	
	boolean collide(ArrayList<StarShip> ships);
	void action(ArrayList<StarShip> ships);
	void draw(Graphics g);
}
