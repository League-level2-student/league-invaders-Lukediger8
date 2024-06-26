import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	

	public Alien(int a, int b, int c, int d) {
		super(a, b, c, d);
		// TODO Auto-generated constructor stub
		if (needImage) {
		    loadImage ("alien.png");
		}

	}

	
	public int speed = 1;
	public void update() { 
		y+=speed;
		  super.update();
	}
	
	public void draw(Graphics g) {
		   
	        if (gotImage) {
	        	g.drawImage(image, x, y, width, height, null);
	        } else {
	        	g.setColor(Color.BLUE);
	        	g.fillRect(x, y, width, height);
	        }
	        
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
}
	



