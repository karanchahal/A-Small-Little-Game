package com.karan.rain.graphics.entity;

import com.karan.rain.graphics.Screen;
import com.karan.rain.level.Level;

import java.util.Random;

/**
 * Created by Lenovo on 12/9/2015.
 */
public abstract class Entity {

    public int x,y;
    private boolean removed = false;
    protected Level level;
    protected Random random = new Random();

    public void update() {

    }

    public void render(Screen screen) {

    }

    public void remove() {
        removed = true;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void init(Level level) {
        this.level = level;
    }

    public int distance() {
        return 1;
    }


}
