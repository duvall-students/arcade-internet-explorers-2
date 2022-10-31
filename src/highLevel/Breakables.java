package highLevel;//Sophie Halish

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

//For power-ups and bricks, since they are very similar
public abstract class Breakables {
    protected final int BRICK_WIDTH = 80;
    protected final int BRICK_HEIGHT = 20;
    private Random dice = new Random();

    protected ImageView breakableView;


    public Breakables(String image) {
        try{
            breakableView =new ImageView(new Image(new FileInputStream(image)));
        }
        catch(FileNotFoundException e){}
        breakableView.setFitWidth(BRICK_WIDTH);
        breakableView.setFitHeight(BRICK_HEIGHT);
    }

    public abstract int getAmountToBreak();

    public abstract int getPointValue();

    public int getRandomInRange (int min, int max) {
        return min + dice.nextInt(max - min) + 1;
    }

    public Node getView(){
        return breakableView;
    }

    public abstract void setStartLocation(int currentBrick, int numBricks);

}
