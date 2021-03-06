package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.Entity;
import com.karan.rain.graphics.entity.mob.projectile.Projectile;
import com.karan.rain.graphics.entity.mob.projectile.WizardProjectile;
import com.karan.rain.graphics.entity.mob.projectile.particle.Particle;
import com.karan.rain.graphics.entity.spawner.ParticleSpawner;

import java.util.ArrayList;
import java.util.List;

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

        if(!collision(0,ya)) {
            y += ya;
        }

        if(!collision(xa,0)) {
            x += xa;

        }

        if(waterCollision(xa,0)) {
            level.add(new ParticleSpawner((int)x,(int)y,20,20,level,Sprite.particle_water));
        }

        if(waterCollision(0,ya)) {
            level.add(new ParticleSpawner((int)x,(int)y,20,20,level,Sprite.particle_water));
        }



    }

    public void update() {

    }

    protected void shoot(int x,int y,double direction) {
        //direction *= 180/Math.PI;
        //System.out.println("Angle: "+ direction);

        Projectile p = new WizardProjectile(x,y,direction);
        level.add(p);

    }

    private boolean collision(int xa,int ya) {
        boolean solid =  false;

        for (int i=0;i<4;i++) {
            int xt  = ((x + xa) + i%2*14 - 7)/16; // Pixel perfect collision detection
            int yt  = ((y + ya) + i/2*12 + 3)/16;;

            if(level.getTile(xt,yt).solid())
                solid = true;
        }


        return solid;
    }


    private boolean waterCollision(int xa,int ya) {
        boolean solid =  false;

        for (int i=0;i<4;i++) {
            int xt  = ((x + xa) + i%2*14 - 7)/16; // Pixel perfect collision detection
            int yt  = ((y + ya) + i/2*12 + 3)/16;;

            if(level.getTile(xt,yt).isWater())
                solid = true;
        }


        return solid;
    }


    public void render() {

    }
}
