package highLevel;

import javafx.scene.image.Image;
import javafx.geometry.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.ImageView;
import javafx.scene.Node;
import java.io.FileInputStream;


public abstract class Weapon implements Objects{
	
	public Point2D weaponVelocity;
	private final int weaponSpeed = 100;
	public ImageView weaponView;
	

	public Weapon(String image){
            try {
				weaponView = new ImageView(new Image(new FileInputStream(image)));
			} catch (FileNotFoundException e) {}
            weaponVelocity = new Point2D(weaponSpeed, weaponSpeed);
	}

	public abstract void move(double elapsedTime);
	
	
    public Node getView(){
        return weaponView;
    }
	
	

}
