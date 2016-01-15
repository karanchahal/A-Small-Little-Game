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
    private int time= 0;

    protected double xx,yy,zz;
    protected double xa,ya,za;

    public Particle(int x,int y,int life) {
        sprite = Sprite.particle_normal;
        this.x = x;
        this.y = y;

        this.xx = x;
        this.yy = y;

        this.life = life + random.nextInt(50) - 20;

        this.xa = random.nextGaussian() + 1.8; // b/w -1 and 1 will give you a normal distribution more likely to be near 0 than 1 and -1
        if(this.xa < 0) {
            xa = 0.1;
        }
        this.ya = random.nextGaussian();
        this.zz = random.nextFloat() + 2.0;
    }

    public Particle(int x,int y,int life,int amount) {

        this(x,y,life); // calling other constructor




    }

    public void update() {
        time++;
        System.out.println("Time: " + time);
        if(time > life) {
            remove();
        }
        za -= 0.1;

        if(zz < 0) {
            zz = 0;
            za *= -0.5;
            xa *= 0.4;
            ya *= 0.4;
        }

        this.xx += xa;
        this.yy += ya;
        this.zz += za;
    }

    public void render(Screen screen) {
        screen.renderSprite((int)xx - 12,(int)yy - (int)zz,sprite,true);
    }


}
