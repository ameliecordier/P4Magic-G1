/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import model.Board;
import model.Game;
import model.HumanPlayer;
import view.GameView;

/**
 * GameController
 *
 * @author hakkahi and Amélie Cordier, IUT Lyon 1 - 2016
 *
 */
public final class GameController {

    private final GameView _view;
    private final Game _game;

    //Settings Listener
    private WindowAdapter _settingsClosingWindow;
    private ActionListener _settingsQuit;
    private ActionListener _settingsPlay;

    //Game Listener
    private MouseAdapter[][] _gameSelectColumnGrid;
    private MouseAdapter[][] _gameClickColumnGrid;
    private MouseAdapter[] _gameSelectColumnPreview;
    private MouseAdapter[] _gameClickColumnPreview;
    private WindowAdapter _gameClosingWindow;
    private ComponentAdapter _gameResizingWindow;

    //End Game Listener
    private ActionListener _endGamePlay;
    private ActionListener _endGameQuit;
    private WindowAdapter _endGameClosingWindow;

    /**
     * GameController constructor
     *
     * @param view
     * @param game
     */
    public GameController(GameView view, Game game) {

        //Initilalisation of the view
        this._view = view;
        this._game = game;

        initSettingsController();
        initEndGameController();

    }

    /**
     * Settings initialisation
     */
    public void initSettingsController() {

        this._settingsClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._settingsQuit = (ActionEvent e) -> {
            quit();
        };

        this._settingsPlay = (ActionEvent e) -> {
            startGame();
        };

        this._view.getSettingsFrame().addWindowListener(_settingsClosingWindow);
        this._view.getSettingsQuitButton().addActionListener(_settingsQuit);
        this._view.getSettingsPlayButton().addActionListener(_settingsPlay);

    }

    /**
     * Game initialisation
     */
    public void initGameController() {

        //Init of the event matrix for the Grid part
        this._gameSelectColumnGrid = new MouseAdapter[this._game.getBoard().getHeight()][this._game.getBoard().getWidth()];
        this._gameClickColumnGrid = new MouseAdapter[this._game.getBoard().getHeight()][this._game.getBoard().getWidth()];

        //Init of the event matrix for the Previw part
        this._gameSelectColumnPreview = new MouseAdapter[this._game.getBoard().getWidth()];
        this._gameClickColumnPreview = new MouseAdapter[this._game.getBoard().getWidth()];

        //Creation of the event that exit the game when clicking on the window cross
        this._gameClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._gameResizingWindow = new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {

                _view.setBorderSize();

            }

        };

        //Mouse events in the Grid
        for (int i = 0; i < this._game.getBoard().getHeight(); ++i) {

            for (int j = 0; j < this._game.getBoard().getWidth(); ++j) {

                final int column = j;
                final int line = i;

                this._gameSelectColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseEntered(MouseEvent e) {

                        _game.resetPosPreview();
                        _game.setPosPreview(column);

                    }
                };

                this._gameClickColumnGrid[i][j] = new MouseAdapter() {

                    @Override
                    public void mouseClicked(MouseEvent e) {

                        if (_game.getCurrentPlayer() instanceof HumanPlayer) {

                            if (_game.strokeIsValid(column)) {
                                _game.playMove(column);

                            }
                        }

                    }
                };

            }

        }

        //Mouse events int the preview
        for (int i = 0; i < this._game.getBoard().getWidth(); ++i) {

            final int column = i;

            this._gameSelectColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {

                    _game.resetPosPreview();
                    _game.setPosPreview(column);

                }
            };

            this._gameClickColumnPreview[i] = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {

                    if (_game.getCurrentPlayer() instanceof HumanPlayer) {
                        _game.playMove(column);
                    }
                }
            };

        }

        //Add events to elements in the view
        this._view.getMainFrame().addWindowListener(_gameClosingWindow);

        this._view.getMainFrame().addComponentListener(_gameResizingWindow);

        for (int i = 0; i < this._game.getBoard().getWidth(); ++i) {

            for (int j = 0; j < this._game.getBoard().getHeight(); ++j) {

                JPanel tmp = (JPanel) this._view.getGameRowsGrid().getComponent(i);
                tmp.getComponent(j).addMouseListener(this._gameSelectColumnGrid[j][i]);
                tmp.getComponent(j).addMouseListener(this._gameClickColumnGrid[j][i]);

            }

        }

        for (int i = 0; i < this._game.getBoard().getWidth(); ++i) {

            this._view.getGamePreview().getComponent(i).addMouseListener(this._gameSelectColumnPreview[i]);
            this._view.getGamePreview().getComponent(i).addMouseListener(this._gameClickColumnPreview[i]);

        }

    }

    /**
     * EndGame controller
     */
    public void initEndGameController() {

        this._endGameClosingWindow = new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                quit();
            }

        };

        this._endGamePlay = (ActionEvent e) -> {
            playAgain();
        };
        this._endGameQuit = (ActionEvent e) -> {
            quit();
        };

        this._view.getEndGameQuit().addActionListener(_endGameQuit);
        this._view.getEndGamePlay().addActionListener(_endGamePlay);
        this._view.getEndGameFrame().addWindowListener(_gameClosingWindow);

    }

    /**
     * Exit method
     */
    private void quit() {
        System.exit(0);
    }

    /**
     * Replay method
     */
    private void playAgain() {

        this._view.getEndGameFrame().setVisible(false);
        this._view.getMainFrame().setVisible(false);
        this._view.getSettingsFrame().setVisible(true);
        this._game.resetGame();
        this._view.resetView();

    }

    /**
     * Start a new game method
     */
    private void startGame() {

        int width = 10;
        int height = 10;

        Board board = new Board(width, height);
        this._game.setBoard(board);
        this._game.getBoard().setEffectChances(this._view.getSettingsTileSlider().getValue());

        this._game.setTilesEffect();

        this._view.setWidth(width);
        this._view.setHeight(height);
        GameView.fillGrids();

        initGameController();

        this._view.getSettingsFrame().setVisible(false);

        this._view.setVisible(true);

    }

}
