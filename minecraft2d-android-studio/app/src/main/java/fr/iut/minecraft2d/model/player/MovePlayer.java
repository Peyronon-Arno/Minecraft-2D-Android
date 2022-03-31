package fr.iut.minecraft2d.model.player;

import fr.iut.minecraft2d.model.utils.Collisionneur;

/**
 * Class used to move the player
 */
public class MovePlayer {


    /**
     * Player which will be moved
     */
    private final Player player;

    /**
     * Constructor of the movePlayer
     * @param player move the player (steve)
     */
    public MovePlayer(Player player, Collisionneur collisionneur){
        this.player = player;
    }

    /**
     * The player go to the left changing coordinates
     */
    public void moveLeft(){
        this.player.setX(player.getX() - player.getSpeedX());
    }

    /**
     * The player go right changing coordinates
     */
    public void moveRight(){
        this.player.setX(player.getX() + player.getSpeedX());
    }

    /**
     * Method which is equal to a jump
     */
    public void moveUp(){
            this.player.setY(player.getY() - player.getSpeedY());
    }

    /**
     * Player go down after the jump
     */
    public void moveDown(){
        this.player.setY(player.getY() + player.getSpeedY());
    }



}
