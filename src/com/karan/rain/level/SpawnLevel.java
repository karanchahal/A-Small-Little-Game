package com.karan.rain.level;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.entity.mob.Dummy;
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
        add(new Dummy(20,35));

    }

    //Grass = 0x00FF21
    //Flower = 0xFFD800
    //Rock = 0x7F3300
    protected void generateLevel() {



    }




}
