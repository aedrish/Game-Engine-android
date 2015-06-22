package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;

/**
 * Class for each game Object
 * Created by bram on 19-6-2015.
 */
public class GameObject extends View {

    /**
     * Position of the object
     */
    private Vector position;
    /**
     * Sprite for the Object
     */
    private Sprite sprite;
    /**
     * boolean that is set true when there are frames.
     */
    private boolean hasFrames;

    /**
     * basic constructor used by the Super View.
     * @param context
     */
    public GameObject(Context context) {
        super(context);
    }

    /**
     * Constructor used to initialize the object.
     * @param context context on which the game is drawn on.
     * @param sprite The sprite of the object.
     * @param position the start position of the object.
     */
    public GameObject(Context context, Sprite sprite, Vector position) {
        super(context);
        this.sprite = sprite;
        this.hasFrames = sprite.isHasFrames();
        this.position = position;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(hasFrames) {
            ArrayList<Bitmap> frames = sprite.getFrames();
            int currentFrame = sprite.getFrame();
            System.out.println("frames: " + frames.size() + " currentFrame: " + currentFrame);
            canvas.drawBitmap(frames.get(currentFrame), position.getX(), position.getY(), null);

        } else {
            canvas.drawBitmap(sprite.getBmp(), position.getX(),
                    position.getY(), null);
        }
    }

    /**
     * returns the position of the object
     * @return position
     */
    public Vector getPosition() {
        return position;
    }

    /**
     * sets the new position of the object.
     * @param position the new position
     */
    public void setPosition(Vector position) {
        this.position = position;
    }

    /**
     * Returns the sprite of the object.
     * @return sprite
     */
    public Sprite getSprite() {
        return sprite;
    }

    /**
     * Sets the new sprite.
     * @param sprite the new sprite
     */
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
