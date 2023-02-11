package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {

    private GamePanel gamePanel;
    public KeyBoardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                //up
                gamePanel.changeYDelta(-5);
                break;
            case KeyEvent.VK_A:
                 //left
                gamePanel.changeXDelta(-5);
                break;
            case KeyEvent.VK_S:
                 //down
                gamePanel.changeYDelta(5);
                break;
            case KeyEvent.VK_D:
                //right
                gamePanel.changeXDelta(5);
                break;
        }
    }
}
