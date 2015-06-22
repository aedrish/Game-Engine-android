package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Class for the Plauer
 * Created by bram on 19-6-2015.
 */
public class GamePlayer extends MovableGameObject {

    /**
     * basic constructor for super View
     * @param context
     */
    public GamePlayer(Context context) {
        super(context);
    }

    /**
     * constructor for the Player used to initialize the player.
     * @param context Context on which the  game is drawn on
     * @param sprite sprite for the player (can containt frames).
     * @param position start position of the Player.
     */
    public GamePlayer(Context context, Sprite sprite, Vector position) {
        super(context, sprite, position);
    }


}
