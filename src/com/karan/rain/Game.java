package com.karan.rain;

import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 20/11/2015.
 */
public class Game extends Canvas implements Runnable{ // runnable implements run and "this"  including Canvas means we made our class a sub-part of Canvas

    //as we extend canvas we should serialize the class
    private static final long serialVersionUID =1L;

    public static int width = 300;
    public static int height = width / 16*9;
    public static int scale = 3;

    private Thread thread;
    private JFrame frame;
    public boolean running = false;

    public Game() {

        Dimension size = new Dimension(width*scale,height*scale);
        setPreferredSize(size); // it is a method of the Canvas

        frame = new JFrame();

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

        while(running) {
            System.out.println("Running");
            //rendering and updating the game
        }

    }

    public static void main(String[] args) {
        Game game = new Game(); // starting our game
        game.frame.setResizable(false); // important causes tons of graphical errors
        game.frame.setTitle("Rain");
        game.frame.add(game); // We can do this is by using "implements Canvas" makes it a part of the Canvas library so we can actually add an instance/component of game in the frame
        game.frame.pack(); // pack sets the size of the frame according to the component which we did in our constructor
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);

        game.start();
    }

}
