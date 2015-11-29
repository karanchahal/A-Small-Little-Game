package com.karan.rain.graphics;

import java.util.Random;

/**
 * Created by user on 24/11/2015.
 */
public class Screen {
    private int width,height; // sets width and height for screen operations
    public int[] tiles = new int[64*64]; // sets tiles to display the games 64 by 64 in size
    public int[] pixels; // final pixel data

    private Random random= new Random(); // generate a random colour

    public Screen(int width,int height)
    {
        this.width = width;
        this.height = height;
        pixels = new int[width*height];

        for(int i=0;i<64*64;i++) {
            tiles[i] = random.nextInt(0xff00ff); // gets a random colour for each tile
        }

    }



    public void clear() {
        for(int i=0;i<pixels.length;i++) {
            pixels[i] = 0;
        }
    }

    public void render() {


        for(int y=0;y<height;y++) {
            for(int x =0;x < width; x++) {

               if(y >= height || x >=width || y <0 || x < 0) break; // here we check for out of bounds baby
                int tileIndex = (x >> 2) + (y >> 2)* 64; // using bit wise operators as we need to do this calculation a lot of times
                // we get this tile index from x and y by basically dividing x and y by 2^2 which is 4 basically and getting the tile index for that x and y co
                // -ordinates

                pixels[x+y*width] = tiles[tileIndex]; //basically get the pixel colour pertaining to the tile index

                // using just 20,30

            }
        }
    }
}
