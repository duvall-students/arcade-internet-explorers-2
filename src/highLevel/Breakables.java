package highLevel;//Sophie Halish

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

//For power-ups and bricks, since they are very similar
public abstract class Breakables extends Hittable implements Objects {
    private int amountToBreak;

    public Breakables(String image, int points, int breakAmount) {
        super(image,points);
        amountToBreak=breakAmount;
    }
    public int getAmountToBreak() {
        return amountToBreak;
    }

    public abstract void setStartLocation(int currentBrick, int numBricks);

    public void beenHit(){
        amountToBreak--;
    }

}
