package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by bram on 19-6-2015.
 */
public class GameObject extends View {

    private Vector position;
    private Sprite sprite;
    private boolean hasFrames;

    public GameObject(Context context) {
        super(context);
    }

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


    public Vector getPosition() {
        return position;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
