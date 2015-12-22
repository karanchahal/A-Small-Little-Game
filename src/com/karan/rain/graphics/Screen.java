package com.karan.rain.graphics;

import com.karan.rain.graphics.entity.mob.Player;
import com.karan.rain.level.tile.Tile;

import java.util.Random;

/**
 * Created by user on 24/11/2015.
 */
public class Screen {
    public int width,height; // sets width and height for screen operations
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE-1;

    public int xOffset,yOffset;

    public int[] tiles = new int[MAP_SIZE*MAP_SIZE]; // sets tiles to display the games 64 by 64 in size
    public int[] pixels; // final pixel data

    private Random random= new Random(); // generate a random colour

    public Screen(int width,int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width*height];

        for(int i=0;i<MAP_SIZE*MAP_SIZE;i++) {
            tiles[i] = random.nextInt(0xff00ff); // gets a random colour for each tile
        }

    }



    public void clear() {
        for(int i=0;i<pixels.length;i++) {
            pixels[i] = 0;
        }
    }




    //remaking the RENDER METHOD
    /*
    * Dealing with offsets
    * if player moves right then screen offsets to the left
    * so we need to figure shit out
    * Absolute values and Relative Values for Tiles
    *    Absolute values : Is with respect to entire screen
    *    Relative Values: Is with respect to other tiles
    *
    * */


    public void renderTile(int xp,int yp,Tile tile) {

        xp -= xOffset;
        yp -= yOffset;

        for(int y =0;y < tile.sprite.SIZE;y++) {
            int ya = y+ yp; //position of the tile .
            for(int x =0;x<tile.sprite.SIZE;x++)
            {
                int xa =x+xp;
                if(xa < -tile.sprite.SIZE || xa >= width || ya <0 || ya >= height ) break; // screen width
                //here we're stopping rendering when map is out of the screen , so we don't render the WHOLE map.
                if(xa < 0 ) xa = 0;
                pixels[xa + ya*width] = tile.sprite.pixels[x + y*tile.sprite.SIZE]; //NOT DEALING WITH OFFSETS HERE just rendering at x and y


            }
        }
    }

    public void renderTile(int xp,int yp,Sprite sprite) {

        xp -= xOffset;
        yp -= yOffset;

        for(int y =0;y < sprite.SIZE;y++) {
            int ya = y+ yp; //position of the tile .
            for(int x =0;x<sprite.SIZE;x++)
            {
                int xa =x+xp;
                if(xa < -sprite.SIZE || xa >= width || ya <0 || ya >= height ) break; // screen width
                //here we're stopping rendering when map is out of the screen , so we don't render the WHOLE map.
                if(xa < 0 ) xa = 0;
                pixels[xa + ya*width] = sprite.pixels[x + y*sprite.SIZE]; //NOT DEALING WITH OFFSETS HERE just rendering at x and y


            }
        }
    }

    public void renderPlayer(int xp,int yp,Sprite sprite,int flip)
    {
        xp -= xOffset;
        yp -= yOffset;

        for(int y =0;y <sprite.SIZE;y++) {
            int ya = y+ yp; //position of the tile .
            int ys = y;
            if(flip == 2 || flip == 3) {
                ys = 31 - y;
            }
            for(int x =0;x<sprite.SIZE;x++)
            {
                int xa =x+xp;
                int xs = x;

                if(flip == 1 || flip == 3) {
                    xs = 31 - x;
                }

                if(xa < -sprite.SIZE || xa >= width || ya <0 || ya >= height ) break; // screen width
                //here we're stopping rendering when map is out of the screen , so we don't render the WHOLE map.
                if(xa < 0 ) xa = 0;

                int color = sprite.pixels[xs+ys*sprite.SIZE];

                if(color != 0xFFFF00FF)
                pixels[xa + ya*width] = color;

            }
        }
    }




    public void setOffset(int xOffset,int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }





















}
