package nl.bram_arts.projects.game_test.GameEngine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * class on which the tiles are drawn.
 * Created by bram on 22-6-2015.
 */
public class Window extends View {

    /**
     * a List of Byte arrays on which the location of each tile are set.
     */
    private ArrayList<Byte[]> map;

    /**
     * an list of all tiles based on the given tile image.
     */
    private ArrayList<Bitmap> tileList = new ArrayList<>();

    /**
     * start position of where the tiles are drawn;
     */
    private Vector position;
    /**
     * width and height of each tile;
     */
    private int tileWidth, tileHeight;

    /**
     * basic constructor
     * @param context
     */
    public Window(Context context) {
        super(context);
    }


    /**
     * Function to add the location of the tiles based on an start position
     * @param map the list containing the tiles.
     * @param position the start position of the tiles.
     */
    public void addEnvironmentMap(ArrayList<Byte[]> map, Vector position) {
        this.map = map;
        this.position = position;

    }

    /**
     * Function to initialize an list of tiles based on an image.
     * @param imageId image where the tiles are cropped.
     * @param rows number of rows in the image
     * @param colums number of colums in the image
     */
    public void initializeBackgroundList(int imageId, int rows, int colums) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), imageId);
        tileWidth = bmp.getWidth() / colums;
        tileHeight = bmp.getHeight() / rows;
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < colums; x++) {
                if(tileHeight > 0 && tileWidth > 0) {
                    Bitmap tile = Bitmap.createBitmap(bmp, x * tileWidth, y * tileHeight, tileWidth, tileHeight);
                    tileList.add(tile);
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(map != null && map.size() != 0) {
            float yPos = position.getY();
            for (int i = 0; i < map.size(); i++) {
                float xPos = position.getX();
                for (int j = 0; j < map.get(i).length; j++) {
                    if(map.get(i)[j] <= tileList.size()) {
                        Bitmap bmp = tileList.get(map.get(i)[j]);
                        canvas.drawBitmap(bmp, xPos, yPos, null);
                        xPos += tileWidth;
                    }
                }
                yPos +=tileHeight;
            }
        }
    }

    /**
     * returns the tileHeight.
     * @return tileHeight
     */
    public int getTileHeight() {
        return tileHeight;
    }

    /**
     * returns the tileWidth.
     * @return tileWidth
     */
    public int getTileWidth() {
        return tileWidth;
    }

    /**
     * returns the map
     * @return map
     */
    public ArrayList<Byte[]> getMap() {
        return map;
    }
}
