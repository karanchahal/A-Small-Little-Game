package com.karan.rain.graphics.entity.mob.projectile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.spawner.ParticleSpawner;
import com.karan.rain.graphics.entity.spawner.Spawner;
import com.karan.rain.graphics.entity.mob.projectile.particle.Particle;

/**
 * Created by Lenovo on 12/21/2015.
 */
public class WizardProjectile extends Projectile {

    public static final int FIRE_RATE = 5;

    public WizardProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = random.nextInt(40) + 80;
        damage = 20;
        speed = 5;

        sprite = Sprite.projectile_wizard;
        sprite = Sprite.projectile_wizard;
        //Vector Maths..
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);

    }

    public void update() {


        if(level.tileCollision((int)(x + nx),(int)(y+ny),7,5,4)) {

            level.add(new ParticleSpawner((int)x,(int)y,20,20,level,Sprite.particle_normal));
            remove();
        }
        move();

    }



    protected void move() {

        x += nx;
        y += ny;
        if (distance() > range) {
            remove();
        }
    }

    public int distance() {
        double dist = 0;
        dist = Math.sqrt((xOrigin - x)*(xOrigin - x) + (yOrigin - y)*(yOrigin - y));
        return (int)dist;
    }

    public void render(Screen screen) {
        screen.renderProjectile((int)x-12,(int)y-2,sprite);
    }
}
