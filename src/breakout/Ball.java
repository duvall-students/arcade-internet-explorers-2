package breakout;

import java.io.FileNotFoundException;

//Sophie Halish

import highLevel.Weapon;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;


public class Ball extends Weapon {
    private ImageView ballView;

    private double elapsedTime;
    private static final int START_X=200;//subject to change
    private static final int START_Y=345;//subject to change
    public static final String BOUNCER_IMAGE = "resources/ball.gif";


    public Ball() throws FileNotFoundException{
    	super(BOUNCER_IMAGE);
        // NEW SET SIZE OF 30, CAN BE CHANGED LATER
        ballView.setFitWidth(30);
        ballView.setFitHeight(30);
        // make sure it stays within the bounds
        ballView.setX(START_X);
    }

    public void resetBall(){
        ballView.setX(START_X);
        ballView.setY(START_Y);
    }

    //once a collision is detected, this method should be called
    //based on direction?(may change) it bounces off brick/paddle
    public void collision(){
    	weaponVelocity = new Point2D(weaponVelocity.getX(), -weaponVelocity.getY());
    }


    public void move() {
        ballView.setX(ballView.getX() + weaponVelocity.getX() * elapsedTime);
        ballView.setY(ballView.getY() + weaponVelocity.getY() * elapsedTime * -1);
    }

    public boolean bounce (double screenWidth, double screenHeight) {
        // collide all bouncers against the walls
        if(ballView.getY() > screenHeight - ballView.getBoundsInLocal().getHeight())//lose life if goes offbottom
        {
            //resetBall();
            return false;
        }
        if (ballView.getX() < 0 || ballView.getX() > screenWidth - ballView.getBoundsInLocal().getWidth()) {
            weaponVelocity = new Point2D(-weaponVelocity.getX(), weaponVelocity.getY());
        }
        if (ballView.getY() < 0) {
            weaponVelocity = new Point2D(weaponVelocity.getX(), -weaponVelocity.getY());
        }
        return true;
    }


}
