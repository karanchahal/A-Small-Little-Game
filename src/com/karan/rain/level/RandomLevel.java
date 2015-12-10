package com.karan.rain.level;

import java.util.Random;

/**
 * Created by user on 02/12/2015.
 */

public class RandomLevel extends Level  {

    private static final Random random = new Random();


    public RandomLevel(int width, int height) {
        super(width, height); // what super does is basically adds this width and height to our level class constructor and runs it.
    }


    protected void generateLevel() {  // what protected does is give overriding capability if the method is declared from Random Level , then this function will run and not the one in level
        for(int y =0;y<height;y++) {
            for(int x =0;x < width; x++) {
                tiles[x +y*width] = random.nextInt(4); // generates number between 0 and n-1(which is 3)
            }
        }
    }

}
