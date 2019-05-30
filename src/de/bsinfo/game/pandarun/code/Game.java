package de.bsinfo.game.pandarun.code;

import de.bsinfo.game.pandarun.display.Display;
import de.bsinfo.game.pandarun.gfx.Assets;
import de.bsinfo.game.pandarun.input.KeyManager;
import de.bsinfo.game.pandarun.state.GameState;
import de.bsinfo.game.pandarun.state.State;
import de.bsinfo.game.pandarun.state.StateHandler;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Objects;

/**
 * The game class is responsible for:
 * <li>the game loop, which is executed in a separate thread</li>
 * <li>Initialization, updating and rendering of the visual components of the program</li>
 * <li>Updating the frames in 60 fps</li>
 * <li>Starting and stopping the game</li>
 * <br>
 * The game class implements the runnable interface.
 * The class itself is then passed to the game thread.
 */

public class Game implements Runnable {

    // Constants for the game
    private static final String GAME_TITLE = "PandaRun";
    private static final int GAME_WIDTH = 650;
    private static final int GAME_HEIGHT = 325;

    private Display display;

    private boolean running = false;

    private Thread gameThread;

    private BufferStrategy bs;
    private Graphics g;

    // State handling of the game
    private StateHandler stateHandler;
    private State gameState;
    private State menuState;

    // Input
    private KeyManager keyManager;

    public Game() {
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(GAME_TITLE, GAME_WIDTH, GAME_HEIGHT);
        display.getFrame().addKeyListener(keyManager);

        // Init sprite sheets
        Assets.init();

        // Check which state is currently active and save the current state in the state manager
        stateHandler = new StateHandler();
        gameState = new GameState(this);
        StateHandler.setState(gameState);
    }

    private void update() {
        Objects.requireNonNull(StateHandler.getState());
        StateHandler.getState().update();
        //  if(State.getState() != null)

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // Clear Screen
        g.clearRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        // DRAW HERE!


        if (StateHandler.getState() != null)
            StateHandler.getState().render(g);


        // END DRAWING!

        bs.show();
        g.dispose();

    }


    @Override
    public void run() {

        init();

        // Setting how fast the fps should be for all pc types. Slow or fast pc.
        int fps = 60;
        double timePerTick = 1000000000 / fps; // Time in nano sec.
        double delta = 0;  // Amount of time we have until we have to call the update and render method again
        long now;
        long lastTime = System.nanoTime();  // Return the Time of the pc in nano sec.
        long timer = 0;
        int updates = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {

                update();
                render();
                updates++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Updates and Frames: " + updates);
                updates = 0;
                timer = 0;

            }
        }
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    /*
    All other threads attempting to enter the synchronized block are blocked
    until the gameThread inside the synchronized block exits the block.
    */
    public synchronized void start() {
        // If the game is already running then return
        if (running) {
            return;
        }
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private synchronized void stop() {
        // If the game is already running then return
        if (!running)
            return;
        running = false;
        try {
            // Waits for this gameThread to die.
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}