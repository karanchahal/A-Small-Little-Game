package com.karan.rain.level.tile;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.Sprite;
import com.karan.rain.level.tile.spawn_level.*;

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
    boolean water = false;

    //EACH TILE SHOULD HAVE A SPRITE
    public static Tile grass = new GrassTile(Sprite.grass);
    public static Tile flower = new FlowerTile(Sprite.flower);
    public static Tile rock = new RockTile(Sprite.rock);
    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    // Spawn Level Tiles
    public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
    public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
    public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
    public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
    public static Tile spawn_wall1 = new SpawnWall(Sprite.spawn_wall1);
    public static Tile spawn_wall2 = new SpawnWall(Sprite.spawn_wall2);


    public static final int col_spawn_grass =  0xff00FF21;
    public static final int col_spawn_hedge =  0xff; // unused
    public static final int col_spawn_water =  0xff4E44FF;
    public static final int col_spawn_wall1 =  0xffFF00DC;
    public static final int col_spawn_wall2 =  0xff; // unused
    public static final int col_spawn_floor =  0xff7F0000;

    public Tile(Sprite sprite) { //not a default constructor
        this.sprite =sprite;
    }


    public void render(int x,int y,Screen screen) {

    }

    public boolean solid() {
        return false; // return false by deafault .Now deafult tile you can pass through
    }

    public boolean isWater() {
        return false;
    }

}
