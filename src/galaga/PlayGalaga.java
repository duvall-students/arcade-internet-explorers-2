package galaga;

import java.util.ArrayList;
import java.util.List;

import highLevel.Player;
import highLevel.SettingScene;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;

//maddie volchko
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
				}
				
				if (!myEnemies.contains(thisEnemy)) {
					myPlayer.loseLife();
					PLAYERLIVES=myPlayer.getLifeAmount();
					Text text=new Text();
					String welcome="Lives Left: "+PLAYERLIVES;
					text.setText(welcome);
					text.setX(VARIABLEX);
					text.setY(VARIABLEY);
					root.getChildren().set(0, text);
				}
			}
	        // check for collision
			for (Laser thisLaser : myLasers) {
				for (Enemy thisEnemy : myEnemies) {
					if (thisLaser.getView().getBoundsInParent().intersects(thisEnemy.getView().getBoundsInParent())) {
						enemyCollision(thisEnemy,thisLaser);
						//print it
						Text text2=new Text();
				    	String currentPoints="Current Points: "+currentScore;
				    	text2.setText(currentPoints);
				    	text2.setX(10);
				    	text2.setY(370);
				    	root.getChildren().set(1,text2);
					}
				}
			}
	    	if (PLAYERLIVES<=0) {
	    	root.getChildren().clear();
	    	Text text=new Text();
			String welcome="You lost :(";
			text.setText(welcome);
			text.setX(200);
			text.setY(200);
			root.getChildren().add(text);
	    	}
	    	
	    	if (myEnemies.isEmpty() && PLAYERLIVES>0) {
	    		advanceLevel(level+1);
	    		level=level+1;
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
				currentScore =myPlayer.getCurrentScore();
			}
			highestScore = myPlayer.getHighScore(currentScore);
			root.getChildren().remove(laser.getView());
			myLasers.remove(laser);
		}
	    
		public void advanceLevel(int level){
			mySpaceship.reset();
			setUpBreakable(level);
		}
		
		public void addPowerUp() {
			//need to add a powerup
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
