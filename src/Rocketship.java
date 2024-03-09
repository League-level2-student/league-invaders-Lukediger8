import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	public Rocketship(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
	}
	public int speed = 10;

	public void right() {
		x += speed;
	}

	public void left() {
		x -= speed;
	}

	public void up() {
		y -= speed;
	}

	public void down() {
		y += speed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
	

}