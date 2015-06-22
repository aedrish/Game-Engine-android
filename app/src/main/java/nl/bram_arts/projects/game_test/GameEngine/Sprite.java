package nl.bram_arts.projects.game_test.GameEngine;

import android.graphics.Bitmap;

import java.util.ArrayList;

/**
 * Sprite class that contain the sprite.
 * Created by bram on 19-6-2015.
 */
public class Sprite {
    /**
     * List of frames. Used for animation
     */
    private ArrayList<Bitmap> frames = new ArrayList<>();
    /**
     * boolean that is set true when there are frames.
     */
    private boolean hasFrames = false;
    /**
     * The bitmap (can be a single image or a set of images).
     */
    private Bitmap bmp;
    /**
     * width of one frame
     */
    private int frameWidth;
    /**
     * height of one frame
     */
    private int frameHeight;
    /**
     * Current frame in the loop
     */
    private int currentFrame;
    /**
     * Total frames for the animation.
     */
    private int numberOfFrames;

    public Sprite(Bitmap bmp) {
        this.bmp = bmp;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setBmp(Bitmap bmp) {
        this.bmp = bmp;
    }

    /**
     * Initialize the frames based on the bitmap and number of rows and colums.
     * @param colums
     * @param rows
     */
    public void setFrames(int rows, int colums) {
        if(this.bmp != null) {
            this.frameWidth = this.bmp.getWidth() / colums;
            this.frameHeight = this.bmp.getHeight() / rows;
            numberOfFrames = colums * rows;
            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < colums; x++) {
                    Bitmap frame = Bitmap.createBitmap(this.bmp, x * frameWidth, y * frameHeight, frameWidth, frameHeight);
                    frames.add(frame);
                }
            }
            hasFrames = true;
        }
    }

    /**
     * returns the frames
     * @return frames
     */
    public ArrayList<Bitmap> getFrames() {
        return this.frames;
    }

    /**
     * select next frame in the list of frames
     */
    public void animate() {
        nextFrame();
    }

    /**
     * Selects the next frame in the frame sequence for drawing.
     * The frame list is considered to be circular, i.e. if nextFrame() is called at the
     * end of the list, this method will advance to the first frame in the list.
     */
    public void nextFrame() {
        if(currentFrame < numberOfFrames - 1) {
            currentFrame++;
        } else {
            currentFrame = 0;
        }
    }

    /**
     * Selects the previous frame in the frame sequence.
     * The frame list is considered to be circular, i.e. if prevFrame() is called at the
     * start of the list, this method will advance to the last frame in the list.
     */
    public void prevFrame()
    {
        if (currentFrame > 0) {
            currentFrame--;
        } else {
            currentFrame = numberOfFrames - 1;
        }
    }

    /**
     * set Current frame to the index
     * @param index
     */
    public void setFrame(int index) {
        this.currentFrame = index;
    }

    /**
     * return the current frame
     * @return currentFrame
     */
    public int getFrame() {
        return this.currentFrame;
    }

    /**
     * Returns weither the object containts frames
     * @return
     */
    public boolean isHasFrames() {
        return hasFrames;
    }

    /**
     * Returns the width of each frame.
     * @return frameWidth
     */
    public int getFrameWidth() {
        return frameWidth;
    }

    /**
     * returns the height of each frame.
     * @return frameHeight
     */
    public int getFrameHeight() {
        return frameHeight;
    }
}
