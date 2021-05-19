package firstjavagame;

import java.awt.Canvas;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

    @SuppressWarnings("compatibility:7629012207966341723")
    private static final long serialVersionUID = 1L;
    
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.setVisible(true);
        game.start(); /*This is a function inside of Game Class*/
    }
}
