
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LeagueInvaders {
	public static void main(String[] args) {

		LeagueInvaders object = new LeagueInvaders();

		object.setup();

	}

	JFrame frame;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public class GamePanel extends JPanel implements ActionListener {

		final int MENU = 0;
		final int GAME = 1;
		final int END = 2;

		void updateMenuState() {

		}

		void updateGameState() {

		}

		void updateEndState() {

		}

		void drawMenuState(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("LEAGUE INVADERS", 30, 100);
			g.setFont(subTitle);
			g.setColor(Color.YELLOW);
			g.drawString("Press ENTER to Start", 150, 350);
			g.setFont(subTitle2);
			g.setColor(Color.YELLOW);
			g.drawString("Press SPACE for instructions", 122, 470);
		}

		void drawGameState(Graphics g) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}

		void drawEndState(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}

		Timer frameDraw;

		Font titleFont;
		Font subTitle;
		Font subTitle2;
		int currentState = MENU;

		public GamePanel() {
			titleFont = new Font("Arial", Font.PLAIN, 48);
			subTitle = new Font("Arial", Font.PLAIN, 18);
			subTitle2 = new Font("Arial", Font.PLAIN, 18);
		    frameDraw = new Timer(1000/60,this);
		    frameDraw.start();
		}

		@Override
		public void paintComponent(Graphics g) {
			g.fillRect(10, 10, 100, 100);
			if (currentState == MENU) {
				drawMenuState(g);
			} else if (currentState == GAME) {
				drawGameState(g);
			} else if (currentState == END) {
				drawEndState(g);
			}

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(currentState == MENU){
			    updateMenuState();
			}else if(currentState == GAME){
			    updateGameState();
			}else if(currentState == END){
			    updateEndState();
			}
			System.out.println("action");
		}


	}

	GamePanel game;

	LeagueInvaders() {
		frame = new JFrame();
		game = new GamePanel();
	}

	void setup() {
		frame.add(game);
		frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
