package firstjavagame;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    @SuppressWarnings("compatibility:-8218418520252624046")/*What does lines 7-8 do?*/
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 2400, HEIGHT = WIDTH / 12*9; /*Formula for frame size*/
    
    private Thread thread; /*Entire Game will run within this thread (check here for more details: https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html)*/
    private boolean running = false;

    public Game(){ /*Game constructor*/
        new Window(WIDTH, HEIGHT, "Let's Build  a Game!", this);
    }

    public synchronized void start(){
        thread = new Thread(this); /*"this" reffering to this Game class*//*New instance of thread*/
        thread.start(); /*Starts the thread*/
        running = true;
    }
    
    public synchronized void stop(){
        try{                 /*"try" && "catch" basically if else statement*/
            thread.join();   /*Kills off the thread*/
            running = false; /*Game is not running*/
        }catch(Exception e){ 
            e.printStackTrace();/*Else throw error*/
        }
    }

    public void run(){ /*Lines 34-59 are the games loop*/
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    public static void main(String[] args) {
        new Game();
    }
}
