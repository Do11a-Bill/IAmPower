package main;

public class Game implements Runnable{

    //The frame or the borders surrounding the panel.
    private GameWindow myGameWindow;

    //What's shown or made. Imagine it like a canvas that we're painting on.
    private GamePanel myGamePanel;

    //Allows us to do multiple things at once. Like Having things run in the background,
    //Without interrupting the main program.
    private Thread myGameThread;

    //Capping the FPS at 120
    private final int FPS_SET = 120;

    //Constructor, Called in the main Class. Initializes everything we need.
    public Game() {
        myGamePanel = new GamePanel();
        myGameWindow = new GameWindow(myGamePanel);
        myGamePanel.requestFocus();
        startGameLoop();

    }

    //Initializes and starts the thread. It's what makes our game start.
    private void startGameLoop() {
        myGameThread = new Thread(this);
        myGameThread.start();
    }

    //Runs the thread. Updates everything on the screen
    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        long lastFrame = System.nanoTime();
        long now = System.nanoTime();

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
