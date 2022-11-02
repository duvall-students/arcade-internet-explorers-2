package breakout;
//Sophie Halish
import highLevel.Hittable;

public class BlockBrick extends Hittable {

    private static final int POINTS_VALUE = 0;
    private static final String BRICK_IMAGE = "resources/brick4.gif";

    public BlockBrick()
    {
        super(BRICK_IMAGE, POINTS_VALUE);
    }

    public void setStartLocation(int currentBrick, int numBricks)
    {
        hittableView.setX(BRICK_HEIGHT*currentBrick);
        hittableView.setY(BRICK_WIDTH*currentBrick);
    }

}
