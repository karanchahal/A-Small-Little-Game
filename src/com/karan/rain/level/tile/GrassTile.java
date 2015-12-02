package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by user on 02/12/2015.
 */
public class GrassTile extends Tile{


    public static Tile grass = new GrassTile(Sprite.grass); // This can be done as GrassTile extends Tile
    //GrassTile actually i a part of Tile(they are made of the same material)

    public GrassTile(Sprite sprite) {
        super(sprite); // same thing as level class
    }

    public void render(int x,int y,Screen screen) {
        // Do render stuff here !
    }

}
