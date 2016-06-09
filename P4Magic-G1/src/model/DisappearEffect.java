/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Julien
 */
public class DisappearEffect extends Effect{

    /**
     * This effect changes the color of the tile that has just been played and
     * thus the owner of the tile)
     *
     * @param line
     * @param column
     * @param game
     */
    
    @Override
    public void playEffect(int line, int column, Game game) {
        
        game.getBoard().getTileIJ(line, column).setStatus(-1);
        
    }
    
    
}
