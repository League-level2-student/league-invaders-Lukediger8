
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LeagueInvaders {
	public static void main(String[] args) {

		LeagueInvaders object = new LeagueInvaders();
		
		object.setup();

	}
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	JFrame frame;

	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public class GamePanel extends JPanel implements ActionListener, KeyListener {
		Rocketship rocketship;
		final int MENU = 0;
		final int GAME = 1;
		final int END = 2;
		ObjectManager objectManager;
		Timer frameDraw;
		Timer alienSpawn;
		Font titleFont;
		Font subTitle;
		Font subTitle2;
		int currentState = MENU;

		public GamePanel() {
			titleFont = new Font("Arial", Font.PLAIN, 48);
			subTitle = new Font("Arial", Font.PLAIN, 18);
			subTitle2 = new Font("Arial", Font.PLAIN, 18);
			frameDraw = new Timer(1000 / 60, this);
			frameDraw.start();
			alienSpawn = new Timer(1000 , objectManager);
			alienSpawn.start();
			rocketship = new Rocketship(250, 700, 50, 50);
			objectManager = new ObjectManager(rocketship);
			if (needImage) {
			    loadImage("space.png");
					
			}
			
			startGame();
		
		}
		
		void startGame() {
		    frameDraw = new Timer(1000/60, this);
		    frameDraw.start();
		    alienSpawn = new Timer(1000, objectManager);
		    alienSpawn.start();
		}
		
		void updateMenuState() {

		}

		void updateGameState() {
		objectManager.update();
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
		
		void loadImage(String imageFile) {
			if (needImage) {
		        try {
		            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		            gotImage = true;
		   
		        } catch (Exception e) {
		     
		        }
		        needImage = false;
		    }
		} 

		void drawGameState(Graphics g) {
			
			if (gotImage) {
				g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
							} 
			else {
				g.setColor(Color.BLUE);
				g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
			}
			rocketship.draw(g);
			objectManager.draw(g);
		}

		void drawEndState(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
			g.setFont(titleFont);
			g.setColor(Color.YELLOW);
			g.drawString("GAME OVER", 78, 100);
			g.setFont(subTitle);
			g.setColor(Color.YELLOW);
			g.drawString("You Killed Enemies", 150, 350);
			g.setFont(subTitle2);
			g.setColor(Color.YELLOW);
			g.drawString("Press ENTER to Restart", 122, 470);

		}

		@Override
		public void paintComponent(Graphics g) {
	
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
			if (currentState == MENU) {
				updateMenuState();
			} else if (currentState == GAME) {
				updateGameState();
			} else if (currentState == END) {
				updateEndState();
			}
			repaint();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				if (currentState == END) {
					currentState = MENU;
				} else {
					currentState++;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (rocketship.y > 0) {
					rocketship.up();
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (rocketship.y < 750) {
					rocketship.down();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (rocketship.x > 0) {
					rocketship.left();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (rocketship.x < 450) {
					rocketship.right();
				}
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				objectManager.addProjectile(rocketship.getProjectile());
			}
		
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

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
		frame.addKeyListener(game);
	}
}
