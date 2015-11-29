package com.karan.rain.graphics;

import java.util.Random;

/**
 * Created by user on 24/11/2015.
 */
public class Screen {
    private int width,height;
    public int[] tiles = new int[64*64];
    public int[] pixels;

    private Random random= new Random();

    public Screen(int width,int height)
    {
        this.width =width;
        this.height = height;
        pixels =new int[width*height];

        for(int i=0;i<64*64;i++) {
            tiles[i] = random.nextInt(0xff00ff);
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

               if(y >= height || x >=width || y <0 || x < 0) break;
                int tileIndex = (x >> 2) + (y >> 2)* 64;

                pixels[x+y*width] = tiles[tileIndex];

                // using just 20,30

            }
        }
    }
}
