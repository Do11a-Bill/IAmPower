package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;

    private float myXDelta = 100, myYDelta = 100;
    private float myXDir = 1f, myYDir = 1f;
    private int myFrames = 0;
    private long myLastCheck = 0;
    private Color myColor = new Color(150, 20, 90);
    private Random myRandom;

    //Temporary, just for effect
    private ArrayList<MyRect> myRects = new ArrayList<>();

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

    public void spawnRect(int x, int y) {
        myRects.add(new MyRect(x, y));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Temp Rects
        for (MyRect rect : myRects) {
            rect.updateRect();
            rect.draw(g);
        }

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

    public class MyRect {
        int x, y, w, h;
        int xDir = 1, yDir = 1;
        Color color;

        public MyRect(int x, int y) {
            this.x = x;
            this.y = y;
            w = myRandom.nextInt(50);
            h = w;
            color = newColor();
        }

        private void updateRect() {
            this.x += xDir;
            this.y += xDir;

            if ((x + w) > 400 || x < 0) {
                xDir += -1;
                color = newColor();
            }

            if ((y + h) > 400 || y < 0) {
                yDir += -1;
                color = newColor();
            }
        }

        private Color newColor() {
            return new Color(myRandom.nextInt(255), myRandom.nextInt(255), myRandom.nextInt(255));
        }

        public void draw(Graphics g) {
            g.setColor(color);
            g.fillRect(x, y, w, h);
        }

    }
}
