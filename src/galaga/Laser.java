package galaga;

import highLevel.Weapon;
import javafx.scene.image.ImageView;

public class Laser extends Weapon {
	
	

	private static final String LASER_IMAGE = "resources/laser.png";
	
	public Laser() {
		super(LASER_IMAGE);
		weaponView.setFitHeight(10);
		weaponView.setFitWidth(10);
	
	}
	
	public void move(double elapsedTime) {
		weaponView.setY(weaponView.getY() + weaponVelocity.getY() * elapsedTime * -1);
	}
	
	public void shoot() {
		
	}
	
	public void setStartLocation(double startX, double startY) {
		weaponView.setX(startX);
		weaponView.setY(startY);
		
	}
	


}
	
	
	
	


