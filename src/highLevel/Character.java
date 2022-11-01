package highLevel;

import javafx.scene.image.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;

public abstract class Character implements Objects{
	
	private Point2D velocity;
	protected ImageView characterView;
	private final int START_X = 150;
	private final int START_Y = 375;
	private final int SPEED = 40;
	
	
	
	// possibly might just make this a very basic constructor, update Paddle / SpaceShip as needed
    public Character(String image) {
        try{
            characterView=new ImageView(new Image(new FileInputStream(image)));
            characterView.setX(START_X);
            characterView.setY(START_Y);
        }
        catch(FileNotFoundException e){}
        velocity=new Point2D(SPEED, SPEED);
    }
	
	
    public void reset(){
        characterView.setX(START_X);
        characterView.setY(START_Y);
    }
    
    public void move(int direction) {
    	characterView.setX(characterView.getX() + ((SPEED) * direction));
    }
    
    public Node getView(){
        return characterView;
    }
    
    public double getX() {
    	return characterView.getX();
    }
    
    public double getY() {
    	return characterView.getY();
    }

}
