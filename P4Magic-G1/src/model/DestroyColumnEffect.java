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
public class DestroyColumnEffect extends Effect{
    
    /**
     * This effect destroy the actual column
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        for(int i = 0;i<game.getBoard().getHeight();i++){
            //On met à -1 pour faire disparaître les cases
            game.getBoard().getTileIJ(i, column).setStatus(-1);
        }
        
    }
}
