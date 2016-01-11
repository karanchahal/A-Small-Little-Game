package com.karan.rain;

import com.karan.rain.graphics.Screen;
import com.karan.rain.graphics.entity.mob.Player;
import com.karan.rain.input.Keyboard;
import com.karan.rain.input.Mouse;
import com.karan.rain.level.Level;
import com.karan.rain.level.RandomLevel;
import com.karan.rain.level.SpawnLevel;
import com.karan.rain.level.tile.TileCoordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

/**
 * Created by user on 20/11/2015.
 */
public class Game extends JFrame implements Runnable{ // runnable implements run and "this"  including Canvas means we made our class a sub-part of Canvas

    //as we extend canvas we should serialize the class
    private static final long serialVersionUID =1L;
    private Keyboard key; // adds key input object
    private static int width = 300;
    private static int height = width / 16*9;
    private static int scale = 3;
    public static String title = "Rain"; //  soft coding the title
    private Thread thread;
    private JFrame frame;
    private Level level; //inist level object
    public boolean running = false;
    private Player player;

    private Screen screen;

    // a raster is a group of pixels
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // basically an image with a buffer
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();  // converting this image object into a array of integers to  signal which pixels recieve which color!


    public Game() {

        Dimension size = new Dimension(width*scale,height*scale);
        setPreferredSize(size); // it is a method of the Canvas

        frame = this;
        screen =  new Screen(width,height);
        key = new Keyboard();

        level = Level.spawn; //instantiating random level
        TileCoordinate playerSpawn = new TileCoordinate(19,65);
        player  = new Player(playerSpawn.x(),playerSpawn.y(),key);
        player.init(level);
        frame.addKeyListener(key);
        Mouse mouse = new Mouse();
        addMouseListener(mouse);
        addMouseMotionListener(mouse);


    }

    public synchronized void start() { // synchronized used to make thread behave nice with our system
        running = true;
        thread = new Thread(this,"Display"); // new thread instantiated
        thread.start(); // starts it by running run() method as we're using the runnable interface

    }

    public synchronized void stop(){
        running = false;
        try{
            thread.join(); //stops all threads
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static int windowWidth()
    {
        return width*scale;
    }

    public static int windowHeight()
    {
        return height*scale;
    }

    public void run() {

        long lastTime = System.nanoTime(); //  gets start game time in nanoseconds
        long timer = System.currentTimeMillis();  // gets current system time
        final double ns = 1000000000.0 / 60.0; // divides 1 second or 10^9 nano seconds into  blocks of 60
        double delta = 0; // used to to run update every second
        int frames = 0;   // how much rendering is possible in 1 second frames per second
        int updates =0;   // you know this
        while(running) {



            long now = System.nanoTime(); // time at this exact moment
            delta += (now - lastTime)/ns; // now here is the core logic where it sees how many blocks of 60 does theis time fit into and if its nore than then update runs accordingly

            lastTime = now;

            while(delta >= 1){

                //rendering and updating the game
                update(); // to be handled at 60 fps per second ,only runs 60 times in one second
                updates++;
                delta--;
            }

            render(); // render as fast as the computer can how much can it render in 1 second
            frames++;

            if(System.currentTimeMillis() - timer >= 1000) { // this means that if its been one second or not then duly updates the counter
                timer+=1000;

                //System.out.println(updates + "updates, " + frames + "fps");
                frame.setTitle(title + "| ups " + updates + " and fps " + frames);

                frames = 0;
                updates =0;
            } //will happen once per second so we can display the FPS

        }
        stop();
    }


    public void update() {
        key.update();
        player.update();
        level.update();
    }


    public void render() {
        BufferStrategy bs = getBufferStrategy(); // our buffer strategy creates 3 buffers
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear(); // clear shte screen before printing new frame
        int xScroll = player.x - screen.width/2;
        int yScroll = player.y - screen.height/2;
        level.render(xScroll,yScroll,screen);
        player.render(screen);


        for(int i=0;i< pixels.length;i++) {
            pixels[i] = screen.pixels[i]; // converts screen pixel array to display pixel array
        }

        Graphics g = bs.getDrawGraphics(); // gets drawable object

        /*g.setColor(new Color(80,40,100));
        g.fillRect(0, 0, getWidth(), getHeight()); // background colour code
        */

        g.drawImage(image,0,0,getWidth(),getHeight(),null); // draws image object which is buffered image

        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana",0,50));
        //g.fillRect(Mouse.getX(),Mouse.getY(),64,64);
        //g.drawString("Button:" + Mouse.getButton(),80,80);

        g.dispose(); // clears everything

        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game(); // starting our game
        game.setResizable(false); // important causes tons of graphical errors
        game.setTitle(Game.title);
        game.pack(); // pack sets the size of the frame according to the component which we did in our constructor
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setLocationRelativeTo(null);
        game.setVisible(true);

        game.start();
    }

}









