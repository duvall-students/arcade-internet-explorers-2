package galaga;

import java.util.ArrayList;
import java.util.List;

import breakout.BlockBrick;
import breakout.Brick;
import highLevel.Breakables;
import highLevel.Player;
import highLevel.SettingScene;
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

public class PlayGalaga extends SettingScene{
	
	// Trying to commit a change
	//background and scene setting variables
		public static final String TITLE = "Galaga";
		public int ENEMYAMOUNT=4;
		private int LASERAMOUNT=6;
		
		//instance variables
		public Player myPlayer=new Player();
		private Spaceship mySpaceship=new Spaceship();
		private Laser myLaser=new Laser();
		
		
		
		
		public List<String> allMySayings=new ArrayList<>();
		public List<Enemy> myEnemies= new ArrayList<>();
		public List<Laser> myLasers= new ArrayList<>();
		
		public void objectsInScene() {
			myObjects.add(mySpaceship);
			//myObjects.add(userPaddle);
		}
		
		
		// Change properties of shapes in small ways to animate them over time
	    public void step (double elapsedTime) {
	    	
	        // updated the lasers
	    	for(Laser thisLaser : myLasers) {
	    		thisLaser.move(elapsedTime);
	    	}
			
	        // check for collision
	        // collision(1) means it hit brick, collision(0) means it hit paddle
			for (Laser thisLaser : myLasers) {
				for (Enemy thisEnemy : myEnemies) {
					if (thisLaser.getView().getBoundsInParent().intersects(thisEnemy.getView().getBoundsInParent())) {
						
					}
				}
				if ( thisLaser.getView().getBoundsInParent().intersects(brick.getView().getBoundsInParent())) {
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
//				onLevelOne=false;
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
				Laser newLaser=new Laser();
				newLaser.setStartLocation(mySpaceship.getView().getX(), mySpaceship.getView().getY());
				myLasers.add(newLaser);
				root.getChildren().add(newLaser.getView());
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}


}
