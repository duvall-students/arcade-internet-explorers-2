package breakout;


import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import highLevel.Objects;

public class Paddle implements Objects{

    private ImageView paddleView;
    private Point2D paddleVelocity;

    private static final int START_X=150;
    private static final int START_Y=375;
    private static final int PADDLE_SPEED=40;

    private static final String PADDLE_IMAGE="resources/paddle.gif";


    public Paddle()
    {
        try{
            paddleView=new ImageView(new Image(new FileInputStream(PADDLE_IMAGE)));
            paddleView.setFitHeight(10);
            paddleView.setFitWidth(90);
            paddleView.setX(START_X);
            paddleView.setY(START_Y);
        }
        catch(FileNotFoundException e){}
        paddleVelocity=new Point2D(PADDLE_SPEED,PADDLE_SPEED);

    }

    public void resetPaddle(){
        paddleView.setX(START_X);
        paddleView.setY(START_Y);
    }

    public void move(int direction){
        paddleView.setX(paddleView.getX()+ ((PADDLE_SPEED)*direction));
    }

    public Node getView()
    {
        return paddleView;
    }

}
