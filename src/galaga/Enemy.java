package galaga;

import highLevel.Breakables;

public class Enemy extends Breakables {

    private final int pointValue=1;
    private int amountToBreak;

    public static final String ENEMY_IMAGE="resources/";

    public Enemy(){
        super(ENEMY_IMAGE);
        amountToBreak=1;
    }

    @Override
    public int getAmountToBreak() {
        return amountToBreak;
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    public void EnemyHit()
    {
        amountToBreak--;
    }
}
