package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by user on 05/12/2015.
 */
public class VoidTile extends Tile {

    public VoidTile(Sprite sprite) {
        super(sprite);
    }


    public void render(int x,int y,Screen screen) {
        // Do render stuff here !
        /*
        What are x and y ,they are in pixel format
        they have to calculated into tile positions
         */
        screen.renderTile(x << 4, y << 4 , this);

    }
}
