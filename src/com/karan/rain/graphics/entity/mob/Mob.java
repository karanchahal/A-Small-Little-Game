package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.Entity;

/**
 * Created by Lenovo on 12/9/2015.
 */
public abstract class Mob extends Entity {

    protected Sprite sprite; // protected used to force only mOB TO USE THIS SPRIE NO ONE ELSE CAN USE IT

    protected int dir = 0; // direction of the MOB (north,south,east west)
    protected boolean moving = false;


    public void move(int xa,int ya) {
        // going to control how pixels are translated on the screen
        // the x and y int control the location of our entity on our map
        // x and  y need to change for the item to move

        if(xa > 0) dir = 1;
        if(xa < 0) dir = 2;
        if(ya > 0) dir = 3;
        if(ya < 0) dir = 0;

        if(!collision()) {
            x += xa;
            y += ya;
        }

    }

    public void update() {

    }

    private boolean collision() {
        return false;
    }

    public void render() {

    }
}
