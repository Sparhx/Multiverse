package Multiverse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {
	int second = 0, time = 0;
	Timer timer;
	Ennemie mechant;
	ArrayList<StartShip> ships;

	public Board(Windows wind) {

		ships = new ArrayList<StartShip>();
		for (int i = 0; i < 10; i++) {
			if (i % 2 == 0) {
				mechant = new Ennemie(10, i * 100 % 500, 40, 20, 40, 20);
				mechant.setSens(1);
			} else {
				mechant = new Ennemie(990, i * 100 % 500, 40, 20, 40, 20);
				mechant.setSens(-1);
			}
			ships.add(mechant);
		}

		timer = new Timer(10, this);
		timer.start();
		this.setBackground(Color.black);
	}

	public void clean(ArrayList<StartShip> ships) {
		for (int i = 0; i < ships.size(); i++) {
			if (ships.get(i).getLife() <= 0) {
				if (ships.get(i) instanceof Player) {
					gameOver();
				}
				ships.remove(ships.get(i));
			}
		}
	}

	public void collide_board(ArrayList<StartShip> ships) {
		for (int i = 0; i < ships.size(); i++) {
			ships.get(i).collide(ships);
		}
	}

	public void action() {
		for (int i = 0; i < ships.size(); i++) {
			ships.get(i).action(ships);
		}
		collide_board(ships);
		clean(ships);
	}

	public void gameOver() {

	}

	public int getTime() {
		return second;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < ships.size(); i++) {
			ships.get(i).draw(g);
		}

		g.setFont(new Font("sanssherif", Font.BOLD, 13));
		g.setColor(Color.yellow);
		g.drawString("TIME : " + String.valueOf(second), 10, 10);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		time++;
		if (time % 100 == 0) {
			second++;
		}
	}
}
