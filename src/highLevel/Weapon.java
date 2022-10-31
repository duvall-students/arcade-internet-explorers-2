package highLevel;

import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import java.io.FileInputStream;


public abstract class Weapon {
	
	protected Point2D weaponVelocity;
	private final int weaponSpeed = 100;
	private final int weaponSize = 10;
	protected ImageView weaponView;

	
	
	// similar problem of character. how do we get the view we want?
	public Weapon(String image) throws FileNotFoundException {
            weaponView = new ImageView(new Image(new FileInputStream(image)));
            weaponVelocity = new Point2D(weaponSpeed, weaponSpeed);
	}


	public abstract void move();
	
	
    public Node getView(){
        return weaponView;
    }
	
	

}
