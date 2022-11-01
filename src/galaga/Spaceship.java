package galaga;

import highLevel.Character;
import javafx.scene.image.ImageView;


public class Spaceship extends Character{
	
	//private ImageView shipView;
	public static final String SHIP_IMAGE = "resources/spaceship.png"; // get spaceship image
	
	
	public Spaceship () {
		super(SHIP_IMAGE);
		characterView.setFitHeight(20);
		characterView.setFitWidth(20);

	}
	

}
