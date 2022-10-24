package highLevel;
import java.util.ArrayList;

public class Player {
	
	private ArrayList<Integer> scoreList = new ArrayList<Integer>();

    private int lifeAmount;
    final int STARTINGLIVES=3;
    private int currentScore;
    private int highScore;

    public Player()
    {
        lifeAmount=STARTINGLIVES;
        currentScore=0;
    }

    public int getLifeAmount()
    {
        return lifeAmount;
    }

    public int getCurrentScore()
    {
        return currentScore;
    }

    public void increaseCurrentScore(int increaseAmount)
    {
        currentScore+=increaseAmount;
    }

    public void loseLife()
    {
        lifeAmount--;
    }

    
    public int getHighScore(int currentScore) {
		scoreList.add(currentScore);
		for(int i = 0; i < scoreList.size(); i++) {
			if(scoreList.get(i) >= currentScore) {
				highScore = scoreList.get(i);
			}
			else {
				highScore = currentScore;
			}
		}
		return highScore;
    }

}