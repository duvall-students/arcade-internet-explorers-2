package breakout;


import highLevel.Character;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import highLevel.Objects;

public class Paddle extends Character{


    private ImageView paddleView;
    private static final String PADDLE_IMAGE="resources/paddle.gif";


    public Paddle() {
    	super(PADDLE_IMAGE);
        paddleView.setFitHeight(10);
        paddleView.setFitWidth(90);
    }
    


}
