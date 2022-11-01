package breakout;
//Sophie Halish
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import highLevel.Objects;

public class Ball implements Objects{
    private ImageView ballView;
    private Point2D ballVelocity;
    private static final int BOUNCER_SPEED = 100;
    private static final int BOUNCER_SIZE = 30;
    private static final int START_X=200;//subject to change
    private static final int START_Y=345;//subject to change
    public static final String BOUNCER_IMAGE = "resources/ball.gif";


    public Ball(){
        try{
            ballView = new ImageView(new Image(new FileInputStream(BOUNCER_IMAGE)));
            // NEW SET SIZE OF 30, CAN BE CHANGED LATER
            ballView.setFitWidth(30);
            ballView.setFitHeight(30);
            // make sure it stays within the bounds
            ballView.setX(START_X);
            ballView.setY(START_Y);
            // turn speed into velocity that can be updated on bounces
            ballVelocity = new Point2D(BOUNCER_SPEED,BOUNCER_SPEED);}
        catch(FileNotFoundException e){}
    }

    public void resetBall(){
        ballView.setX(START_X);
        ballView.setY(START_Y);
    }

    //once a collision is detected, this method should be called
    //based on direction?(may change) it bounces off brick/paddle
    public void collision(){
        ballVelocity = new Point2D(ballVelocity.getX(), -ballVelocity.getY());
    }

    public void move (double elapsedTime) {
        ballView.setX(ballView.getX() + ballVelocity.getX() * elapsedTime);
        ballView.setY(ballView.getY() + ballVelocity.getY() * elapsedTime * -1);
    }

    public boolean bounce (double screenWidth, double screenHeight) {
        // collide all bouncers against the walls
        if(ballView.getY() > screenHeight - ballView.getBoundsInLocal().getHeight())//lose life if goes offbottom
        {
            //resetBall();
            return false;
        }
        if (ballView.getX() < 0 || ballView.getX() > screenWidth - ballView.getBoundsInLocal().getWidth()) {
            ballVelocity = new Point2D(-ballVelocity.getX(), ballVelocity.getY());
        }
        if (ballView.getY() < 0) {
            ballVelocity = new Point2D(ballVelocity.getX(), -ballVelocity.getY());
        }
        return true;
    }

    public Node getView(){
        return ballView;
    }

}
