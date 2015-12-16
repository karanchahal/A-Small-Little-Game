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



    public SpawnLevel(String path) {
        super(path);
    }

    protected void loadLevel(String path) {
        try {
            BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
            int w = image.getWidth();
            int h = image.getHeight();
            tiles = new int[w*h];
            width  = image.getWidth();
            height = image.getHeight();
            image.getRGB(0,0,w,h,tiles,0,w);


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

             if(tiles[i] == 0xFF00FF21) {
                tiles[i] = 0;
                 System.out.print("hey");

             }
            else
            if(tiles[i] == 0xFFFFD800) {
                tiles[i] = 1;
            }
            else
            if(tiles[i] == 0xFF7F3300) {
                tiles[i] = 2;
            }
            //System.out.print("hey");



        }

    }




}
