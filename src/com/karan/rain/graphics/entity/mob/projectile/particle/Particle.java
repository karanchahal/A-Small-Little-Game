package com.karan.rain.graphics.entity.mob.projectile.particle;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 1/14/2016.
 */
public class Particle extends Entity{

    private Sprite sprite;

    private int life;

    protected double xx,yy,xa,ya;

    public Particle(int x,int y,int life) {
        sprite = Sprite.particle_normal;
        this.x = x;
        this.y = y;

        this.xx = x;
        this.yy = y;

        this.life = life;

        this.xa = random.nextGaussian(); // b/w -1 and 1 will give you a normal distribution more likely to be near 0 than 1 and -1
        this.ya = random.nextGaussian();
    }

    public Particle(int x,int y,int life,int amount) {

        this(x,y,life); // calling other constructor




    }

    public void update() {
        this.xx += xa;
        this.yy += ya;
    }

    public void render(Screen screen) {
        screen.renderSprite((int)xx,(int)yy,sprite,true);
    }


}
