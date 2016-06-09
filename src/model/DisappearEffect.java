package model;

/**
 *
 * @author fanny
 */
public class DisappearEffect extends Effect {
    
/*
Principe de l'effet : un pion joué sur
 * une case portant l'effet Disappear disparaît immédiatement. Conséquences :
 * l'état du jeu n'est pas modifié, le pion joué n'apparaît pas sur la grille,
 * et le tour de jeu change
*/
    
        @Override
    public void playEffect(int line, int column, Game game) {
                
        game.getBoard().getTileIJ(line, column).setStatus(-1);
          
    }

}


