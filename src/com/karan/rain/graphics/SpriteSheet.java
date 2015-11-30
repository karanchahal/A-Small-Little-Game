package com.karan.rain.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by user on 01/12/2015.
 */
public class SpriteSheet {

    private String path;
    private final int SIZE;
    public int[] pixels;


    public SpriteSheet(String path,int size) {
        this.path = path;
        SIZE = size;
        pixels = new int[SIZE*SIZE];
    }

    private void load() {
        try {
            BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = image.getWidth();
            int h  = image.getHeight();

            image.getRGB(0,0,w,h,pixels,0,w); // startx ,starty,endx,endy,where I want load rgb values ,offset and the scansize which is the WIDTH.

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
