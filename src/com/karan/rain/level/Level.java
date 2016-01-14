package com.karan.rain.level;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.entity.Entity;
import com.karan.rain.graphics.entity.mob.projectile.Projectile;
import com.karan.rain.level.tile.GrassTile;
import com.karan.rain.level.tile.Tile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 02/12/2015.
 *///DRY  "DONT REPEAT YOURSELF"

    //This is the template for all our levels

    //abstract class means that the class will not be changed. Good practice

public class Level {


    protected int width,height;
    public int[] tiles; //tile ids, what index does a tile start
    public static Level spawn  = new SpawnLevel("/textures/levels/spawn.png");

    private List<Entity> entites = new ArrayList<Entity>();
    private List<Projectile> projectiles = new ArrayList<Projectile>();

    public Level(int width,int height){ // generates a random level
        this.width =width;
        this.height =height;
        tiles = new int[width*height];
        generateLevel(); //generates random level a tile for every square unit
    }

    public Level(String path) { // if we want to load a level from the path

        loadLevel(path); //to read width and height of the level image in path
        generateLevel(); //generates random level a tile for every square unit

    }
    protected void generateLevel() {


    }

    protected void loadLevel(String path) { //loads width and height

    }



    public void update() { //updates our level ,artificial intel (bots) or entities that need to be updated .Need to happen at 60 FPS
        for(int i=0;i < entites.size();i++) {
            entites.get(i).update();
        }

        for(int i=0;i< projectiles.size();i++) {
            projectiles.get(i).update();
            projectiles.get(i).update();
        }

    }
    private void time() {

    }

    public boolean tileCollision(double x,double y,double xa,double ya,double size) {
        boolean solid =  false;

        for (int i=0;i<4;i++) {
            int xt  = (((int)x + (int)xa) + i%2*(int)size/2 -5)/16; // Pixel perfect collision detection
            int yt  = (((int)y + (int)ya) + i/2*(int)size/2 -5)/16;;

            if(getTile(xt,yt).solid())
                solid = true;
        }
        return solid;
    }
    public List<Projectile> getProjectile() {
        return projectiles;
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

                getTile(x,y).render(x,y,screen);


            }
        }

        for(int i=0;i< entites.size();i++) {
            entites.get(i).render(screen);
        }

        for(int i=0;i< projectiles.size();i++) {
            projectiles.get(i).render(screen);
        }



    }

    public void add(Entity e) {
        entites.add(e);
    }

    public void addProjectile(Projectile p) {
        p.init(this);
        projectiles.add(p);

    }


    public Tile getTile(int x,int y) { // We need to get a tile to use for our randomly rendered level

        if(x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;

        if(tiles[x + y*width] == 0  || tiles[x + y*width] == Tile.col_spawn_grass)
        {
          return Tile.spawn_grass;

        }

        if(tiles[x + y*width] == 1 || tiles[x + y*width] == Tile.col_spawn_floor)
        {
            return Tile.spawn_floor;

        }

        if(tiles[x + y*width] == 2 || tiles[x + y*width] == Tile.col_spawn_water)
        {
            return Tile.spawn_water;

        }

        if(tiles[x + y*width] == 3 || tiles[x + y*width] == Tile.col_spawn_wall1)
        {
            return Tile.spawn_wall1;

        }

        if(tiles[x + y*width] == 4 || tiles[x + y*width] == Tile.col_spawn_wall2)
        {
            return Tile.spawn_wall2;

        }




        return Tile.voidTile;

    }

}
