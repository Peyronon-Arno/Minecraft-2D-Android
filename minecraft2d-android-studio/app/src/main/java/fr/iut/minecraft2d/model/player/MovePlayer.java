package fr.iut.minecraft2d.model.player;

import fr.iut.minecraft2d.Collisionneur;
import fr.iut.minecraft2d.model.bloc.Bloc;

/**
 * Class used to move the player
 */
public class MovePlayer {





    /**
     * Player which will be moved
     */
    private final Player player;
    private Collisionneur collisionneur;
    /**
     * Constructor of the movePlayer
     * @param player move the player (steve)
     */
    public MovePlayer(Player player, Collisionneur collisionneur){
        this.player = player;
        this.collisionneur = collisionneur;
    }

    /**
     * The player go to the left changing coordinates
     * @param x X position
     */
    public void moveLeft(double x){
        this.player.setX(player.getX() - player.getSpeedX());
    }

    /**
     * The player go right changing coordinates
     * @param x X position
     */
    public void moveRight(double x){
        this.player.setX(player.getX() + player.getSpeedX());
    }

    /**
     * Method which is equal to a jump
     * @param y Y position of the player
     */
    public void moveUp(double y){
        if(collisionneur.bottomBlock().type != Bloc.Type.air){
            this.player.setY(player.getY() - player.getSpeedY());
        }
    }

    /**
     * Player go down after the jump
     * @param y Y position of the player
     */
    public void moveDown(double y){this.player.setY(player.getY() - 15);}


    /**
     * Method to check if player is in collision with a block
     * Case 1 : If there is a block down to the player, he won't fall
     * Case 2 : If there is a block on the left, the player won't go into the block
     * Case 3 : Similar to case 3 but with the right
     */
    /*public void checkCollision() {
        //Case 1 : Down
        if(!IsBlockDownEmpty){
            if (player.speedY > 0){
                player.speedY = 0;
            }
        }
        //Case 2 : Right
        if(!IsBlockRightEmpty){
            if(player.speedX >0){
                player.speedX =0;
            }

        }
        //Case 3 : Left
        if(!IsBlockLeftEmpty){
            if(player.speedX < 0){
                player.speedX =0;
            }
        }
    }*/



}
