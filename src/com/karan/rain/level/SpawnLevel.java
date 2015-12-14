package com.karan.rain.level;

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
    private int[] levelPixels;

    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            image.getRGB(0,0,w,h,levelPixels,0,w);


        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Exception ! Could not load level file");
        }
    }

    //Grass = 0xFF00
    //Flower = 0xFFFF00
    //Rock = 0x7F7F00
    protected void generateLevel() {

        for(int i = 0;i < levelPixels.length;i++) {
            if(levelPixels[i] == 0xff00) {
                tiles[i] = Tile.grass;
            }
            else
            if(levelPixels[i] == 0xffff00) {
                tiles[i] = Tile.flower;
            }
            else
            if(levelPixels[i] == 0x7f7f00) {
                tiles[i] = Tile.rock;
            }
        }

    }


}
