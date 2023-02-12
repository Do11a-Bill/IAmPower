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

    //Senses our mouse and our program will do something based on what we do to the mouse.
    private MouseInputs mouseInputs;

    //Where the image is relative to our panel/screen.
    private float myXDelta = 100, myYDelta = 100;

    //Our image/images variables.
    private BufferedImage myImage, myDefaultImage, mySubImage;

    //Constructor, called in the Game class. Initializes our mouse and keyboard Inputs,
    //as well as how big our screen is, and imports our images.
    public GamePanel() {

        mouseInputs = new MouseInputs(this);
        setPanelSize();

        importImage();

        addKeyListener(new KeyBoardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    //Imports our images in the res (resources) package.
    public void importImage() {
        InputStream  is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            myImage = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Sets how big our panel or screen will be.
    public void setPanelSize() {
        Dimension size = new Dimension(1280,800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
    }

    //Mutator for our x delta. updates our x delta. Used primarily in the KeyBoard inputs
    public void changeXDelta(int xDelta) {
        this.myXDelta += xDelta;
    }

    //mutator for our y delta. updates our y delta. Used primarily in the KeyBoard inputs
    public void changeYDelta(int yDelta) {
        this.myYDelta += yDelta;
    }

    //Used primarily in the mouseInputs in input package. sets our image wherever we want.
    public void setImgPos(int x, int y) {
        this.myXDelta = x;
        this.myYDelta = y;
    }

    //What gets seen on our panel/screen. We can even update it based on our inputs.
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
