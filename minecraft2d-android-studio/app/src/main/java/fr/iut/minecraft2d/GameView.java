package fr.iut.minecraft2d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

import fr.iut.minecraft2d.model.bloc.Bloc;
import fr.iut.minecraft2d.model.map.Map;
import fr.iut.minecraft2d.model.player.MovePlayer;
import fr.iut.minecraft2d.model.player.Player;
import fr.iut.minecraft2d.model.utils.Collisionneur;
import fr.iut.minecraft2d.model.utils.Coordinates;

/**
 * Drawer of the content of the playing activity
 */
@SuppressLint("ViewConstructor")
public class GameView extends View {

    /**
     * Player dessiné avec la class player
     */
    private Player player;

    /**
     * Mover of the player
     */
    private MovePlayer movePlayer;

    /**
     * Map of the game
     */
    private Map map;

    /**
     * Assets for the map
     */
    private HashMap<String, Bitmap> assets;

    /**
     * Number of cell which compose the map
     */
    public int cellSize;

    /**
     * Coordinates of the player
     */
    private Coordinates coord;

    /**
     * Manager the collision
     */
    private Collisionneur collisionneur;


    /**
     * Constructor of the MyCanvas, it will draw the map and the player
     * @param context context
     */
    public GameView(Context context){
        super(context);
    }

    /**
     * Sets the different variables of the environment
     * @param cellsize size of the side of a bloc
     */
    public void setEnvironment( int cellsize, HashMap<String,Bitmap> assets, Collisionneur collisionneur){
        this.cellSize = cellsize;
        this.assets = assets;
        this.coord = new Coordinates();
        this.collisionneur = collisionneur;
        invalidate();
    }

     public void setMapAssets(Map map){
         this.map = map;
         invalidate();
     }
    /**
     * Sets the player and the MovePlayer
     * @param player Current character
     * @param movePlayer Moves the player
     */
    public void setPlayerEnvironment(Player player, MovePlayer movePlayer){
        this.player = player;
        this.movePlayer = movePlayer;
        invalidate();
    }

    /**
     * Method which draw the player
     * @param canvas canvas on which we will draw
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMap(canvas);
        //Dessine steve
        canvas.drawBitmap(player.getTexture(), (float) getWidth()/2, (float)getHeight()/2-2*cellSize, null);
        canvas.drawBitmap(player.getHeadTexture(), (float) getWidth()/2, (float) getHeight()/2-2*cellSize, null);
        Log.d("GameView Loop", "  " + player.getSpeedY());
    }

    /**
     * Method which draw the map
     * @param canvas canvas on which we will draw the map and set the position of the map
     */
    private void drawMap(Canvas canvas){
        //Draws the world's background color
       canvas.drawRGB(102,178,255);

        int distanceLeft = 0, distanceTop = 500;
        Paint paint = new Paint(Color.RED);

        for(int y = 0; y<map.getYMax(); y++){
            for(int x = 0; x<map.getXMax()-1; x++){
                //converti la position des blocs dans le monde en position pour le canvas
                coord = coord.positionToCanvas(x, y,player.getX(),player.getY(),canvas, cellSize);

                if(map.getMap()[x][y].type != Bloc.Type.air){
                    canvas.drawBitmap(map.getMap()[x][y].texture, (int)coord.x, (int)coord.y, paint);
                    distanceLeft += cellSize;
                }
            }
            distanceLeft = 0;
            distanceTop += cellSize;
        }
    }

    private void bottomCollision(){

        if(this.collisionneur.bottomBlock().type == Bloc.Type.air){
            player.setSpeedY(-cellSize);
            invalidate();
        }
        else{
            player.setSpeedY(0);
            invalidate();
        }
    }

    /**
     * Set the assets of the map
     * @param assets of the map
     */
    public void setAssets(HashMap<String, Bitmap> assets){this.assets = assets;}

}
