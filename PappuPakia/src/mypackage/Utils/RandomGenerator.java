package mypackage.Utils;

import java.util.Random;

public class RandomGenerator {

    private   Random mRandom;
    public  int mRandomX;
    public  int mRandomY;
    public  int mRandomflyX;

    public RandomGenerator(){
        mRandom = new Random();
    }

    // getter method to get random x coordinates for power items
    public int getmRandomX() {
        mRandomX = 2000+(mRandom.nextInt(5)+2)*200;
        return mRandomX;
    }

    public int getmRandomY() {
        mRandomY = 100+(mRandom.nextInt(3))*150;
        return mRandomY;
    }

    // getter method to get random x coordinates for flying birds
    public int getmRandomFlyX() {
        mRandomflyX = 2000+(mRandom.nextInt(5)+2)*250;
        return mRandomflyX;
    }


}
