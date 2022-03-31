package fr.iut.minecraft2d.model;


import android.graphics.Bitmap;

import java.util.HashMap;

import fr.iut.minecraft2d.model.utils.Collisionneur;
import fr.iut.minecraft2d.GameView;
import fr.iut.minecraft2d.model.map.Map;
import fr.iut.minecraft2d.model.player.MovePlayer;
import fr.iut.minecraft2d.model.player.Moves;
import fr.iut.minecraft2d.model.player.Player;

public class GameManager {

    /**
     * Canvas sur lequel on va dessiner
     */
    private GameView gameView;

    /**
     * Current player
     */
    private final Player player;

    /**
     * Moves the player when given inputs
     */
    private final MovePlayer movePlayer;

    /**
     * Length of the side a single bloc in the world.
     */
    private final int cellsize;

    /**
     * Value corresponding to the number of blocks passed by the player
     * example : if the player is above the 10th block it will store 10
     */
    public int xBlocIndex;

    /**
     * Value corresponding to the number of blocks passed by the player
     * example : if the player has detroyed 2 blocks under him, it will be 2
     */
    public int yBlocIndex;

    /**
     * Width of the world.
     */
    private int worldWidth;

    /**
     * Height of the world.
     */
    private int worldHeight;

    private Map map;

    /**
     * hashmap of assets
     * For example : bloc textures, player texture.
     */
    public HashMap<String, Bitmap> assets;

    private Collisionneur collisionneur;



    public GameManager(GameView gameView, int worldWidth, int worldHeight, HashMap<String, Bitmap> assets, int cellsize){
        this.gameView = gameView;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.map =  new Map(worldWidth, worldHeight);
        this.player = new Player(assets.get("player"), assets.get("head"), cellsize);
        this.collisionneur =  new Collisionneur(xBlocIndex, yBlocIndex, map);
        this.movePlayer = new MovePlayer(player, collisionneur);
        this.assets = assets;
        this.cellsize = cellsize;

    }

    public void setGameView(){
        gameView.setEnvironment(cellsize, assets, collisionneur);
        gameView.setPlayerEnvironment(player, movePlayer);
        gameView.setMapAssets(this.map);
    }

    // TODO incrémenter l'yBlocIndex à chaque fois que le joueur se déplace d'une cellsize
    /**
     * Change la position du joueur en fonction du bouton cliqué
     * @param move mouvement envoyé (LEFT / RIGHT / UP)
     */
    public void updateCoordoninates(Moves move, GameView gameView ){

        if(move == Moves.LEFT) {
            movePlayer.moveLeft();
            --xBlocIndex;
        }
        if(move == Moves.RIGHT) {
            movePlayer.moveRight();
            ++xBlocIndex;
        }
        if(move == Moves.UP) {
            movePlayer.moveUp();
            --yBlocIndex;
        }
        if(move == Moves.DOWN) {
            movePlayer.moveDown();
            ++yBlocIndex;
        }

        collisionneur.xIndexMap = this.xBlocIndex;
        collisionneur.yIndexMap = this.yBlocIndex;

        gameView.invalidate();
    }

    public int getCellsize(){
        return cellsize;
    }

    public int getWorldWidth(){ return worldWidth;}

    public int getWorldHeight(){ return worldHeight;}

    public void setWorldWidth(int width){worldWidth = width;}

    public void setWorldHeight(int height){worldHeight =height;}

    public void setGameView(GameView gameView){this.gameView = gameView;}



}
