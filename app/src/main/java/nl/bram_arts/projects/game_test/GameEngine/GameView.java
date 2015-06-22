package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;
/**
 * Created by bram on 18-6-2015.
 */
public class GameView extends View implements Runnable {

    private static int fps = 30;
    static final int MS_PER_FRAME = 1000 / fps;
    protected ArrayList<GameObject> gameObjects = new ArrayList<>();
    private Thread gameLoop;
    private boolean gameIsRunning = false;
    private Context context;
    private GamePlayer player;
    protected Window windowScreen;

    public GameView(Context context) {
        super(context);
        this.context = context;
        windowScreen = new Window(context);
    }

    public void startGame() {

        gameLoop = new Thread(this);
        gameIsRunning = true;
        gameLoop.start();
    }

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
     * @param position
     */
    public void setPlayer(Sprite sprite, Vector position) {
        player = new GamePlayer(context, sprite, position);
    }

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
