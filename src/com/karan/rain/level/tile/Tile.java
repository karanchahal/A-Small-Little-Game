package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;

/**
 * Created by user on 02/12/2015.
 */

/* This is a template for actual tile rendering class */
public class Tile {

    //what do we want to do?
    //each tile should have a position
    //each section of screen (16 pixels by 16 pixels as of now.)
    //each tile should have a sprite
    //is it a solid tile ,non go throughable :P

    public int x,y;
    public Sprite sprite;

    //EACH TILE SHOULD HAVE A SPRITE
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile voidTile = new VoidTile(Sprite.voidTile);

    public Tile(Sprite sprite) { //not a default constructor
        this.sprite =sprite;
    }

    public void render(int x,int y,Screen screen) {

    }

    public boolean solid() {
        return false; // return false by deafault .Now deafult tile you can pass through
    }

}
