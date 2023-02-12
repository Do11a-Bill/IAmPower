package inputs;

import main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInputs implements MouseListener, MouseMotionListener {

    //variable that will reference our GamePanel.
    private GamePanel gamePanel;

    //Initializes our GamePanel.
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) { //What will happen when we move our mouse.
        gamePanel.setImgPos(e.getX(), e.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Mouse clicked");
//        gamePanel.spawnRect(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
