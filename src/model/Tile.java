/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 * Class Tile
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 *
 */
public class Tile {

    private int _status;
    private Effect _effect;
    private int _effectUseCount;

    /**
     * Tile constructor A tile has a status and an effect. The status indicates
     * to whom the tile belongs (1 or 2 if belonging to a player, -1 if free).
     * The effect determines if the tile is "magic" or not.
     *
     * @param status status values are: -1 if free, 1 or 2 if belonging to a
     * player
     *
     */
    public Tile(int status) {

        this._status = status;
        this._effect = null;
        this._effectUseCount = 0;
    }

    /**
     * Set the status of the tile. Status can be: free (-1), belonging to player
     * 1 (1) or player 2 (2)
     *
     * @param id the value of the status
     */
    public void setStatus(int id) {
        this._status = id;
    }

    /**
     * Set the effect of the tile. Any effect managed by the EffectFactory can
     * be applied to a tile.
     * Resets the effect usage count to 0.
     *
     * @param effect
     */
    public void setEffect(Effect effect) {
        this._effect = effect;
        this._effectUseCount = 0;
    }

    /**
     * Returns the effect currently active on the tile
     *
     * @return an effect
     */
    public Effect getEffect() {
        return this._effect;
    }

    /**
     * Returns the current status of a tile
     *
     * @return status, i.e. ID of the player or -1 if free
     */
    public int getStatus() {
        return this._status;
    }

    /**
     * @return The number of times the effect on the tile has been used.
     *         0 if there is no effect or the effect has never been used.
     *         In the context of Effect.playEffect, returns the number of uses
     *         BEFORE the method call.
     */
    public int getEffectUseCount() {
        return this._effectUseCount;
    }

    /**
     * Sets the number of times the effect on the tile has been used.
     *
     * @param c usage count
     */
    public void setEffectUseCount(int c) {
        this._effectUseCount = c;
    }
}
