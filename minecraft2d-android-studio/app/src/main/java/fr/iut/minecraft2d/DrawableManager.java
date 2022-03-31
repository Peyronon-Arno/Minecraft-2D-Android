package fr.iut.minecraft2d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.HashMap;

/**
 * Drawable Manager
 * Loads drawables, and can return specific textures.
 */
public class DrawableManager {
    /**
     * CONSTANTS representing all differents blocs
     */
    public static final String AIR = "";
    public static final String BEDROCK = "bedrock";
    public static final String DIRT = "dirt";
    public static final String GRASS = "grass";
    public static final String LEAVES = "leaves";
    public static final String STONE = "stone";
    public static final String WOOD = "wood";

    /**
     * Assets of the map
     */
    public HashMap<String,Bitmap> assets;

    /**
     * Single instance of DrawableManager
     */
    private static DrawableManager drawableManager;

    /**
     * Returns an instance of DrawableManager, if it doesn't exist creates it.
     * @return Unique instance of DrawableManager
     */
    public static DrawableManager getInstance(){
        if(DrawableManager.drawableManager == null){
           DrawableManager.drawableManager = new DrawableManager();
        }
        return DrawableManager.drawableManager;
    }

    /**
     * This method will create the map
     * @return assets
     */
    public HashMap<String, Bitmap> loadBitmaps(Context context, int cellsize){

        //Creation of the map
        HashMap<String, Bitmap> assets = new HashMap<>();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inMutable = true;

        assets.put(BEDROCK,BitmapFactory.decodeResource(context.getResources(), R.drawable.bedrock, options));
        assets.put(DIRT,BitmapFactory.decodeResource(context.getResources(), R.drawable.dirt,options));
        assets.put(GRASS,BitmapFactory.decodeResource(context.getResources(), R.drawable.grass, options));
        assets.put(LEAVES,BitmapFactory.decodeResource(context.getResources(), R.drawable.leaves,options));
        assets.put(STONE,BitmapFactory.decodeResource(context.getResources(), R.drawable.stone,options));
        assets.put(WOOD,BitmapFactory.decodeResource(context.getResources(), R.drawable.wood,options));

        //Rescale of all blocks to the actual cellsize
        for(String key : assets.keySet()){
            Bitmap b = assets.get(key);
            b = Bitmap.createScaledBitmap(assets.get(key), cellsize,cellsize, true);
            assets.put(key, b);
        }

        //adding the player's texture
        Bitmap steve = BitmapFactory.decodeResource(context.getResources(), R.drawable.steve);
        assets.put("player", Bitmap.createScaledBitmap(steve, cellsize/2,cellsize + cellsize/2, true));
        Bitmap steveHead = BitmapFactory.decodeResource(context.getResources(),R.drawable.steve_head);
        assets.put("head", Bitmap.createScaledBitmap(steveHead, cellsize/2,cellsize/2,true));
        this.assets = assets;
        return assets;
    }

    /**
     * Returns a Bitmap texture given a texture name
     * @param texture given
     * @return the texture asked
     */
    public Bitmap getTexture(String texture){
        return assets.get(texture);
    }
}
