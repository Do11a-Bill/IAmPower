package main;

import javax.swing.*;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {

        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null); // spawn the window in the center of screen
        jFrame.setResizable(false);
        jFrame.pack(); //will look into GamePanel, specifically at setPanelSize();
        jFrame.setVisible(true);
    }
}
