package breakout;



import java.util.ArrayList;
import java.util.List;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import highLevel.Breakables;
import highLevel.Objects;
import highLevel.Player;
import highLevel.SettingScene;
import highLevel.VideoGame;

public class PlayBreakout extends SettingScene{
	
	
	//background and scene setting variables
	private int BRICKAMOUNT=5;
	public static final String TITLE = "Breakout";
	public int POINTMULTIPLIER=1;
	public int PLAYERLIVES=3;
	public int CURRENTSCORE=0;
	public int HIGHESTSCORE = 0;
	private int level=1;
	private int variableX=10;
	private int variableY=390;

	//instance variables for the game
	public Ball theBall=new Ball();
	public Brick myBrick;
	public Paddle userPaddle=new Paddle();
	
	
	//lists of multiple variations
	public List<Brick> myBricks=new ArrayList<>();;
	public List<BlockBrick> myBlocks=new ArrayList<>();;
	public List<Breakables> myPowerUps=new ArrayList<>();;
	public List<String> allMySayings=new ArrayList<>();

	
	public void objectsInScene() {
		myObjects.add(theBall);
		myObjects.add(userPaddle);
	}
	
	
	// Change properties of shapes in small ways to animate them over time
    public void step (double elapsedTime) {
    	
        // updated the ball location over time
        theBall.move(elapsedTime);

        // if it hits wall, bounces
		boolean bounceVariable=theBall.bounce(myScene.getWidth(), myScene.getHeight());
		
        // check for collision
        // collision(1) means it hit brick, collision(0) means it hit paddle
		for (Brick brick : myBricks) {
			if ( theBall.getView().getBoundsInParent().intersects(brick.getView().getBoundsInParent())) {
				theBall.collision();
				brickCollision(brick);
				
				//print it
				Text text2=new Text();
		    	String currentPoints="Current Points: "+CURRENTSCORE;
		    	text2.setText(currentPoints);
		    	text2.setX(10);
		    	text2.setY(370);
		    	root.getChildren().set(1,text2);
			}
		}
		for(BlockBrick wall : myBlocks) {
			if ( theBall.getView().getBoundsInParent().intersects(wall.getView().getBoundsInParent())){
				theBall.collision();
			}
		}

		for (Breakables powerUp : myPowerUps)
		{
			if(theBall.getView().getBoundsInParent().intersects(powerUp.getView().getBoundsInParent()))
			{
				myPowerUps.remove(powerUp);
				root.getChildren().remove(powerUp.getView());
				//increase point multiplier
				POINTMULTIPLIER++;
			}
		}
		if (myBricks.isEmpty()) {
//			onLevelOne=false;
			level++;
			//message about new level
			Text restart=new Text();
			String message="Level Complete \n To start next level, click anywhere on the screen";
			restart.setText(message);
			restart.setX(100);
			restart.setY(100);
			root.getChildren().add(restart);
			advanceLevel(level);
			//locationOfMessage=root.getChildren().indexOf(restart);
			root.getChildren().remove(restart);
			//restart if clicked	
		}
		
		if ( theBall.getView().getBoundsInParent().intersects(userPaddle.getView().getBoundsInParent()) ) {
			theBall.collision();
		}
		
		//this is not the correct bounds, but basically if it goes past a certain boundry point, I just dont know what H means
		if (!bounceVariable) {
			//resets both and bounces
			userPaddle.reset();
			theBall.resetBall();
			theBall.collision();
			// player loses life. Problem is that Points/Player is not in this package
			myPlayer.loseLife();
			PLAYERLIVES=myPlayer.getLifeAmount();
			Text text=new Text();
	    	String welcome="Lives Left: "+PLAYERLIVES;
	    	text.setText(welcome);
	    	text.setX(10);
	    	text.setY(390);
			root.getChildren().set(0, text);
			
		}
		
		if (myPlayer.getLifeAmount()==0) {
			root.getChildren().clear();
			Text endMessage=new Text();
			String message="You Lost :( \n Your point value was "+myPlayer.getCurrentScore();
			endMessage.setText(message);
			endMessage.setX(150);
			endMessage.setY(150);
			root.getChildren().add(endMessage);
		}
	}

	private void brickCollision(Brick brick) {
		brick.brickHit();

		if(brick.getAmountToBreak()==0)
		{
			//this works but errors pop up and i am not sure why
			myBricks.remove(brick);
			root.getChildren().remove(brick.getView());

			//add to points
			int brickValue=brick.getPointValue();
			myPlayer.increaseCurrentScore(brickValue*POINTMULTIPLIER);
			CURRENTSCORE=myPlayer.getCurrentScore();	
		}
		HIGHESTSCORE = myPlayer.getHighScore(CURRENTSCORE);
	}

	public void setUpBreakable(int level){
		//adding in however many bricks wanted
		for(int i=0;i<BRICKAMOUNT;i++) {
			Brick newBrick = new Brick();
			newBrick.setStartLocation(i, BRICKAMOUNT * level);
			myBricks.add(newBrick);
			root.getChildren().add(newBrick.getView());
		}
		
		//add hard brick for every level after 1
		for(int i=1;i<level;i++) {
			addHardBrick(i);
			addPowerUp();
		}
	}

	public void addHardBrick(int level)
	{
		BlockBrick hardBrick=new BlockBrick();
		hardBrick.setStartLocation(level,BRICKAMOUNT);
		myBlocks.add(hardBrick);
		root.getChildren().add(hardBrick.getView());
	}

	public void addPowerUp()
	{
		DoublePoints powerupDP=new DoublePoints();
		powerupDP.setRandomLocation(SIZE);
		myPowerUps.add(powerupDP);
		root.getChildren().add(powerupDP.getView());
	}
 
//    private void handleMouseInput () {
//    	//root.getChildren().clear();
//		if(myBricks.isEmpty())
//		{
//			setUpBricks(level);
//		}
//    }

	public void advanceLevel(int level){
		theBall.resetBall();
		userPaddle.reset();
		setUpBreakable(level);
	}

	public void keyInput (KeyCode code) {
		if(code== KeyCode.LEFT)
		{
			userPaddle.move(-1);
		}
		else if(code== KeyCode.RIGHT)
		{
			userPaddle.move(1);
		}
	}
	
	public static void main(String[] args) {
		//System.out.println("Hello world");
		//new PlayGame().playGame();
		launch(args);
	}

}
