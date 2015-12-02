package com.karan.rain.graphics;

import com.karan.rain.level.tile.Tile;

import java.util.Random;

/**
 * Created by user on 24/11/2015.
 */
public class Screen {
    private int width,height; // sets width and height for screen operations
    public final int MAP_SIZE = 64;
    public final int MAP_SIZE_MASK = MAP_SIZE-1;
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

    public void render(int xOffset,int yOffset) {


        for(int y=0;y<height;y++) {
            int yp =y+yOffset;
            if(yp < 0 || yp >= height) continue;
            for(int x =0;x < width; x++) {

                int xp = x+xOffset;
                if(xp < 0 || xp >= width) continue;

                pixels[xp + (yp)*width] = Sprite.grass.pixels[(x&15) + (y&15)*Sprite.grass.SIZE]; //basically get the pixel colour pertaining to the tile index

                // using just 20,30

            }
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
        for(int y =0;y < tile.sprite.SIZE;y++) {
            int ya = y+ yp;
            for(int x =0;x<tile.sprite.SIZE;x++)
            {
                int xa =x+xp;
                if(xa < 0 || xa >= width || ya <0 || ya >= width ) break; // screen width
                //here we're stopping rendering when map is out of the screen , so we don't render the WHOLE map.
                pixels[xa + ya*width] = tile.sprite.pixels[x + y*tile.sprite.SIZE]; //NOT DEALING WITH OFFSETS HERE just rendering at x and y


            }
        }
    }





















}
