package breakout;

// Sibel Tanik


import highLevel.Character;

public class Paddle extends Character{

    private static final String PADDLE_IMAGE="resources/paddle.gif";

    public Paddle() {
    	super(PADDLE_IMAGE);
    	characterView.setFitHeight(10);
    	characterView.setFitWidth(90);
    }


}
