import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	Random random = new Random();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship rocket2) {
		rocket = rocket2;
	}

	public void addProjectile(Projectile projectileObject) {
		projectiles.add(projectileObject);

	}

	public void addAlien() {
		aliens.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	public void update() {
		for (Alien alien : aliens) {
			alien.update();
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}
		for(Projectile projectile : projectiles) {
			projectile.update();
			if(projectile.y < 0){
				projectile.isActive = false;
			}
			
		}
			
		}
		checkCollision();
		purgeObjects();
	}

	public void checkCollision() {
		for(Alien alien : aliens) {
			for(Projectile projectile: projectiles) {
				if (projectile.collisionBox.intersects(alien.collisionBox)) {
					alien.isActive = false;
					projectile.isActive = false;
				}
			}
		}
		
	}

	public void draw(Graphics g) {
		// rocket.draw(g);
		for (Alien alien : aliens) {
			alien.draw(g);
		}
		for (Projectile projectile : projectiles) {
			projectile.draw(g);
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isActive ) {
				aliens.remove(i);
			}
		}
		
		for (int i = 0; i < projectiles.size(); i++) {
			if (!projectiles.get(i).isActive ) {
				projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();

	}

}
