package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;


/**
 * Created by bram on 19-6-2015.
 */
public class MovableGameObject extends GameObject {

    public MovableGameObject(Context context) {
        super(context);

    }

    public MovableGameObject(Context context, Sprite sprite, Vector position) {
        super(context, sprite, position);
    }


}
