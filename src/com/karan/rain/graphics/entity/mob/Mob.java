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


    public void move() {

    }

    public void update() {

    }

    private boolean collision() {
        return false;
    }

}
