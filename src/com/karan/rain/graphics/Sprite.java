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
    public static Sprite grass = new Sprite(16,4,1,SpriteSheet.tiles);
    public static Sprite voidSprite = new Sprite(16,0); // sets size and colour which is black
    public static Sprite flower = new Sprite(16,1,0,SpriteSheet.tiles);
    public static Sprite rock = new Sprite(16,2,0,SpriteSheet.tiles);

    //Spawn Level Sprites here
    public static Sprite spawn_grass = new Sprite(16,0,2,SpriteSheet.spawn_level);
    public static Sprite spawn_hedge = new Sprite(16,0,0,SpriteSheet.spawn_level);
    public static Sprite spawn_water = new Sprite(16,1,0,SpriteSheet.spawn_level);
    public static Sprite spawn_wall1 = new Sprite(16,2,0,SpriteSheet.spawn_level);
    public static Sprite spawn_wall2 = new Sprite(16,0,1,SpriteSheet.spawn_level);
    public static Sprite spawn_floor = new Sprite(16,1,1,SpriteSheet.spawn_level);

    //Player Sprites here
    public static Sprite player_forward = new Sprite(32,0,5,SpriteSheet.tiles);
    public static Sprite player_back = new Sprite(32,2,5,SpriteSheet.tiles);
    public static Sprite player_side = new Sprite(32,1,5,SpriteSheet.tiles);
    public static Sprite player_forward_1  = new Sprite(32,0,6,SpriteSheet.tiles);
    public static Sprite player_forward_2  = new Sprite(32,0,7,SpriteSheet.tiles);
    public static Sprite player_back_1 = new Sprite(32,2,6,SpriteSheet.tiles);
    public static Sprite player_back_2 = new Sprite(32,2,7,SpriteSheet.tiles);
    public static Sprite player_side_1 = new Sprite(32,1,6,SpriteSheet.tiles);
    public static Sprite player_side_2 = new Sprite(32,1,7,SpriteSheet.tiles);


    public Sprite(int size,int x,int y,SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        this.x =x * size;   // find starting point of out sprite and each sprite is made of 16 by 16 pixels/grid therefore we take x as x into 16

        this.y =y * size;   // similiarly for y

        this.sheet = sheet;

        load();
    }

    public Sprite(int size,int colour) {
        SIZE = size;
        pixels = new int[SIZE*SIZE];
        setColour(colour);
    }

    private void setColour(int colour) {
        for(int i=0;i<pixels.length;i++)
        {
            pixels[i] = colour;
        }
    }


    private void load() {
        for(int y=0;y<SIZE;y++) {
            for(int x =0;x<SIZE;x++) {
                pixels[x + y*SIZE]  = sheet.pixels[(x + this.x) + (y+ this.y)*sheet.SIZE]; //  here we are accessing the small sprite (16 by 16)  here from big sprite sheet
            }
        }
    }
}
