package galaga;

import highLevel.Breakables;
import javafx.geometry.Point2D;
//Sophie Halish

// Enemy class for Galaga Game, similar to Bricks in Breakout
public class Enemy extends Breakables {

    private final int pointValue=1;
    private int amountToBreak;

    private Point2D enemyVelocity;
    // enemy will slowly move down the screen
    private static final int ENEMY_SPEED=10;

    public static final String ENEMY_IMAGE="resources/enemy.png";

    public Enemy(){
        super(ENEMY_IMAGE);
        amountToBreak=1;
        // turn speed into velocity that can be updated on bounces
        enemyVelocity = new Point2D(ENEMY_SPEED,ENEMY_SPEED);
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
    //for now, same as brick but will most likely change
    public void setStartLocation(int currentBrick, int numBricks) {
        breakableView.setX(BRICK_WIDTH*numBricks);
        breakableView.setY(BRICK_HEIGHT*currentBrick);
    }

    public void enemyHit()
    {
        amountToBreak--;
    }

    //Want the enemies to slowly move down the screen, so only Y value changes
    public void move(double elapsedTime){
        breakableView.setY(breakableView.getY() + enemyVelocity.getY() * elapsedTime*-1);
    }
}
