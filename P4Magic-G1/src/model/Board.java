/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package model;

/**
 * Class Board
 *
 * @author hakkahi - IUT Lyon 1 - 2016
 */
public class Board {

    private Tile[][] _board;
    private int _tileEffectChance;
    private int _width;
    private int _height;

    /**
     * Board constructor
     *
     * @param width
     * @param height
     */
    public Board(int width, int height) {

        this._width = width;
        this._height = height;

        this._board = new Tile[this._height][this._width];
        init();

    }

    /**
     * Init the board (set all tiles status to -1)
     */
    private void init() {

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {
                this._board[i][j] = new Tile(-1);
            }

        }

    }

    /**
     * Reset all the settings of the board (effects and owners of tiles
     */
    public void resetBoard() {

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                this._board[i][j].setEffect(null);
                this._board[i][j].setStatus(-1);

            }

        }

    }

    /**
     * Set the percentage of chances of having and effect on a tile
     *
     * @param tileEffectChance
     */
    public void setEffectChances(int tileEffectChance) {
        this._tileEffectChance = tileEffectChance;
    }

    /**
     * Set the width of a the board
     *
     * @param width
     */
    public void setWidth(int width) {
        this._width = width;
    }

    /**
     * Set the height of the board
     *
     * @param height
     */
    public void setHeight(int height) {
        this._height = height;
    }

    /**
     * Get a tile from the board (i and j are coordinates)
     *
     * @param i
     * @param j
     * @return a tile
     */
    public Tile getTileIJ(int i, int j) {
        return this._board[i][j];
    }

    /**
     * Get the percentage of chance of having an effect on a tile
     *
     * @return effectChance
     */
    public int getTileEffectChance() {
        return this._tileEffectChance;
    }

    /**
     * Get the board width
     *
     * @return width
     */
    public int getWidth() {
        return this._width;
    }

    /**
     * Get the board height
     *
     * @return height
     */
    public int getHeight() {
        return this._height;
    }

    /**
     * Returns a raw String for displaying the grid in full text with player IDs
     *
     * @return a raw String composed of -1, 1 and 2.
     */
    @Override
    public String toString() {

        String boardString = "";

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                boardString += this._board[i][j].getStatus();

            }
            boardString += "\n";

        }
        return boardString;
    }

    /**
     * Returns a Strings for displaying the current state of the grid in full
     * text
     *
     * @return a String containing x, o and - as symbols for resp. player 1, 2
     * and empty
     */
    public String toStringSymbols() {

        String boardString = "";
        int idPlayer;

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                idPlayer = this._board[i][j].getStatus();
                switch (idPlayer) {
                    case 1:
                        boardString += "x";
                        break;
                    case 2:
                        boardString += "o";
                        break;
                    default:
                        boardString += "-";
                        break;
                }

            }
            boardString += "\n";

        }
        return boardString;
    }

    /**
     * Returns the number of tiles owned by player 1 on the board
     *
     * @return numberoftiles of player 1
     */
    public int getTilesCountPlayer1() {

        int count = 0;

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                if (this._board[i][j].getStatus() == 1) {
                    count++;
                }

            }

        }

        return count;

    }

    /**
     * Returns the number of tiles owned by player 2 on the board
     *
     * @return numberoftiles of player 2
     */
    public int getTilesCountPlayer2() {

        int count = 0;

        for (int i = 0; i < this._height; ++i) {

            for (int j = 0; j < this._width; ++j) {

                if (this._board[i][j].getStatus() == 2) {
                    count++;
                }

            }

        }

        return count;

    }

    /**
     * Returns the total number of tiles on the board
     *
     * @return numberoftiles
     */
    public int getTotalTilesCount() {
        return getTilesCountPlayer1() + getTilesCountPlayer2();
    }

}
