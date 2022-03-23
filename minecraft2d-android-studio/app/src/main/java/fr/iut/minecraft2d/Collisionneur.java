package fr.iut.minecraft2d;

import android.graphics.Rect;
import android.util.Log;

import fr.iut.minecraft2d.model.Gravity;
import fr.iut.minecraft2d.model.bloc.Bloc;
import fr.iut.minecraft2d.model.map.Map;
import fr.iut.minecraft2d.model.player.MovePlayer;
import fr.iut.minecraft2d.model.player.Player;

/**
 * This class will manage the collision between the player and the blocks
 */
public class Collisionneur {

    private static Rect rect;
    private static Rect r;
    public int xIndexMap;
    public int yIndexMap;
    private Map map;

    public Collisionneur(){};

    public Collisionneur(int xIndexMap, int yIndexMap, Map map){
        this.xIndexMap = xIndexMap;
        this.yIndexMap = yIndexMap;
        this.map = map;
    }


    /**
     * Vérifie si le joueur rentre en collision avec des blocs autour de lui
     * @param movePlayer
     */
    public static void checkBlocks(MovePlayer movePlayer, Player player) {

        //A gauche
        if(rect.intersect(r));{
            System.out.println("Collision gauche");
        }

        //A droite
        if(rect.intersect(r));{
            System.out.println("Collision droite");
        }

        //En haut
        if(rect.intersect(r));{
            System.out.println("Collision haut");
        }

        //En bas
        if(rect.intersect(r));{
            System.out.println("Collision bas");
        }
    }

    public Bloc bottomBlock(){
        Log.d("Collisionner", " " + yIndexMap);
        if(xIndexMap >= map.getXMax() || yIndexMap >= map.getYMax()){
            return new Bloc(Bloc.Type.air);
        }
            return map.getBlocInMap(this.xIndexMap, yIndexMap);
    }


}
