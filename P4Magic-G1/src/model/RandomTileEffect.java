/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Random;

/**
 *
 * @author Valentin Guevara
 */
public class RandomTileEffect extends Effect{

    /**
     * 
     * @param line ligne courante
     * @param column colonne courante
     * @param game jeu
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        Random rand = new Random();
        int random = rand.nextInt((game.getBoard().getWidth()-1) - 0 + 1) + 0;
        game.playMove(random);
    }
    
}
