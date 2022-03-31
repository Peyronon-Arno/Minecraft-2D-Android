package fr.iut.minecraft2d.model.utils;

import android.graphics.Rect;
import android.util.Log;

import fr.iut.minecraft2d.model.bloc.Bloc;
import fr.iut.minecraft2d.model.map.Map;
import fr.iut.minecraft2d.model.player.MovePlayer;
import fr.iut.minecraft2d.model.player.Player;

/**
 * This class will manage the collision between the player and the blocks
 */
public class Collisionneur {

    public int xIndexMap;
    public int yIndexMap;
    private Map map;


    public Collisionneur(int xIndexMap, int yIndexMap, Map map){
        this.xIndexMap = xIndexMap;
        this.yIndexMap = yIndexMap;
        this.map = map;
    }

    public Bloc bottomBlock(){
        Log.d("Collisionner", " " + yIndexMap);
        if(xIndexMap >= map.getXMax() || yIndexMap >= map.getYMax()){
            return new Bloc(Bloc.Type.air);
        }
        return map.getBlocInMap(this.xIndexMap, yIndexMap);
    }
}
