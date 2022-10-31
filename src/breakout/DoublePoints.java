package breakout;

//Sophie Halish

import javafx.scene.image.ImageView;
import highLevel.Breakables;

public class DoublePoints extends Breakables {
    private final int pointValue=5;
    private final int amountToBreak=1;
    private final int SIZE=30;
    private final static String DOUBLEPOINTPOWERUP="resources/pointspower.gif";

    public DoublePoints(){
        super(DOUBLEPOINTPOWERUP);
        breakableView.setFitWidth(SIZE);
        breakableView.setFitHeight(SIZE);
    }

    @Override
    public int getAmountToBreak() {
        return amountToBreak;
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    @Override
    public void setStartLocation(int currentBrick, int numBricks){}

    //set random start location based on size
    public void setRandomLocation(int SIZE)
    {
        breakableView.setX(getRandomInRange(0,SIZE));
        breakableView.setY(getRandomInRange(0,SIZE/2));
    }


}
