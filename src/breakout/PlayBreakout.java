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
import highLevel.Player;
import highLevel.VideoGame;

public class PlayBreakout extends Application implements VideoGame{
	
	//background and scene setting variables
	private Scene myScene;
	public static final int SIZE = 400;
	public static final Paint BACKGROUND = Color.AZURE;
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
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
	public Player myPlayer=new Player();
	
	//lists of multiple variations
	public List<Brick> myBricks=new ArrayList<>();;
	public List<BlockBrick> myBlocks=new ArrayList<>();;
	public List<Breakables> myPowerUps=new ArrayList<>();;
	public List<String> allMySayings=new ArrayList<>();


	//everything in my scene
	private Group root=new Group();
	
	//is this needed since I only edit root here?
	public Group getRoot() {
		return root;
	}

	//same question as above
	public List<Brick> getMyBricks() {
		return myBricks;
	}


	@Override
	public void start(Stage stage) {
		//attach scene to stage and display it
		myScene=setUp(SIZE,SIZE,BACKGROUND);
		stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
        
        //attach game loop
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
	}
	
	
	public Scene setUp(int width, int height, Paint background) {
		//create all my sayings and add them to the list
    	allMySayings.add("Lives Left: "+PLAYERLIVES);
    	allMySayings.add("Current Points: "+CURRENTSCORE);
    	allMySayings.add("Highest Score: "+ myPlayer.getHighScore(CURRENTSCORE));
    	
    	//run through all the strings and add them
    	for (String screenText : allMySayings) {
    		Text text=new Text();
    		text.setText(screenText);
    		text.setX(variableX);
    		text.setY(variableY);
    		root.getChildren().add(text);
    		variableY=variableY-20;
    	}
		
		//adding the ball to the collection
		root.getChildren().add(theBall.getView());
		
		//adding the paddle to the view
		root.getChildren().add(userPaddle.getView());

		//adding in however many bricks wanted
		for(int i=0;i<level;i++){
			setUpBreakable(i);
		}
		
		
		//creating a scene with the information
		Scene scene = new Scene(root, width, height, background);
		scene.setOnKeyPressed(e -> keyInput(e.getCode()));
		return scene;
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
			userPaddle.resetPaddle();
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
		userPaddle.resetPaddle();
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