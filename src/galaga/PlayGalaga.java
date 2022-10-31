package galaga;

import java.util.ArrayList;
import java.util.List;

import breakout.Brick;
import highLevel.Player;
import highLevel.VideoGame;
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

public class PlayGalaga extends Application implements VideoGame {
	
	// Trying to commit a change
	//background and scene setting variables
		private Scene myScene;
		public static final int SIZE = 400;
		public static final Paint BACKGROUND = Color.AZURE;
		public static final int FRAMES_PER_SECOND = 60;
		public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
		public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
		public static final String TITLE = "Galaga";
		private int VARIABLEX=10;
		private int VARIABLEY=390;
		public int PLAYERLIVES=3;
		public int CURRENTSCORE=0;
		public int HIGHESTSCORE = 0;
		public int ENEMYAMOUNT=4;
		private int level=1;
		private int LASERAMOUNT=6;
		
		//instance variables
		public Player myPlayer=new Player();
		private Spaceship mySpaceship=new Spaceship();
		private Laser myLaser=new Laser();
		
		
		//everything in my scene
		private Group root=new Group();
		
		public List<String> allMySayings=new ArrayList<>();
		public List<Enemy> myEnemies= new ArrayList<>();
		public List<Laser> myLasers= new ArrayList<>();
		
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
	    		text.setX(VARIABLEX);
	    		text.setY(VARIABLEY);
	    		root.getChildren().add(text);
	    		VARIABLEY=VARIABLEY-20;
	    	}
	    	
	    	//adding in however many enemies wanted
			for(int i=0;i<level;i++){
				setUpBreakable(i);
			}
			
			//add lasers into list
			
	    	
	    	
			//creating a scene with the information
			Scene scene = new Scene(root, width, height, background);
			scene.setOnKeyPressed(e -> keyInput(e.getCode()));
			return scene;
		}
		
		public void setUpBreakable(int level){
			//adding in however many bricks wanted
			for(int i=0;i<ENEMYAMOUNT;i++) {
				Enemy newEnemy = new Enemy();
				newEnemy.setStartLocation(i, ENEMYAMOUNT * level);
				myEnemies.add(newEnemy);
				root.getChildren().add(newEnemy.getView());
			}
		}
		
		public void keyInput(KeyCode code) {
			if(code== KeyCode.LEFT)
			{
				mySpaceship.move(-1);
			}
			else if(code== KeyCode.RIGHT)
			{
				mySpaceship.move(1);
			}
			if (code== KeyCode.SPACE) {
				//need a shooting code for laser
				myLaser.shoot();
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}


}
