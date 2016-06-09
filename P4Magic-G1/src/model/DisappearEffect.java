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
public class DisappearEffect extends Effect {

    /**
     * This effect prevent the actual player from putting a tile
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        //On met à -1 pour faire disparaître la case
        game.getBoard().getTileIJ(line, column).setStatus(-1);

    }

}
