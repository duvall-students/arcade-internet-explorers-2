package galaga;

import java.util.ArrayList;
import java.util.List;

import breakout.BlockBrick;
import breakout.Brick;
import breakout.DoublePoints;
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
		private static final String TITLE = "Galaga";
		private int ENEMYAMOUNT=6;
		private int LASERAMOUNT=100;
		
		//instance variables
		private Player myPlayer=new Player();
		private Spaceship mySpaceship=new Spaceship();
		private Laser myLaser=new Laser();
		
		
		
		
		public List<String> allMySayings=new ArrayList<>();
		private List<Enemy> myEnemies= new ArrayList<>();
		private List<Laser> myLasers= new ArrayList<>();
		
		public void objectsInScene() {
			myObjects.add(mySpaceship);

			
			
		}
		
		
		// Change properties of shapes in small ways to animate them over time
	    public void step (double elapsedTime) {
	        // updated the lasers
			for(Laser thisLaser : myLasers) {
				thisLaser.move(elapsedTime);
			}
			for(Enemy thisEnemy : myEnemies) {
				thisEnemy.move(elapsedTime);
				//check to see if enemy has gotten to the bottom
				if (thisEnemy.escapes(SIZE)) {
					myEnemies.remove(thisEnemy);
					root.getChildren().remove(thisEnemy.getView());
					myPlayer.loseLife();
					PLAYERLIVES=myPlayer.getLifeAmount();
					Text text=new Text();
					String welcome="Lives Left: "+PLAYERLIVES;
					text.setText(welcome);
					text.setX(10);
					text.setY(390);
					root.getChildren().set(0, text);
				}
			}
	        // check for collision
			for (Laser thisLaser : myLasers) {
				for (Enemy thisEnemy : myEnemies) {
					if (thisLaser.getView().getBoundsInParent().intersects(thisEnemy.getView().getBoundsInParent())) {
						enemyCollision(thisEnemy,thisLaser);
					}
				}
			}

		} 
	    
		private void enemyCollision(Enemy enemy, Laser laser) {
			enemy.beenHit();

			if(enemy.getAmountToBreak()==0)
			{
				//this works but errors pop up and i am not sure why
				myEnemies.remove(enemy);
				root.getChildren().remove(enemy.getView());

				//add to points
				int enemyValue=enemy.getPointValue();
				myPlayer.increaseCurrentScore(enemyValue);
				CURRENTSCORE=myPlayer.getCurrentScore();	
			}
			HIGHESTSCORE = myPlayer.getHighScore(CURRENTSCORE);
			root.getChildren().remove(laser.getView());
			myLasers.remove(laser);
		}
	    
		public void advanceLevel(int level){
			mySpaceship.reset();
			setUpBreakable(level);
		}

		
		public void setUpBreakable(int level){
			//adding in however many enemies wanted
			for(int i=0;i<ENEMYAMOUNT;i++) {
				Enemy newEnemy = new Enemy();
				newEnemy.setStartLocation(i, ENEMYAMOUNT * level);
				myEnemies.add(newEnemy);
				root.getChildren().add(newEnemy.getView());
			}
		}
		
		public void shootLaser() {
			Laser newLaser=new Laser();
			newLaser.setStartLocation(mySpaceship.getX()-10, mySpaceship.getY());
			newLaser.shoot();
			myLasers.add(newLaser);
			root.getChildren().add(newLaser.getView());
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
			else if (code== KeyCode.SPACE) {
				//need a shooting code for laser
				shootLaser();
			
			}
		}
		
		public static void main(String[] args) {
			launch(args);
		}


}
