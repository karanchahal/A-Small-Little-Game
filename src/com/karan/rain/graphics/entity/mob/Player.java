package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.input.Keyboard;

/**
 * Created by Lenovo on 12/10/2015.
 */
public class Player extends Mob{

    private Keyboard input;
    private Sprite sprite;

    public Player(Keyboard input) {
        this.input = input;
        sprite = Sprite.player_forward;
    }

    public Player(int x,int y,Keyboard input) {
        this.x = x;
        this.y = y;
        sprite = Sprite.player_forward;
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

        int flip = 0;

        if(dir == 0) sprite = sprite.player_forward;
        if(dir == 1) sprite = sprite.player_side;
        if(dir == 2) {sprite = sprite.player_side;flip = 1;}
        if(dir == 3) sprite = sprite.player_back;


        screen.renderPlayer(x - 16,y -16,sprite,flip);

    }

}
