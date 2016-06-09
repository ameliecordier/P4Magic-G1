/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

import java.awt.Color;

/**
 * class Player
 *
 * @author hakkahi
 */
public abstract class Player {

    private Color _color;
    private int _id;

    /**
     * Player constructor
     *
     * @param id the ID of the player
     * @param color the color of the player
     */
    public Player(int id, Color color) {

        this._color = color;
        this._id = id;

    }

    /**
     * Get the current color of the player
     *
     * @return a Color
     */
    public Color getColor() {
        return this._color;
    }

    /**
     * Get the current id of the player
     *
     * @return the player id
     */
    public int getId() {
        return this._id;
    }

    /**
     * Set the color of the player
     *
     * @param color
     */
    public void setColor(Color color) {
        this._color = color;
    }

    /**
     * Set the id of the player
     *
     * @param id
     */
    public void setId(int id) {
        this._id = id;
    }
}
