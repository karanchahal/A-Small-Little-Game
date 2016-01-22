package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by Lenovo on 1/22/2016.
 */
public class Dummy extends Mob {

    public Dummy(int x, int y) {
        this.x = x << 4;
        this.y = y << 4;
        this.sprite = Sprite.player_forward;
    }

    public void update() {

    }

    public void render(Screen screen) {
        screen.renderPlayer(x,y,sprite,0);
    }
}
