package com.karan.rain;

import com.karan.rain.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

/**
 * Created by user on 20/11/2015.
 */
public class Game extends Canvas implements Runnable{ // runnable implements run and "this"  including Canvas means we made our class a sub-part of Canvas

    //as we extend canvas we should serialize the class
    private static final long serialVersionUID =1L;

    public static int width = 300;
    public static int height = width / 16*9;
    public static int scale = 3;
    public static String title = "Rain";
    private Thread thread;
    private JFrame frame;
    public boolean running = false;

    private Screen screen;

    // a raster is a group of pixels
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB); // basically an image with a buffer
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();  // converting this image object into a array of integers to  signal which pixels recieve which color!


    public Game() {

        Dimension size = new Dimension(width*scale,height*scale);
        setPreferredSize(size); // it is a method of the Canvas

        frame = new JFrame();
        screen =  new Screen(width,height);

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

    public void run() {

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates =0;
        while(running) {

            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;

            while(delta >= 1){
                //rendering and updating the game
                update(); // to be handled at 60 fps per second
                updates++;
                delta--;
            }

            render(); // render as fast as the computer can
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer+=1000;

                System.out.println(updates + "updates, " + frames + "fps");
                frame.setTitle(title + " running at the blinding speed of "+ "updates " + frames + " and fps");

                frames = 0;
                updates =0;
            } //will happen once per second so we can display the FPS

        }
        stop();
    }


    public void update() {

    }
    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if(bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        screen.render();

        for(int i=0;i< pixels.length;i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();

        /*g.setColor(new Color(80,40,100));
        g.fillRect(0, 0, getWidth(), getHeight());
        */
        g.drawImage(image,0,0,getWidth(),getHeight(),null);

        g.dispose();

        bs.show();
    }

    public static void main(String[] args) {
        Game game = new Game(); // starting our game
        game.frame.setResizable(false); // important causes tons of graphical errors
        game.frame.setTitle(Game.title);
        game.frame.add(game); // We can do this is by using "implements Canvas" makes it a part of the Canvas library so we can actually add an instance/component of game in the frame
        game.frame.pack(); // pack sets the size of the frame according to the component which we did in our constructor
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

}









