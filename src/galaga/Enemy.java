package galaga;

import highLevel.Breakables;
import javafx.geometry.Point2D;
//Sophie Halish

// Enemy class for Galaga Game, similar to Bricks in Breakout
public class Enemy extends Breakables {
    private static final int ENEMY_CENTERING = 75; //makes the enemys centered on the screen
    private static final int POINTS_VALUE = 1;
    private static final int BREAK_AMOUNT = 1;
    private final int ENEMY_WIDTH = 40;
    private final int ENEMY_HEIGHT = 40;
    private Point2D enemyVelocity;
    // enemy will slowly move down the screen
    private static final int ENEMY_SPEED=1;

    private static final String ENEMY_IMAGE="resources/enemy.png";

    public Enemy(){
        super(ENEMY_IMAGE, POINTS_VALUE, BREAK_AMOUNT);
        // turn speed into velocity that can be updated on bounces
        enemyVelocity = new Point2D(ENEMY_SPEED,ENEMY_SPEED);
        hittableView.setFitWidth(ENEMY_WIDTH);
        hittableView.setFitHeight(ENEMY_HEIGHT);
    }
    @Override
    //enemies are lined up starting more in middle of screen
    public void setStartLocation(int currentBrick, int numBricks) {
        hittableView.setX((ENEMY_WIDTH*currentBrick)+ ENEMY_CENTERING);
        hittableView.setY(ENEMY_HEIGHT*numBricks);
    }

    //Want the enemies to slowly move down the screen, so only Y value changes
    public void move(double elapsedTime){
        hittableView.setY(hittableView.getY() + enemyVelocity.getY() * elapsedTime*1);
    }

    //checks if it went off the bottom
    public boolean escapes(double screenHeight){
        return !(hittableView.getY() > screenHeight - hittableView.getBoundsInLocal().getHeight());
    }
}
