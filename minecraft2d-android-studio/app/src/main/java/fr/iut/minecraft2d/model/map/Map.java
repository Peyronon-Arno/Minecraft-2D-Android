package fr.iut.minecraft2d.model.map;


import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

import fr.iut.minecraft2d.DrawableManager;
import fr.iut.minecraft2d.model.bloc.Bloc;
import fr.iut.minecraft2d.model.utils.Coordinates;

/**
 * This class will manage the map
 */
public class Map {
    private final Bloc[][] map;

    /**
     * Max width of the map
     */
    private final int xMax;

    /**
     * Max height of the map
     */
    private final int yMax;

    /**
     * Creation of the map
     * @param xMax width of the map
     * @param yMax height of the map
     */
    public Map(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;

        map = new Bloc[xMax][yMax];


        //Couche d'air
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                map[x][y] = new Bloc(Bloc.Type.air, DrawableManager.getInstance().getTexture(DrawableManager.AIR));
            }
        }

        //Couche de bedrock
        for(int x = 0; x < xMax ; x++ ){
            for(int y = yMax-1; y > yMax-2; y-- ){
                map[x][y] = new Bloc(Bloc.Type.bedrock, DrawableManager.getInstance().getTexture(DrawableManager.BEDROCK) );
            }
        }

        //Couche de stone
        for (int x = 0; x < xMax ; x++) {
            for(int y = yMax-10; y < yMax-1; y++){
                map[x][y] = new Bloc(Bloc.Type.stone, DrawableManager.getInstance().getTexture(DrawableManager.STONE));
            }
        }

        //Couche de dirt

        for (int x = 0; x < xMax ; x++) {
            for(int y = 0; y < yMax-10; y++){
                map[x][y] = new Bloc(Bloc.Type.dirt, DrawableManager.getInstance().getTexture(DrawableManager.DIRT));
            }
        }

            //Couche d'herbe
        for (int x = 0; x < xMax ; x++) {
            for(int y = 0; y < yMax-34; y++){
                map[x][y] = new Bloc(Bloc.Type.grass, DrawableManager.getInstance().getTexture(DrawableManager.GRASS));
            }
        }

    }

    public Bloc[][] getMap(){ return map;}

    public void setBlocInMap(Bloc bloc, int x, int y){
        map[x][y] = bloc;
    }


    public Bloc getBlocInMap(int x, int y){
        if(x > this.xMax || y > this.yMax || x < 0 || y < 0){
            Log.d("MAP"," OUT OF BOUNDS");
            return new Bloc(Bloc.Type.air);
        }
        return map[x][y];
    }

    /**
     * Get the max size of the map (X)
     * @return the length of the map
     */
    public int getXMax(){return xMax;}

    /**
     * Get the max size of the map (Y)
     * @return the height of the map
     */
    public int getYMax(){return yMax;}

}
