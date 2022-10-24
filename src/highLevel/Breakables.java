package highLevel;//Sophie Halish

import javafx.scene.Node;
import java.util.Random;

//For power-ups and bricks, since they are very similar
public abstract class Breakables {
    protected final int BRICK_WIDTH = 80;
    protected final int BRICK_HEIGHT = 20;
    private Random dice = new Random();

    public Breakables() {}

    public abstract int getAmountToBreak();

    public abstract int getPointValue();

    public int getRandomInRange (int min, int max) {
        return min + dice.nextInt(max - min) + 1;
    }

    public abstract Node getView();
}
