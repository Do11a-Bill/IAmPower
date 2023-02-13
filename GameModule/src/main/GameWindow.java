package main;

import javax.swing.*;

public class GameWindow {

    /**
     * The border of our panel/screen
     */
    private JFrame jFrame;

    /**
     * Constructing our frame.
     *
     * @param gamePanel the Panel that will be put inside our window.
     */
    public GameWindow(GamePanel gamePanel) { //image putting an image inside a frame.

        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null); // spawn the window in the center of screen
        jFrame.setResizable(false);
        jFrame.pack(); //will look into GamePanel, specifically at setPanelSize();
        jFrame.setVisible(true);
    }
}
