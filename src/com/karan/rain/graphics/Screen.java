package com.karan.rain.graphics;

/**
 * Created by user on 24/11/2015.
 */
public class Screen {
    private int width,height;

    public int[] pixels;

    public Screen(int width,int height)
    {
        this.width =width;
        this.height = height;
        pixels =new int[width*height];
    }
}
