package model;

/**
 *
 * @author fanny
 */
public class DisappearColumnEffect extends Effect {
    
/**
 *  Fait disparaître la colonne dans laquelle le pion est joué
     * @param line
     * @param column
     * @param game
*/   
    
     @Override
    public void playEffect(int line, int column, Game game) {
        
        for (int i = 0; i < line ; ++i) {
            game.getBoard().getTileIJ(line, column).setStatus(-1);
        }  
    
}
}