package com.karan.rain.graphics.entity.mob;

import com.karan.rain.Game;
import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.graphics.entity.mob.projectile.Projectile;
import com.karan.rain.graphics.entity.mob.projectile.WizardProjectile;
import com.karan.rain.input.Keyboard;
import com.karan.rain.input.Mouse;

/**
 * Created by Lenovo on 12/10/2015.
 */
public class Player extends Mob{

    private Keyboard input;
    private Sprite sprite;
    private int anime;
    private boolean walking = false;

    private int fireRate = 0;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Player(int x,int y,Keyboard input) {
        this.x = x;
        this.y = y;
        sprite = Sprite.player_forward;
        this.input = input;
        fireRate = WizardProjectile.FIRE_RATE;
    }

    public void update() {
     //we want the player to move when we press keyboard button

        if(fireRate > 0) fireRate--;

        int xa =0,ya =0;
        if(anime < 7500) anime++; else anime =0;
        if(input.up) ya-=5;
        if(input.down) ya+=5;
        if(input.left) xa-=5;
        if(input.right) xa+=5;
        if(xa != 0 || ya != 0) {
            move(xa,ya);
            walking = true;
        } else {
            walking = false;
        }

        clear();
        updateShooting();
    }

    private void clear() {
        for(int i=0;i< level.getProjectile().size();i++) {
            Projectile p = level.getProjectile().get(i);
            if(p.isRemoved()) level.getProjectile().remove(i);
        }
    }

    private void updateShooting() {

        if(Mouse.getButton() == 1 && fireRate <= 0) {
            double dx = (Mouse.getX() - (Game.windowWidth() / 2));
            double dy = (Mouse.getY() - (Game.windowHeight() / 2));
            double dir = Math.atan2(dy,dx);

            shoot(x,y,dir);

            fireRate = WizardProjectile.FIRE_RATE;
        }
    }

    public void render(Screen screen) {

        int flip = 0;

        if(dir == 0) {
            sprite = sprite.player_forward;
            if(walking) {
                if(anime %20 > 10)
                {
                    sprite = sprite.player_forward_1;
                }
                else
                {
                    sprite = sprite.player_forward_2;
                }

            }
        }
        if(dir == 1) {
            sprite = sprite.player_side;

            if(walking) {
                if(anime %20 > 10)
                {
                    sprite = sprite.player_side_1;
                }
                else
                {
                    sprite = sprite.player_side_2;
                }

            }




        }
        if(dir == 2) {
            sprite = sprite.player_side;flip = 1;

            if(walking) {
                if(anime %20 > 10)
                {
                    sprite = sprite.player_side_1;
                }
                else
                {
                    sprite = sprite.player_side_2;
                }

            }
        }
        if(dir == 3) {
            sprite = sprite.player_back;
            if(walking) {
                if (anime % 20 > 10) {
                    sprite = sprite.player_back_1;
                } else {
                    sprite = sprite.player_back_2;
                }
            }
        }


        screen.renderPlayer(x - 16,y -16,sprite,flip);


    }

}
