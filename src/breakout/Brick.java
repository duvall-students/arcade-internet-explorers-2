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
    public static final int POINTS_VALUE = 1;
    public static final int BREAK_AMOUNT = 1;
    public static final String BRICK_IMAGE = "resources/brick1.gif";

    public Brick(){
        super(BRICK_IMAGE, POINTS_VALUE, BREAK_AMOUNT);
        //amountToBreak=1;
        hittableView.setFitWidth(BRICK_WIDTH);
        hittableView.setFitHeight(BRICK_HEIGHT);
    }

    //set brick location
    //diagonal along the screen
    public void setStartLocation(int currentBrick, int numBricks)
    {
            hittableView.setX(BRICK_WIDTH*currentBrick);
            hittableView.setY(BRICK_HEIGHT*(currentBrick+(numBricks/5)));
    }

}
