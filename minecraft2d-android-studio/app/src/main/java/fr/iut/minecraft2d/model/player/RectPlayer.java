package fr.iut.minecraft2d.model.player;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import androidx.annotation.NonNull;

/**
 * Class which create the player
 */
public class RectPlayer implements GameObjectPlayer {

    /**
     * Rectangle
     */
    private final RectF rectangle;

    /**
     * Color of the rectangle
     */
    private final int color;

    /**
     * X speed of the player
     */
    public double speedX;

    /**
     * Y speed of the player
     */
    public double speedY;

    /**
     * Coord X of the player
     */
    public int x;

    /**
     * Coord Y of the player
     */
    public int y;

    /**
     * Constrcutor of the Rectangle
     * @param rect Rectangle // can't be null
     * @param color Color of the rectangle // can't be null
     */
    public RectPlayer(@NonNull RectF rect, int color) {
        this.rectangle = rect;
        this.color = color;
    }

    /**
     * Getter of the rectangle
     * @return the rectangle
     */
    public RectF getRectangle() {
        return rectangle;
    }

    /**
     * Draw the rectangle
     * @param canvas canvas that we will draw the rectangle
     */
    @Override
    public void draw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setColor(color);
        canvas.drawRect(rectangle,paint);
    }

    @Override
    public void update() {

    }

    /**
     * Update the position X and Y of the rectangle
     * @param point update the new coord
     */
    public void update(Point point) {
        rectangle.set(
                point.x-rectangle.width()/2,
                point.y -rectangle.height()/2,
                point.x+ rectangle.width()/2,
                point.y- rectangle.height()/2
        );
    }



    public void setCoord(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
