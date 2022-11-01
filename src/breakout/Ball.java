package breakout;


//Sophie Halish

import highLevel.Weapon;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;



import highLevel.Objects;

public class Ball extends Weapon{


   // private ImageView weaponView;


    private static final int START_X=200;//subject to change
    private static final int START_Y=345;//subject to change
    public static final String BOUNCER_IMAGE = "resources/ball.gif";


    public Ball() {
    	super(BOUNCER_IMAGE);
        // NEW SET SIZE OF 30, CAN BE CHANGED LATER
    	weaponView.setFitWidth(30);
    	weaponView.setFitHeight(30);
        // make sure it stays within the bounds
    	weaponView.setX(START_X);
    	weaponView.setY(START_Y);
    }

    public void resetBall(){
    	weaponView.setX(START_X);
    	weaponView.setY(START_Y);
    }

    //once a collision is detected, this method should be called
    //based on direction?(may change) it bounces off brick/paddle
    public void collision(){
    	weaponVelocity = new Point2D(weaponVelocity.getX(), -weaponVelocity.getY());
    }


    public void move(double elapsedTime) {
    	weaponView.setX(weaponView.getX() + weaponVelocity.getX() * elapsedTime);
    	weaponView.setY(weaponView.getY() + weaponVelocity.getY() * elapsedTime * -1);
    }

    public boolean bounce (double screenWidth, double screenHeight) {
        // collide all bouncers against the walls
        if(weaponView.getY() > screenHeight - weaponView.getBoundsInLocal().getHeight())//lose life if goes offbottom
        {
            //resetBall();
            return false;
        }
        if (weaponView.getX() < 0 || weaponView.getX() > screenWidth - weaponView.getBoundsInLocal().getWidth()) {
            weaponVelocity = new Point2D(-weaponVelocity.getX(), weaponVelocity.getY());
        }
        if (weaponView.getY() < 0) {
            weaponVelocity = new Point2D(weaponVelocity.getX(), -weaponVelocity.getY());
        }
        return true;
    }


}
