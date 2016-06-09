/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package puissance4;

import controller.GameController;
import model.Game;
import view.GameView;

/**
 * main
 *
 * @author hakkahi IUT Lyon 1 - 2016
 */
public class Main {

    public static void main(String args[]) {

        Game game = new Game();
        GameView board = new GameView();
        GameController controller = new GameController(board, game);
        game.addObserver(board);

    }
}
