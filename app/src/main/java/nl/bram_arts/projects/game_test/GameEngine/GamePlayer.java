package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Created by bram on 19-6-2015.
 */
public class GamePlayer extends MovableGameObject {

    public GamePlayer(Context context) {
        super(context);
    }
    public GamePlayer(Context context, Sprite sprite, Vector position) {
        super(context, sprite, position);
    }


}
