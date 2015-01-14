package Multiverse;

import java.awt.Graphics;
import java.util.ArrayList;

public interface S_StarShip {
	
	void collide(ArrayList<StarShip> ships);
	void action(ArrayList<StarShip> ships, int frame);
	void draw(Graphics g);
}
