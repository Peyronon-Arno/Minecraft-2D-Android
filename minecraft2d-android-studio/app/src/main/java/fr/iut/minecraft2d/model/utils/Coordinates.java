package fr.iut.minecraft2d.model.utils;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;

/**
 * This class manage the coordinates of the player
 */
public class Coordinates {

    /**
     * Coordinates on the X axe
     */
    public double x;

    /**
     * Coordinates on the Y axe
     */
    public double y;


    public Coordinates(){};

    public Coordinates(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Coordinates CanvasToPosition(double xOnCanvas, double yOnCanvas, double xJoueur, double yJoueur, Canvas canvas, int cellSize){
        Coordinates coo = new Coordinates();
        coo.x = (xOnCanvas + xJoueur - canvas.getWidth()/2)/cellSize;
        coo.y = (yOnCanvas + yJoueur - canvas.getHeight()/2)/cellSize;
        return coo;
    }


    public Coordinates positionToCanvas(double xOnMonde, double yOnMonde, double xJoueur, double yJoueur, Canvas canvas, int cellSize){
        Coordinates coo = new Coordinates();
        coo.x = - xJoueur + canvas.getWidth()/2 + xOnMonde*cellSize;
        coo.y = - yJoueur + canvas.getHeight()/2 + yOnMonde*cellSize;
        return coo;
    }


}
