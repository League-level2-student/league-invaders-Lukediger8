import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
	

	public Alien(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
		
		
	}
	
	public int speed = 1;
	public void update() {
		y+=speed;
	}
	
	public void draw(Graphics g) {
		   g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);
	}

	
}


