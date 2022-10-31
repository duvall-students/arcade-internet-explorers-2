package galaga;

import highLevel.Character;
import javafx.scene.image.ImageView;


public class Spaceship extends Character{
	
	private ImageView shipView;
	private static final String SHIP_IMAGE = "resources/"; // get spaceship image
	
	
	public Spaceship () {
		super(SHIP_IMAGE);
        shipView.setFitHeight(20);
        shipView.setFitWidth(20);
		
	}
	

}
