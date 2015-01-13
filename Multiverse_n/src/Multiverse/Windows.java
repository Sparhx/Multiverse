package Multiverse;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Windows extends JFrame {

	public Windows() {
		this.setTitle("Multiverse");
		this.setSize(1000,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
}
