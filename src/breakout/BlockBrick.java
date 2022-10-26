package breakout;
//Sophie Halish
import highLevel.Breakables;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BlockBrick extends Breakables {

    public static final String BRICK_IMAGE = "resources/brick4.gif";

    public BlockBrick()
    {
        super(BRICK_IMAGE);
        //set brick size
        breakableView.setFitWidth(BRICK_WIDTH);
        breakableView.setFitHeight(BRICK_HEIGHT);

    }

    public void setStartLocation(int currentBrick, int numBricks)
    {
        breakableView.setX(BRICK_HEIGHT*currentBrick);
        breakableView.setY(BRICK_WIDTH*currentBrick);
    }

    //unbreakable so -1 is the amount to break, never able to break
    public int getAmountToBreak()
    {
        return -1;
    }

    // this brick acts as a wall, so you don't break it.
    public int getPointValue(){
        return 0;
    }


}
