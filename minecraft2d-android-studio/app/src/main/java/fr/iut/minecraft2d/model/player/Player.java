package fr.iut.minecraft2d.model.player;

import android.graphics.Bitmap;
import android.graphics.Rect;

import fr.iut.minecraft2d.model.utils.Coordinates;

/**
 * Class of the player
 */
public class Player {

    /**
     * Player coordinates
     */
    private Coordinates coordinates;
    /**
     * X speed of the player
     */
    private double speedX;

    /**
     * Y speed of the player
     */
    private double speedY;

    /**
     * Know if payer is turned on the right
     */
    private boolean isFacingRight;

    /**
     * The value of the gravity that affects the player
     */
    private int gravity = 15;

    /**
     * Texture for the body of the player
     */
    private Bitmap texture;

    /**
     * Texture for the head of the player
     */
    private Bitmap headTexture;

    /**
     * Rectangle which will help for collision
     */
    private Rect detectCollision;

    /**
     * Player will start looking at to the right
     * @param texture The Player's body texture
     * @param headTexture The Player's head texture
     * @parem speed The movement speed of the player
     */
    public Player(Bitmap texture, Bitmap headTexture, int speed){
        isFacingRight = true;
        coordinates = new Coordinates(0,0);
        this.texture = texture;
        this.headTexture = headTexture;
        this.speedX = speed;
        this.speedY = speed;


        //Creation of the detector of collision giving the coordinates of Steve's body
        detectCollision = new Rect((int) coordinates.x, (int) coordinates.y, texture.getWidth(), texture.getHeight());
        detectCollision.left = (int) coordinates.x;
        detectCollision.top = (int) coordinates.y;
        detectCollision.right = (int) coordinates.x + texture.getWidth();
        detectCollision.bottom = (int) coordinates.y + texture.getHeight();
    }

    /**
     * Get the X position of the player
     * @return X position
     */
    public double getX() {
        return coordinates.x;
    }

    /**
     * Get Y position of the player
     * @return Y position
     */
    public double getY() {
        return coordinates.y;
    }

    /**
     * Set X position of the player
     * @param x X position
     */
    public void setX(double x){coordinates.x = x; }

    /**
     * Set Y position of the player
     * @param y Y position
     */
    public void setY(double y){coordinates.y = y;}

    /**
     * Get speed on X axes
     * @return X speed
     */
    public double getSpeedX() {
        return speedX;
    }

    /**
     * Get speed on Y axes
     * @return Y speed
     */
    public double getSpeedY() {
        return speedY;
    }

    /**
     * Set speed on X axes
     * @param speedX speed of the player
     */
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    /**
     * Set speed on Y axes
     * @param speedY speed of the player
     */
    public void setSpeedY(double speedY){
        this.speedY =  speedY;
    }

    /**
     * To know the orientation of the player
     * @return isFacingRight
     */
    public boolean isFacingRight(){
        return isFacingRight;
    }

    /**
     * Set the knew position of the player
     * @param facingRight face the player to the right
     */
    public void setFacingRight(boolean facingRight) {
        isFacingRight = facingRight;
    }

    /**
     * get the texture for the body of the player
     * @return the texture of the body of the player
     */
    public Bitmap getTexture(){
        return texture;
    }

    /**
     * Get the texture of the head of the player
     * @return the texture of the head of the player
     */
    public Bitmap getHeadTexture(){return headTexture;}

    /**
     * Get the collision detection
     * @return if it's collide
     */
    public Rect getDetectCollision() {
        return detectCollision;
    }
}
