package highLevel;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public abstract class Hittable implements Objects{

    protected final int BRICK_WIDTH = 80;
    protected final int BRICK_HEIGHT = 20;
    protected int pointValue;
    protected ImageView hittableView;

    private Random dice = new Random();


    public Hittable(String image, int points){
        try {
            hittableView = new ImageView(new Image(new FileInputStream(image)));
        } catch (FileNotFoundException e) {
        }
        pointValue=points;
    }

    public int getPointValue(){
        return pointValue;
    }

    public Node getView(){
        return hittableView;
    }

    public int getRandomInRange (int min, int max) {
        return min + dice.nextInt(max - min) + 1;
    }
}
