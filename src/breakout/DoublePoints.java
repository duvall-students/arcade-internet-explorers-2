package breakout;

//Sophie Halish

import highLevel.Breakables;
import highLevel.Hittable;

//Power up for Breakout game, doubles the point if it is hit
public class DoublePoints extends Hittable {

    private static final int POINT_VALUE = 5;
    private final int SIZE=30;
    private final static String DOUBLEPOINTPOWERUP="resources/pointspower.gif";

    public DoublePoints() {
        super(DOUBLEPOINTPOWERUP, POINT_VALUE);
        hittableView.setFitWidth(SIZE);
        hittableView.setFitHeight(SIZE);
    }

    //set random start location based on size
    public void setRandomLocation(int screenSize)
    {
        hittableView.setX(getRandomInRange(0,screenSize));
        hittableView.setY(getRandomInRange(0,screenSize/2));
    }


}
