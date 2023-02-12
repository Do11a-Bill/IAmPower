package main;

import inputs.KeyBoardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private float myXDelta = 100, myYDelta = 100;
    private BufferedImage myImage, myDefaultImage, mySubImage;

    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        setPanelSize();

        importImage();

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void importImage() {
        InputStream  is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            myImage = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    public void changeXDelta(int xDelta) {
        this.myXDelta += xDelta;
    }

    public void changeYDelta(int yDelta) {
        this.myYDelta += yDelta;
    }

    public void setImgPos(int x, int y) {
        this.myXDelta = x;
        this.myYDelta = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //default, which is actually smaller
//        g.drawImage(myImage.getSubimage(0,0, 64, 40), 0, 0, null);

        //resizing and makeing the image bigger
        myDefaultImage = myImage.getSubimage(0,0, 64, 40);
        g.drawImage(myDefaultImage, 0, 0, 128, 80, null);

        //getting a different image
        mySubImage = myImage.getSubimage(1*64,8*40, 64, 40);
        g.drawImage(mySubImage, (int) myXDelta, (int) myYDelta, 128, 80, null);

    }
}
