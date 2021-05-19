package firstjavagame;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {

    @SuppressWarnings("compatibility:-8218418520252624046")
    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 2400, HEIGHT = WIDTH / 12*9; /*Formula for frame size*/
    

    public Game(){ /*Game constructor*/
        new Window(WIDTH, HEIGHT, "Let's Build  a Game!", this);
    }

    public synchronized void start(){
    
    }

    public void run(){

    }

    public static void main(String[] args) {
        new Game();
    }
}
