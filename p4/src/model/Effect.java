/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public abstract class Effect {

    //line and column are in the coordinates of the token that has just been played
    public abstract void playEffect(int line, int column, Game game);

}
