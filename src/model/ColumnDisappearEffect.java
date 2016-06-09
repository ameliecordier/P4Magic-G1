package model;

import java.awt.Color;

/**
 *
 * @author ElementW
 */
public class ColumnDisappearEffect extends Effect {

    @Override
    public Color getDebugOutlineColor() {
        return Color.ORANGE;
    }

    /**
     * This effect removes all the tokens on the board column the effect tile
     * is on, including the token just played.
     *
     * @param line
     * @param column
     * @param game
     */
    @Override
    public void playEffect(int line, int column, Game game) {
        final int height = game.getBoard().getHeight();
        for (int i = height - 1; i >= 0; --i) {
            game.getBoard().getTileIJ(i, column).setStatus(-1);
        }
    }

}
