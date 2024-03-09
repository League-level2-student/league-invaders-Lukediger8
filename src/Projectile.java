import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	public Projectile(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
		speed = 10;

	}

	public int speed = 1;

	public void update() {
		y -= speed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);

	}

}
