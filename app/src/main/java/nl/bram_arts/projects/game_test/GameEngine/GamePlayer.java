package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;

/**
 * Class for the Player
 * Created by bram on 19-6-2015.
 */
public class GamePlayer extends MovableGameObject {

    /**
     * basic constructor for super View.
     * @param context on which the game is drawn
     */
    public GamePlayer(Context context) {
        super(context);
    }

    /**
     * constructor for the Player used to initialize the player.
     * @param context Context on which the  game is drawn on
     * @param sprite sprite for the player (can contains frames).
     * @param position start position of the Player.
     */
    public GamePlayer(Context context, Sprite sprite, Vector position) {
        super(context, sprite, position);
    }


}
