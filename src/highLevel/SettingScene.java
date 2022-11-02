package highLevel;

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

//maddie volchko
public abstract class SettingScene extends Application implements VideoGame{
	//everything in my scene
	public Group root=new Group();
	
	//variables
	//background and scene setting variables
	public Scene myScene;
	public static final int SIZE = 400;
	public static final Paint BACKGROUND = Color.AZURE;
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	public static String TITLE;
	public int VARIABLEX=10;
	public int VARIABLEY=390;
	public int level=1;
	
	//Specifics
	public Player myPlayer=new Player();
	public int PLAYERLIVES=3;
	public int currentScore =0;
	public int highestScore =0;
	
	//lists
	public List<String> allMySayings=new ArrayList<>();
	public List<Objects> myObjects=new ArrayList<>();
	
	@Override
	public void start(Stage stage) {
		//attach scene to stage and display it
		myScene=setUp(SIZE,SIZE,BACKGROUND);
		stage.setScene(myScene);
        stage.setTitle(TITLE);
        stage.show();
        
        //attach game loop
        
        myScene.setOnKeyPressed(e -> keyInput(e.getCode()));
        KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY));
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
        
	}
	
	public Scene setUp(int width, int height, Paint background) {
		//create all my sayings and add them to the list
    	allMySayings.add("Lives Left: "+PLAYERLIVES);
    	allMySayings.add("Current Points: "+ currentScore);
    	allMySayings.add("Highest Score: "+ myPlayer.getHighScore(currentScore));
    	
    	//run through all the strings and add them
    	for (String screenText : allMySayings) {
    		Text text=new Text();
    		text.setText(screenText);
    		text.setX(VARIABLEX);
    		text.setY(VARIABLEY);
    		root.getChildren().add(text);
    		VARIABLEY=VARIABLEY-20;
    	}
    	VARIABLEY=390;
    	
    	objectsInScene();
    	for (Objects object : myObjects) {
    		root.getChildren().add(object.getView());
    	}
    	
    	//adding in however many enemies wanted
		for(int i=0;i<level;i++){
			setUpBreakable(i);
		}
		
		//creating a scene with the information
		Scene scene = new Scene(root, width, height, background);
		scene.setOnKeyPressed(e -> keyInput(e.getCode()));
		return scene;
	}
	
	public abstract void objectsInScene();
	public abstract void step(double elapsedTime);
	public abstract void setUpBreakable(int level);
	public abstract void keyInput(KeyCode code);


}
