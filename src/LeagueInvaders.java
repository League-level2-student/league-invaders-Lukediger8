


import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
public static void main(String[] args) {
	


LeagueInvaders object = new LeagueInvaders();

object.setup();
	
}

	JFrame frame;
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	LeagueInvaders() {
		frame = new JFrame();
	}

	void setup() {
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

