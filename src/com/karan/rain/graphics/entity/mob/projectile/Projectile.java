package com.karan.rain.graphics.entity.mob.projectile;

import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.Entity;

import java.util.Random;

/**
 * Created by Lenovo on 12/21/2015.
 */
public class Projectile extends Entity {

    protected final int xOrigin,yOrigin;
    protected double angle;
    protected double x,y;
    protected Sprite sprite;
    protected double distance;
    protected double nx,ny; // new x and new y will change every update
    protected double speed, rateOfFire,range,damage;

    protected final Random random = new Random();

    public Projectile(int x, int y, double dir) {
        xOrigin = x;
        yOrigin = y;
        angle = dir;
        this.x = x;
        this.y = y;
    }

    protected void move() {

    }
}
