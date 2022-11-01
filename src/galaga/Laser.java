package galaga;

import highLevel.Weapon;
import javafx.scene.image.ImageView;

public class Laser extends Weapon {
	
	private ImageView laserView;

	private static final String LASER_IMAGE = "resources/laser.png";
	
	public Laser() {
		super(LASER_IMAGE);
		laserView.setFitHeight(10);
		laserView.setFitWidth(10);
	
	}
	
	public void move(double elapsedTime) {
		laserView.setY(laserView.getY() + weaponVelocity.getY() * elapsedTime * -1);
	}
	
	public void shoot() {
		
	}
	
	public void setStartLocation(int startX, int startY) {
		laserView.setX(startX);
		laserView.setY(startY);
		
	}
	


}
	
	
	
	


