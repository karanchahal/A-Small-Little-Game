package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Screen;
import com.karan.rain.input.Keyboard;

/**
 * Created by Lenovo on 12/10/2015.
 */
public class Player extends Mob{

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x,int y,Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    public void update() {
     //we want the player to move when we press keyboard button

       int xa =0,ya =0;

        if(input.up) ya-=5;
        if(input.down) ya+=5;
        if(input.left) xa-=5;
        if(input.right) xa+=5;

        if(xa != 0 || ya != 0) move(xa,ya);

    }

    public void render(Screen screen) {


        screen.renderPlayer(x - 16,y -16,sprite.player);

    }

}
