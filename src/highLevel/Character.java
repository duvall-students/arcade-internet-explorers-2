package highLevel;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public class Character {
	
	private Point2D velocity;
	private ImageView characterView;
	private final int START_X = 150;
	private final int START_Y = 375;
	private final int SPEED = 40;
	
	private final String CHARACTER_IMAGE = " " // where do we find the character
			
			
	/// unsure about this one, all about getting the right image		
	public String getCharacterImage(String paddleImage, String spaceShipImage) {
		if(paddleImage.equals("resources/paddle.gif")) {
			return paddleImage;
		}
		if(spaceShipImage.equals("")) { // has she given us a place to get space ship image?
			return spaceShipImage;
		}
	}
	
	
	// possibly might just make this a very basic constructor, update Paddle / SpaceShip as needed
    public Character() {
        try{
            characterView=new ImageView(new Image(new FileInputStream(CHARACTER_)));
            characterView.setFitHeight(30); // rough draft of sizes. depends on waht it looks like
            characterView.setFitWidth(30);
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

}
