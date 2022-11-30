package breakout;
//Sophie Halish

import highLevel.Breakables;

//Brick for breakout Game
public class Brick extends Breakables {
    private static final int POINTS_VALUE = 1;
    private static final int BREAK_AMOUNT = 1;
    private static final String BRICK_IMAGE = "resources/brick1.gif";

    public Brick(){
        super(BRICK_IMAGE, POINTS_VALUE, BREAK_AMOUNT);
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
