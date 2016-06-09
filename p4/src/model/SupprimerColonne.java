/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author p1500712
 */
public class SupprimerColonne extends Effect{
   
    /**
     * Cet effet sert à supprimer une colonne
     * Commencé mais pas terminé
     * @param line
     * @param column
     * @param game 
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        for(int i=0; i<game.getBoard().getHeight();i++){
            game.getBoard().getTileIJ(line, column).setStatus(-1);
        }
    }
    
}
