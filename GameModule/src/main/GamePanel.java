package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    private float myXDelta = 100, myYDelta = 100;
    private float myXDir = 1f, myYDir = 1f;
    private int myFrames = 0;
    private long myLastCheck = 0;
    private Color myColor = new Color(150, 20, 90);
    private Random myRandom;

    public GamePanel() {
        myRandom = new Random();
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta(int xDelta) {
        this.myXDelta += xDelta;
    }

    public void changeYDelta(int yDelta) {
        this.myYDelta += yDelta;
    }

    public void setRecPos(int x, int y) {
        this.myXDelta = x;
        this.myYDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateRectangle();
        g.setColor(myColor);     // maybe we can change the color
        g.fillRect((int) myXDelta, (int) myYDelta, 200, 50);


        myFrames++;
        if (System.currentTimeMillis() - myLastCheck >= 1000) {
            myLastCheck = System.currentTimeMillis();
            System.out.println(" FPS: " + myFrames);
            myFrames = 0;
        }
    }

    public void updateRectangle() {
        myXDelta += myXDir;
        if (myXDelta > 400 || myXDelta < 0) {
            myXDir *= -1;     // reverse the direction
            myColor = getRandomColor();
        }

        myYDelta += myYDir;
        if (myYDelta > 400 || myYDelta < 0) {
            myYDir *= -1;
            myColor = getRandomColor();
        }
    }

    private Color getRandomColor() {
        int r = myRandom.nextInt(255);
        int g = myRandom.nextInt(255);
        int b = myRandom.nextInt(255);

        return new Color(r,g,b);
    }
}
