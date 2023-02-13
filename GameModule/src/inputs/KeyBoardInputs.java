package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardInputs implements KeyListener {

    /**
     * variable that will reference our GamePanel.
     */
    private GamePanel gamePanel;

    /**
     * Initializes our GamePanel.
     *
     * @param gamePanel the GamePanel that we will pass
     */
    public KeyBoardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * What happens when we press a certain key.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                //up
                gamePanel.changeYDelta(-10);
                break;
            case KeyEvent.VK_A:
                 //left
                gamePanel.changeXDelta(-10);
                break;
            case KeyEvent.VK_S:
                 //down
                gamePanel.changeYDelta(10);
                break;
            case KeyEvent.VK_D:
                //right
                gamePanel.changeXDelta(10);
                break;
        }
    }
}
