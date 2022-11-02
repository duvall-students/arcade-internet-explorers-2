package highLevel;
//Sophie Halish

//For power-ups and bricks, since they are very similar
//For objects that can be broken/hit
public abstract class Breakables extends Hittable implements Objects {
    private int amountToBreak;

    public Breakables(String image, int points, int breakAmount) {
        super(image,points);
        amountToBreak=breakAmount;
    }
    public int getAmountToBreak() {
        return amountToBreak;
    }

    public abstract void setStartLocation(int currentBrick, int numBricks);

    public void beenHit(){
        amountToBreak--;
    }

}
