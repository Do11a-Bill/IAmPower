package main;

public class Game implements Runnable{

    /**
     * Our Window, Frame, or borders surrounding the panel
     */
    private GameWindow myGameWindow;

    /**
     * Our panel; what's shown inside our GameWindow. Imagine it like a canvas we're painting on
     */
    private GamePanel myGamePanel;

    /**
     * Allows us to do multiple things at once. Like Having things run in the background,
     * without interrupting the main program.
     */
    private Thread myGameThread;

    /**
     * Capping the FPS to 120.
     */
    private final int FPS_SET = 120;

    /**
     * Initializes everything we need. Called in the main Class.
     */
    public Game() {
        myGamePanel = new GamePanel();
        myGameWindow = new GameWindow(myGamePanel);
        myGamePanel.requestFocus();
        startGameLoop();

    }

    /**
     * Initializes and starts the thread.
     */
    private void startGameLoop() {
        myGameThread = new Thread(this);
        myGameThread.start();
    }

    /**
     * Runs the thread. Updates everything on the screen.
     */
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now;

        int frames = 0;
        long lastCheck = System.currentTimeMillis();

        while(true) {
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame) {
                myGamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println(" FPS: " + frames);
                frames = 0;
            }

        }
    }
}
