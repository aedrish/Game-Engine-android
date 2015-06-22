package nl.bram_arts.projects.game_test;

import android.content.Context;
import android.graphics.Canvas;

import nl.bram_arts.projects.game_test.GameEngine.MovableGameObject;
import nl.bram_arts.projects.game_test.GameEngine.Sprite;
import nl.bram_arts.projects.game_test.GameEngine.Vector;

/**
 * Class for a ball object.
 * Created by bram on 29-5-2015.
 */
public class Ball extends MovableGameObject {

    /**
     * The position of the ball.
     */
    private Vector position;
    /**
     * the radius of the ball is.
     */
    private int radius;
    /**
     * Angle of the ball in degrees.
     */
    private int direction;
    /**
     * x and y speed of the Ball.
     */
    private int speedX, speedY;

    public Ball(Context context) {
        super(context);
    }

    /**
     * The constructor for the ball.
     * @param context the context in which the ball is drawn
     * @param sprite the sprite belong to the ball.
     * @param position Vector position of the ball.
     * @param direction start angle of the ball.
     */
    public Ball(Context context, Sprite sprite, Vector position, int direction) {
        super(context, sprite, position);
        this.position = position;
        this.direction = direction;
        this.radius = sprite.getBmp().getWidth();
        calculateXYSpeed();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        move(canvas);
    }

    /**
     * Function to calculate the x and y speed based on the balls speed and angle.
     */
    private void calculateXYSpeed() {
        int ballSpeed = 5;
        double dx = (Math.cos(direction) * ballSpeed);
        speedX = (int) dx;
        double dy = (Math.sin(direction) * ballSpeed);
        speedY += (int) dy;
    }


    /**
     * function to move the ball every frame.
     * @param canvas the canvas used for getting the end of the screen.
     */
    private void move(Canvas canvas) {
        //TODO: implement viewPort and no longer need canvas (ball can get outside screen).
        position.setX(position.getX() + speedX);
        position.setY(position.getY() + speedY);

        System.out.println("speedX: " + speedX + " speedY: " + speedY);

        if (position.getX() < 0) {
            speedX = -speedX;
            position.setX(0);
        } else if (position.getX() + radius > canvas.getWidth()) {
            speedX = -speedX;
            position.setX(canvas.getWidth() - radius);
        }

        if (position.getY() < 0) {
            speedY = -speedY;
            position.setY(0);
        } else if (position.getY() + radius > canvas.getHeight()) {
            speedY = -speedY;
            position.setY(canvas.getHeight() - radius);
        }
    }

}
