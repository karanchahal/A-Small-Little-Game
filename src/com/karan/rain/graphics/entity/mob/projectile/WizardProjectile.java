package com.karan.rain.graphics.entity.mob.projectile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by Lenovo on 12/21/2015.
 */
public class WizardProjectile extends Projectile {
    public WizardProjectile(int x, int y, double dir) {
        super(x, y, dir);
        range = 200;
        damage = 20;
        speed = 4;
        rateOfFire = 15;
        sprite = Sprite.grass;
        //Vector Maths..
        nx = speed * Math.cos(angle);
        ny = speed * Math.sin(angle);

    }

    public void update() {
        move();
    }

    protected void move() {
        x += nx;
        y += ny;
    }

    public void render(Screen screen) {
        screen.renderTile(x,y,sprite);
    }
}
