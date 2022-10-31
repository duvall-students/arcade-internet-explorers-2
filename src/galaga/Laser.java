package galaga;

import java.io.FileNotFoundException;

import highLevel.Weapon;
import javafx.scene.image.ImageView;

public class Laser extends Weapon {
	
	private ImageView laserView;
	private static final String LASER_IMAGE = "resources/";
	
	public Laser() {
		super(LASER_IMAGE);
		laserView.setFitHeight(10);
		laserView.setFitWidth(10);
	
	}
	
	public void move() {
		
	}
	
	public void shoot() {
		
	}
	
	public void setStartLocation() {
		
	}
	


}
	
	
	
	


