package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;


/**
 * Class for any object that is supposed to move (else use GameObject).
 * Created by bram on 19-6-2015.
 */
public class MovableGameObject extends GameObject {

    /**
     * Constructor of a MovableGameObject (needed for super view class
     * @param context the context on which the MovableGameObject is drawn.
     */
    public MovableGameObject(Context context) {
        super(context);

    }

    /**
     * TODO: add multiple sprites for multiple animations
     * Constructor used to initialize the MovableGameObject
     * @param context the Context on which the MovableGameObject is Drawn.
     * @param sprite the sprite that is set to this GameObject
     * @param position Vector where the MovableGameObject is first set.
     */
    public MovableGameObject(Context context, Sprite sprite, Vector position) {
        super(context, sprite, position);
    }


}
