package com.karan.rain.level.tile.spawn_level;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.level.tile.Tile;

/**
 * Created by Lenovo on 12/17/2015.
 */
public class SpawnHedgeTile extends Tile {


    public SpawnHedgeTile(Sprite sprite) {
        super(sprite); // same thing as level class
    }

    public void render(int x,int y,Screen screen) {
        // Do render stuff here !
        /*
        What are x and y ,they are in tile format
        they have to calculated into pixel positions!
        so multiply by 16
         */
        screen.renderTile(x << 4,y << 4,this);

    }
}
