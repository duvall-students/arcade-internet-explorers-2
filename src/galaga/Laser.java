package galaga;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import highLevel.Weapon;
import javafx.scene.image.Image;


public class Laser extends Weapon {
	
	public static final String LASER_IMAGE = "resources/laser.png";

	
	public Laser() {
		super(LASER_IMAGE);
		weaponView.setFitHeight(50);
		weaponView.setFitWidth(50);
	}
	
	public void move(double elapsedTime) {
		weaponView.setY(weaponView.getY() + weaponVelocity.getY() * elapsedTime * -1);

	}
	
	public void hide() {
		weaponView.setImage(null);
	}
	
	public void shoot() {
		try {
		weaponView.setImage(new Image(new FileInputStream(LASER_IMAGE)));}
		catch(FileNotFoundException e){}
	}
	
	public void setStartLocation(double startX, double startY) {
		weaponView.setX(startX);
		weaponView.setY(startY);
		
	}
	


}
	
	
	
	


