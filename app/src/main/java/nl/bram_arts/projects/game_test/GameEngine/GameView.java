package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;
/**
 * Main Game engine class (is the Engine where all other classes are used.
 * Created by bram on 18-6-2015.
 */
public class GameView extends View implements Runnable {

    /**
     * Maximum frames per seconds
     */
    private static int MAX_FPS = 30;
    /**
     * Milliseconds used per frame.
     */
    static final int MS_PER_FRAME = 1000 / MAX_FPS;
    /**
     * List of all gameObjects in game.
     */
    protected ArrayList<GameObject> gameObjects = new ArrayList<>();
    /**
     * Thread where the game is running on.
     */
    private Thread gameLoop;
    /**
     * Status of the game.
     */
    private boolean gameIsRunning = false;
    /**
     * context on which the game is drawning on.
     */
    private Context context;
    /**
     * Holds a player (one player per game).
     */
    private GamePlayer player;
    /**
     * Screen where the tiles are drawn on.
     */
    protected Window windowScreen;

    /**
     * constructor for the Game Engine.
     * @param context context where the game is drawn on.
     */
    public GameView(Context context) {
        super(context);
        this.context = context;
        windowScreen = new Window(context);
    }

    /**
     * Function to start the game.
     * Make a new Thread and set the status of the game to running.
     * Then start the Thread
     */
    public void startGame() {
        gameLoop = new Thread(this);
        gameIsRunning = true;
        gameLoop.start();
    }

    /**
     * Function to stop the game.
     */
    public void stopGame() {
        gameIsRunning = false;
        gameLoop = null;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(windowScreen.getMap() != null) {
            windowScreen.draw(canvas);
        }
        drawGameObjects(canvas);
    }

    /**
     * Function to draw the current state of each game object.
     * @param canvas
     */
    private void drawGameObjects(Canvas canvas) {
        for(GameObject item: gameObjects) {
            if (item.getSprite().isHasFrames()) {
                item.getSprite().nextFrame();
            }
            item.draw(canvas);
        }
    }

    /**
     * There can only be one player at a time.
     * @param sprite the sprite for the player
     * @param position of the player (where it starts).
     */
    public void setPlayer(Sprite sprite, Vector position) {
        player = new GamePlayer(context, sprite, position);
    }

    /**
     * Used by the Thread.
     * invalidate all drawing and pause the game for pause between each frame correctly.
     */
    @Override
    public void run() {
        long cycleStartTime;
        long timeSinceStart;

        while(gameIsRunning && Thread.currentThread() == gameLoop) {

            cycleStartTime = System.currentTimeMillis();
                post(new Runnable() {
                    @Override
                    public void run() {
                        invalidate();
                    }
                });

            timeSinceStart = ( System.currentTimeMillis() - cycleStartTime);
            if (timeSinceStart < MS_PER_FRAME) {
                try {
                    Thread.sleep(MS_PER_FRAME - timeSinceStart);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
