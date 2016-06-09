package model;

/**
 *
 * @author ElementW
 */
public class DisappearEffect extends Effect {

    @Override
    public int getMaxUsageCount(int line, int column, Game game) {
        return 1;
    }

    /**
     * This effect removes the token that has just been played on the tile
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
