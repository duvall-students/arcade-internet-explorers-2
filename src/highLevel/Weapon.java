package highLevel;

import java.awt.Image;
import javafx.geometry.Point2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Weapon {
	
	private Point2D velocity;
	private final int SPEED = 100;
	private final int size = 10;
	private ImageView weaponView;
	
	
	// similar problem of character. how do we get the view we want?
	public Weapon() {
	    
	 //       try{
	   //         weaponView=new ImageView(new Image(new FileInputStream(CweaponView)));
	            weaponView.setFitHeight(30); // rough draft of sizes. depends on what it looks like
	            weaponView.setFitWidth(30); 

	        
	 //       catch(FileNotFoundException e){}
	        velocity=new Point2D(SPEED, SPEED);
	}

	    
	
	
	public abstract void move();
	
    public Node getView(){
        return weaponView;
    }
	
	

}
