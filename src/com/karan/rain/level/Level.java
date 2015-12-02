package com.karan.rain.level;

import com.karan.rain.graphics.Screen;

/**
 * Created by user on 02/12/2015.
 *///DRY  "DONT REPEAT YOURSELF"

    //This is the template for all our levels

    //abstract class means that the class will not be changed. Good practice

public class Level {

    protected int width,height;
    protected int[] tiles; //tile ids, what index does a tile start

    public Level(int width,int height){ // generates a random level
        this.width =width;
        this.height =height;
        tiles = new int[width*height];
        generateLevel(); //generates random level a tile for every square unit
    }

    public Level(String path) { // if we want to load a level from the path
        loadLevel(path); //to read width and height of the level image in path

    }
    protected void generateLevel() {


    }

    private void loadLevel(String path) { //loads width and height

    }

    public void update() { //updates our level ,artificial intel (bots) or entities that need to be updated .Need to happen at 60 FPS

    }
    private void time() {

    }

    public void render(int xScroll,int yScroll,Screen screen) {
        /* xScroll and yScroll indicates where the user's scroll or cursor is at some point*/




    }
}
