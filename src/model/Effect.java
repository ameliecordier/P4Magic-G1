/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import java.awt.Color;

/**
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public abstract class Effect {

    /**
     * Returns the outline color to display on the board when in debug mode
     * @return outline color
     */
    public Color getDebugOutlineColor() {
        return Color.GREEN;
    }

    /**
     * Gets the maximum effect usage count, after which the effect gets deleted.
     * The effect gets removed automatically by the Game if necessary.
     * @param line
     * @param column
     * @param game
     * @return max usage count. 0 if infinite (default).
     */
    public int getMaxUsageCount(int line, int column, Game game) {
        return 0;
    }

    //line and column are in the coordinates of the token that has just been played
    public abstract void playEffect(int line, int column, Game game);

}
