package main;

public class Game implements Runnable{
    private GameWindow myGameWindow;

    private GamePanel myGamePanel;
    private Thread myGameThread;
    private final int FPS_SET = 120;
    public Game() {
        myGamePanel = new GamePanel();
        myGameWindow = new GameWindow(myGamePanel);
        myGamePanel.requestFocus();
        startGameLoop();

    }

    private void startGameLoop() {
        myGameThread = new Thread(this);
        myGameThread.start();
    }
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
