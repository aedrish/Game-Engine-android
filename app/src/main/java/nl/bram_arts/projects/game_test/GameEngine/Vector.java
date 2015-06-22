package nl.bram_arts.projects.game_test.GameEngine;

/**
 * Mathematical Vector class
 * Created by bram on 21-6-2015.
 */
public class Vector {
    /**
     * X position of the Vector
     */
    private float X;
    /**
     * y position of the Vector
     */
    private float Y;

    /**
     * constructor
     * @param X position
     * @param Y position
     */
    public Vector(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    /**
     * Adds two vectors together
     * @param vA first Vector
     * @param vB second Vector
     * @return combined Vector
     */
    public Vector addVector(Vector vA, Vector vB) {
        Vector temp = null;
        temp.X = vA.X + vB.X;
        temp.Y = vA.Y + vB.Y;
        return temp;
    }

    /**
     * Subtracts two Vectors
     * @param vA first Vector
     * @param vB second Vector
     * @return subtracted Vectors
     */
    public Vector substractVector(Vector vA, Vector vB) {
        Vector temp = null;
        temp.X = vA.X - vB.X;
        temp.Y = vA.Y - vB.Y;
        return temp;
    }

    /**
     * Scales a Vector by a scale.
     * @param vA Vector to scale
     * @param scale the scale that is used to scale the Vector
     * @return scaled vector
     */
    public  Vector scaleVector(Vector vA, float scale) {
        Vector temp = null;
        temp.X = (vA.X * scale);
        temp.Y = (vA.X * scale);
        return temp;
    }

    /**
     * calculate a scale based on a Vector
     * @param vA Vector to calculate the Vector from
     * @return the scale
     */
    public float magnitudeVector(Vector vA) {
        float temp;
        temp = (float) Math.sqrt((vA.X * vA.X + vA.Y * vA.Y));
        return temp;
    }

    /**
     * Make the Vector length 1
     * @param vA Vector to normalize
     * @return normalized Vector
     */
    public Vector normalizeVector(Vector vA) {
        Vector temp = null;
        float magnitude;
        magnitude = magnitudeVector(vA);
        temp.X = vA.X / magnitude;
        temp.Y = vA.Y / magnitude;
        return temp;

    }

    /**
     * is used to calculate the angle of two vectors according to each other.
     * @param vA first Vector
     * @param vB Second Vector
     * @return a scalar.
     */
    public float dotVector(Vector vA, Vector vB) {
        float scalar;
        Vector temp = null;
        temp.X = vA.X * vB.X;
        temp.Y = vA.Y * vB.Y;
        scalar = temp.X + temp.Y;
        return scalar;
    }

    /**
     * returns the current X position
     * @return X
     */
    public float getX() {
        return X;
    }

    /**
     * sets the X position
     * @param x the new X position
     */
    public void setX(float x) {
        this.X = x;
    }

    /**
     * returns the current Y position
     * @return Y
     */
    public float getY() {
        return Y;
    }

    /**
     * Sets the Y position
     * @param y the new Y position
     */
    public void setY(float y) {
        Y = y;
    }
}
