package com.karan.rain.graphics.entity.mob;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by Lenovo on 1/22/2016.
 */
public class Dummy extends Mob {

    private enum Direction{
        UP,DOWN,LEFT,RIGHT
    }
    Direction dir = Direction.DOWN;
    public boolean walking = false;
    private int count = 0;

    public Dummy(int x, int y) {
        this.x = x << 4;
        this.y = y << 4;
        this.sprite = Sprite.player_forward;
    }


    public void update() {
        count++;
        if(count > 15) {

            int xa = 0, ya = 0;
            getDirection();
            if (dir == Direction.UP) {
                ya -= 5;
                sprite = Sprite.player_forward;
            }
            if (dir == Direction.DOWN) {
                sprite = Sprite.player_back;
                ya += 5;
            }
            if (dir == Direction.LEFT) {
                sprite = Sprite.player_side;
                xa -= 5;
            }
            if (dir == Direction.RIGHT) {
                sprite = Sprite.player_side_2;
                xa += 5;
            }

            move(xa, ya);
            count = 0;
        }




    }

    private void getDirection() {
        int movement = random.nextInt(4);
        if(movement == 0) {
            dir = Direction.UP;
        } else if(movement == 1) {
            dir = Direction.DOWN;
        } else if(movement == 2) {
            dir = Direction.LEFT;
        } else if(movement == 3) {
            dir = Direction.RIGHT;
        }
    }

    public void move(int xa,int ya) {
        System.out.println(y + ya);
        if(x + xa > 0 && x + xa < 500) {
            x += xa;
        }
        if(y + ya > 0 && y + ya < 1000) {
            y += ya;
        }


    }

    public void render(Screen screen) {

        screen.renderPlayer(x,y,sprite,0);
    }
}
