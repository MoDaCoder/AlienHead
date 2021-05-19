package firstjavagame;

import java.awt.Canvas;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

    @SuppressWarnings("compatibility:7629012207966341723")
    private static final long serialVersionUID = 1L;
    
    public Window(int width, int height, String title, Game game /*Instance of a game in Window's construction parameters*/){
        JFrame frame = new JFrame(title);
        /*Lines 17-27 are setting up the JFrame*/
        
        /*Lines 19-21 setting the window size*/
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); /*Allows us to actually stop the thread in the games operations*/
        frame.setResizable(false); /*Allowing the ability to re-size window to false*/
        frame.setLocationRelativeTo(null); /*Sets window to start in the middle of the screen*/
        frame.add(game); /*Adding Game class to frame*/
        frame.setVisible(true); /*Setting frame to visible so we can see it*/
        game.start(); /*Running the start method on Game class*/
    }
}
