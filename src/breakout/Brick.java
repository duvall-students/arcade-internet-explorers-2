package breakout;
//Sophie Halish

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Brick extends Breakables{
    private final int pointValue=1;
    private int amountToBreak;

    public static final String BRICK_IMAGE = "resources/brick1.gif";
    private ImageView brickView;
    
    

    public Brick(){
        try{
            brickView =new ImageView(new Image(new FileInputStream(BRICK_IMAGE)));
        }
        catch(FileNotFoundException e){}
        //set brick size
        brickView.setFitWidth(BRICK_WIDTH);
        brickView.setFitHeight(BRICK_HEIGHT);
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

    public Node getView(){
        return brickView;
    }


    //set brick location
    //set width and height
    //screen size is 400 by 400
    public void setStartLocation(int currentBrick, int numBricks)
    {
            brickView.setX(BRICK_WIDTH*currentBrick);
            brickView.setY(BRICK_HEIGHT*(currentBrick+(numBricks/5)));
    }

}
