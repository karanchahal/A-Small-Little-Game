package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by Lenovo on 12/14/2015.
 */
public class RockTile extends Tile{


    public RockTile(Sprite sprite) {
        super(sprite);
    }

    public void render(int x, int y, Screen screen) {
        // Do render stuff here !
        /*
        What are x and y ,they are in tile format
        they have to calculated into pixel positions!
        so multiply by 16
         */
        screen.renderTile(x << 4,y << 4,this);

    }

    public boolean solid() {
        return false; // return false by deafault .Now deafult tile you can pass through
    }







}
