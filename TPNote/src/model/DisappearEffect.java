/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author p1506953
 */
public class DisappearEffect extends Effect {
    /**
     * Méthode héritée pour appliquer l'effet Disappear
     * @param line indice ligne du plateau
     * @param column indice colonne du plateau
     * @param game objet du jeu en cours
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        game.getBoard().getTileIJ(line, column).setStatus(-1);
    }
    
}
