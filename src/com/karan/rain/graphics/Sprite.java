package com.karan.rain.graphics;

/**
 * Created by user on 01/12/2015.
 */
public class Sprite {

    public final int SIZE;
    private int x,y;
    public int[] pixels;
    private SpriteSheet sheet;

    /* In this class we basically take out individual sprites from the big Sprite Sheet
     Just to clarify the sprite Sheet we're using here is 16 by 16 SPRITES where each sprite is 16 by 16 PIXELS.
    */

    // Here is a SAMPLE Sprite Object
    public static Sprite grass = new Sprite(16,0,0,SpriteSheet.tiles);



    public Sprite(int size,int x,int y,SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x =x * size;   // find starting point of out sprite and each sprite is made of 16 by 16 pixels/grid therefore we take x as x into 16

        this.y =y * size;   // similiarly for y

        this.sheet = sheet;

        load();
    }

    private void load() {
        for(int y=0;y<SIZE;y++) {
            for(int x =0;x<SIZE;x++) {
                pixels[x + y*SIZE]  = sheet.pixels[(x + this.x) + (y+ this.y)*sheet.SIZE]; //  here we are accessing the small sprite (16 by 16)  here from big sprite sheet
            }
        }
    }
}
