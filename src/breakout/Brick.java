package breakout;
//Sophie Halish

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import highLevel.Breakables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

//Brick for breakout Game
public class Brick extends Breakables {
    
	private final int pointValue=1;
    private int amountToBreak;
    public static final String BRICK_IMAGE = "resources/brick1.gif";

    public Brick(){
        super(BRICK_IMAGE);
        amountToBreak=1;
    }

    public int getPointValue()
    {
        return pointValue;
    }

    public int getAmountToBreak()
    {
        return amountToBreak;
    }

    public void brickHit(){
        amountToBreak--;
    }

    //set brick location
    //set width and height
    //screen size is 400 by 400
    public void setStartLocation(int currentBrick, int numBricks)
    {
            breakableView.setX(BRICK_WIDTH*currentBrick);
            breakableView.setY(BRICK_HEIGHT*(currentBrick+(numBricks/5)));
    }

}
