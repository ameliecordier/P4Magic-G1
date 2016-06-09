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
public class DisappearColumnEffect extends Effect{
    @Override
    public void playEffect(int line, int column, Game game) {
        Board board = game.getBoard();
        for(int i = 0;i<board.getHeight();i++){
            game.getBoard().getTileIJ(i, column).setStatus(-1);
        }
    }
    
}
