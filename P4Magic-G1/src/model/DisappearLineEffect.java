/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Adrien Techer
 */
public class DisappearLineEffect extends Effect {

    /**
     * This effect makes the tile disappear that has just been played and thus
     * the owner of the tile)
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        for (int i = 0; i < column; i++) {
            game.getBoard().getTileIJ(line, i).setStatus(-1);
        }
        game.getBoard().getTileIJ(line, column).setStatus(-1);
    }
}
