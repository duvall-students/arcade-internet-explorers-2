package highLevel;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

//maddie volchko
public interface VideoGame {
	public Scene setUp(int width, int height, Paint background);
	public void step(double elapsedTime);
	public void advanceLevel(int level);
	public void keyInput(KeyCode code);
	public void addPowerUp();
	public void setUpBreakable(int level);
	//public void handleCollision();
	

}
