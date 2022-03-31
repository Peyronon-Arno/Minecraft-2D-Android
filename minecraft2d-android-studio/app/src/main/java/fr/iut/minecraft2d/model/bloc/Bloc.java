package fr.iut.minecraft2d.model.bloc;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

/**
 * Class which create blocs
 */
public class Bloc  {
    /**
     * Tyoe of the bloc
     */
    public Type type;

    /**
     * Texture of the bloc
     */
    public Bitmap texture;

    /**
     * Constructor if you only have type (only for AIR)
     * @param type
     */
    public Bloc(Type type){
        this.type = type;
        this.texture = null;
    }

    /**
     * Constructor for the other blocs which have a texture
     * @param type
     * @param texture
     */
    public Bloc(Type type, Bitmap texture){
        this.type = type;
        this.texture = texture;
    }

    /**
     * Get the type of the bloc
     * @return the type of the bloc
     */
    public Type getType() {
        return type;
    }

    /**
     * Set the type of the bloc
     * @param type of the bloc given
     */
    public void setType(Type type) {
        this.type = type;
    }


    /**
     * Enumeration of each type of block that we have
     */
    public enum Type {
        air,
        bedrock,
        dirt,
        grass,
        leaves,
        stone,
        wood

    }

    /**
     * Simple toString method
     * @return the type in string format
     */
    @NonNull
    public String toString(){
        return type.toString();
    }


}


