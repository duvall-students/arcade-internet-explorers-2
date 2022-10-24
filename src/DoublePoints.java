
//Sophie Halish

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DoublePoints extends Breakables{

    private ImageView doublePTView;
    private final int pointValue=5;
    private final int amountToBreak=1;
    private final int START_X=70;
    private final int START_Y=200;
    private final int SIZE=30;
    private final static String DOUBLEPOINTPOWERUP="resources/pointspower.gif";

    public DoublePoints(){
        try {
            doublePTView =new ImageView(new Image(new FileInputStream(DOUBLEPOINTPOWERUP)));
        } catch (FileNotFoundException e) {}
        doublePTView.setFitWidth(SIZE);
        doublePTView.setFitHeight(SIZE);
    }

    @Override
    public int getAmountToBreak() {
        return amountToBreak;
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    public Node getView(){
        return doublePTView;
    }

    public void setRandomLocation(int SIZE)
    {
        doublePTView.setX(getRandomInRange(0,SIZE));
        doublePTView.setY(getRandomInRange(0,SIZE/2));
    }

    //what happens when it intersects
    //where do I put it on the screen, you have set locations for the bricks? like in a line

}
