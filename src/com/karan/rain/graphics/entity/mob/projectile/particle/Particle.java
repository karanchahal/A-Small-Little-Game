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

        this.xa = random.nextGaussian(); // b/w -1 and 1 will give you a normal distribution more likely to be near 0 than 1 and -1

        this.ya = random.nextGaussian();
        this.zz = random.nextFloat() + 2.0;
    }

    public Particle(int x,int y,int life,int amount) {

        this(x,y,life); // calling other constructor




    }

    public void update() {
        time++;
        if(time > life) {
            remove();
        }
        za -= 0.1;

        if(zz < 0) {
            zz = 0;
            za *= -0.5;
            //xa *= 0.4;
            ya *= 0.4;
        }

        move((xx+xa),(yy+ya) + (zz + za));
    }

    private void move(double x, double y) {
       if(collision(x,y)){
           this.xa *= -0.5;
           this.ya *= -0.5;
           this.za *= -0.5;
       }
        this.xx += xa;
        this.yy += ya;
        this.zz += za;
    }

    public boolean collision(double x,double y) {
        boolean solid =  false;
        for (int i=0;i<4;i++) {
            double xt  = (x - i%2*16)/16; // Pixel Perfect collision detection
            double yt  = (y - i/2*16)/16;
            int ix = (int)Math.ceil(xt);
            int iy = (int)Math.ceil(yt);

            if(i%2 == 0) {
                ix = (int)Math.floor(xt);

            }
            if(i/2 == 0){
                iy = (int)Math.floor(yt);
            }


            if(level.getTile(ix,iy).solid()) {
                solid = true;
            }
        }
        return solid;
    }

    public void render(Screen screen) {
        screen.renderSprite((int)xx,(int)yy - (int)zz -2,sprite,true);
    }


}
