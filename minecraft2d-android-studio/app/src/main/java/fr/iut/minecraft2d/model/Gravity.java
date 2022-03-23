package fr.iut.minecraft2d.model;

import android.util.Log;

import fr.iut.minecraft2d.model.bloc.Bloc;
import fr.iut.minecraft2d.model.player.Player;

/**
 * Simulates gravity on the player
 */
public class Gravity {
    /**
     * Player on which the gravity will be applied
     */
    private final Player player;

    private int cellSize;

    public Gravity(Player player, int cellSize){
        this.player = player;
        this.cellSize = cellSize;
    }

    public void gravityPlayer() {
        // TODO faire en sorte que le joueur puisse tomber
    }
}
