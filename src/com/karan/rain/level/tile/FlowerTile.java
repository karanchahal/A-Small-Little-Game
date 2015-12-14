package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by Lenovo on 12/14/2015.
 */
public class FlowerTile extends Tile {
    public FlowerTile(Sprite sprite) {
        super(sprite);
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
