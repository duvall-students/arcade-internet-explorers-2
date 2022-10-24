//Sophie Halish
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BlockBrick extends Brick{

    public static final String BRICK_IMAGE = "resources/brick4.gif";

    private ImageView brickView;

    public BlockBrick()
    {
        try{
            brickView =new ImageView(new Image(new FileInputStream(BRICK_IMAGE)));
        }
        catch(FileNotFoundException e){}
        //set brick size
        brickView.setFitWidth(BRICK_WIDTH);
        brickView.setFitHeight(BRICK_HEIGHT);

    }

    public void setStartLocation(int currentBrick, int numBricks)
    {
        brickView.setX(BRICK_HEIGHT*currentBrick);
        brickView.setY(BRICK_WIDTH*currentBrick);
    }
    public Node getView(){
        return brickView;
    }

    public void brickHit(){}


}
