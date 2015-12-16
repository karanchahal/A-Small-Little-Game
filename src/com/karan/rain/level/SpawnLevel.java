package com.karan.rain.level;

import com.karan.rain.graphics.Screen;
import com.karan.rain.level.tile.Tile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Lenovo on 12/14/2015.
 */
public class SpawnLevel extends Level {

    //the are (safe place to go into different worlds)

    private Tile[] tiles;
    public int[] levelPixels;

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new Tile[w*h];
            levelPixels = new int[w*h];
            image.getRGB(0,0,w,h,levelPixels,0,w);


        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception ! Could not load level file");
        }
    }

    //Grass = 0x00FF21
    //Flower = 0xFFD800
    //Rock = 0x7F3300
    protected void generateLevel() {

        for(int i = 0;i < tiles.length;i++) {

             if(levelPixels[i] == 0xFF00FF21) {
                tiles[i] = Tile.grass;
            }
            else
            if(levelPixels[i] == 0xFFFFD800) {
                tiles[i] = Tile.flower;
            }
            else
            if(levelPixels[i] == 0xFF7F3300) {
                tiles[i] = Tile.rock;
            }
            else
                tiles[i] = Tile.voidTile;

        }

    }


    public void render(int xScroll,int yScroll,Screen screen) {

        screen.setOffset(xScroll,yScroll);

        //SPECIFIES WHAT TILES WE NEED TO COLLECT
        //CORNER PINS(WHAT AREA OF THE MAP WE WANT TO RENDER)

        /* xScroll and yScroll indicates where the user's scroll or cursor is at some point*/
        int x0 = xScroll >> 4; //shifted right by 4 to mean divided by 16
        //Jumping to tile precision from pixel precision
        int x1 = (xScroll + screen.width + 16) >> 4; //end render region x point
        int y0 = yScroll >> 4;//bottom y asymtote
        int y1 = (yScroll + screen.height +16)>> 4; // end render y region y position

        for(int y = y0;y < y1;y++) {
            for(int x = x0;x < x1;x++) {
                //getTile(x,y).render(x,y,screen);
                if(x + y*16 < 0 || x+y*16 >= 256) {
                    Tile.voidTile.render(x,y,screen);
                    continue;
                }

                Tile i = tiles[x + y*16];
                i.render(x,y,screen);


            }
        }



    }


}
