/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */
package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;
import model.Game;
import model.Player;

/**
 * GameView class
 *
 * @author hakkahi IUT Lyon 1 - 2016
 */
public final class GameView extends JFrame implements Observer {

    //Settings Frame
    private JFrame _settingsFrame;
    private JPanel _settingsComponentGrid;
    private JButton _settingsQuit;
    private JButton _settingsPlay;
    private JSeparator _settingsSeparator;
    private JSlider _settingsSliderEffectChance;
    private JLabel _settingsSliderLabel;
    private JPanel _settingsSliderPanel;

    //Game Frame (Main Frame)
    private JPanel _gameWindow;
    public static JPanel _gamePreview;
    public static JPanel _gameRowsGrid;
    private int _gameWindowHeight = 800;
    private int _gameWindowWidth = 600;
    private int _gameBorderSize = (_gameWindowWidth * 1) / 100;
    private static Border _gameBlueLine;

    //End Game Frame
    private JFrame _endGameFrame;
    private JLabel _endGameLabel1;
    private JLabel _endGameLabel2;
    private JButton _endGameQuit;
    private JButton _endGamePlay;
    private JPanel _endGamePanel;
    private JPanel _endGameButtons;

    private static int _width;
    private static int _height;

    /**
     * GameView constructor
     *
     */
    public GameView() {

        super("Puissance4 - Game");

        initSettingsFrame();
        this.setVisible(false);
        initGameFrame();
        initEndGameFrame();
    }

    /**
     * initSettingsFrame Settings panel
     */
    private void initSettingsFrame() {

        this._settingsFrame = new JFrame("Puissance4 - Settings");
        this._settingsFrame.setSize(600, 500);
        this._settingsFrame.setResizable(false);
        this._settingsFrame.setLocationRelativeTo(null);
        this._settingsComponentGrid = new JPanel(new GridLayout(3, 1));
        this._settingsPlay = new JButton("Play");
        this._settingsQuit = new JButton("Quit");
        this._settingsSeparator = new JSeparator();
        this._settingsSliderPanel = new JPanel(new GridLayout(4, 1));
        this._settingsSliderEffectChance = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        this._settingsSliderEffectChance.setMajorTickSpacing(10);
        this._settingsSliderEffectChance.setMinorTickSpacing(1);
        this._settingsSliderEffectChance.setPaintTicks(true);
        this._settingsSliderEffectChance.setPaintLabels(true);
        this._settingsSliderLabel = new JLabel("Pourcentage de chance d'effet sur une case", JLabel.CENTER);
        this._settingsSliderLabel.setVerticalAlignment(JLabel.BOTTOM);

        this._settingsFrame.add(this._settingsComponentGrid);
        this._settingsComponentGrid.add(this._settingsSliderPanel);
        this._settingsSliderPanel.add(this._settingsSliderLabel);
        this._settingsSliderPanel.add(this._settingsSliderEffectChance);
        this._settingsSliderPanel.add(new JLabel(""));
        this._settingsSliderPanel.add(this._settingsSeparator);
        this._settingsComponentGrid.add(this._settingsPlay);
        this._settingsComponentGrid.add(this._settingsQuit);

        this._settingsFrame.setVisible(true);

    }

    /**
     * Game frame
     */
    public void initGameFrame() {

        this.setSize(_gameWindowHeight, _gameWindowWidth);
        this.setLocationRelativeTo(null);

        this._gameWindow = new JPanel(new GridBagLayout());
        _gameRowsGrid = new JPanel(new GridLayout(1, 0));
        _gamePreview = new JPanel(new GridLayout(1, 0));

        _gameBlueLine = BorderFactory.createLineBorder(Color.BLUE, _gameBorderSize);

        GridBagConstraints cWindow = new GridBagConstraints();

        _gameRowsGrid.setBackground(Color.WHITE);

        _gamePreview.setBackground(Color.WHITE);

        this.add(getGameWindow());

        cWindow.fill = GridBagConstraints.BOTH;
        cWindow.weightx = 1;
        cWindow.gridx = 0;
        cWindow.gridy = 0;
        cWindow.weighty = 0.14;
        getGameWindow().add(getGamePreview(), cWindow);

        cWindow.weightx = 1;
        cWindow.gridx = 0;
        cWindow.gridy = 1;
        cWindow.weighty = 0.86;
        getGameWindow().add(getGameRowsGrid(), cWindow);

        this.setVisible(false);

    }

    /**
     * End game frame
     */
    private void initEndGameFrame() {

        this._endGameFrame = new JFrame("Puissance4 - EndGame");
        this._endGameFrame.setSize(500, 200);
        this._settingsFrame.setResizable(false);
        this._endGameFrame.setLocationRelativeTo(null);
        this._endGamePlay = new JButton("New Game");
        this._endGameQuit = new JButton("Quit");
        this._endGameLabel1 = new JLabel();
        this._endGameLabel2 = new JLabel("Play Again ?");
        this._endGameLabel2.setVerticalAlignment(JLabel.TOP);
        this._endGameLabel2.setHorizontalAlignment(JLabel.CENTER);
        this._endGameButtons = new JPanel(new GridLayout(1, 2));
        this._endGamePanel = new JPanel(new GridLayout(3, 1));

        this._endGameFrame.add(this._endGamePanel);
        this._endGamePanel.add(this._endGameLabel1);
        this._endGamePanel.add(this._endGameLabel2);
        this._endGamePanel.add(this._endGameButtons);
        this._endGameButtons.add(this._endGamePlay);
        this._endGameButtons.add(this._endGameQuit);

        this._endGameFrame.setVisible(false);

    }

    /**
     * Update method
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof Game) {

            Game game = (Game) o;

            resetPreview();

            if (game.getPosPreview() != -1) {

                this.getGamePreview().getComponent(game.getPosPreview()).setBackground(game.getCurrentPlayer().getColor());

            }

            for (int i = 0; i < _width; ++i) {

                for (int j = 0; j < _height; ++j) {

                    Player tmp = game.getPlayerById(game.getBoard().getTileIJ(j, i).getStatus());

                    if (tmp != null) {

                        JPanel panelTmp = (JPanel) _gameRowsGrid.getComponent(i);
                        panelTmp.getComponent(j).setBackground(tmp.getColor());

                    } else {

                        JPanel panelTmp = (JPanel) _gameRowsGrid.getComponent(i);
                        panelTmp.getComponent(j).setBackground(Color.WHITE);

                    }
                    if (game.getBoard().getTileIJ(j, i).getEffect() != null) {

                        JPanel panelTmp = (JPanel) _gameRowsGrid.getComponent(i);
                        JLabel tmps = (JLabel) panelTmp.getComponent(j);
                        tmps.setBorder(BorderFactory.createLineBorder(Color.GREEN, _gameBorderSize));

                    } else {

                        JPanel panelTmp = (JPanel) _gameRowsGrid.getComponent(i);
                        JLabel tmps = (JLabel) panelTmp.getComponent(j);
                        tmps.setBorder(_gameBlueLine);

                    }

                }

            }
            if (game.getWinner() != -1) {

                this._endGameLabel1.setText("Player 2 Wins !");

                if (game.getWinner() == game.getPlayer1().getId()) {
                    this._endGameLabel1.setText("Player 1 Wins !");
                }

                this._endGameLabel1.setVerticalAlignment(JLabel.CENTER);
                this._endGameLabel1.setHorizontalAlignment(JLabel.CENTER);

                this._endGameFrame.setVisible(true);

            }
            if (game.getOver()) {
                this._endGameLabel1.setText("Draw !");
                this._endGameLabel1.setVerticalAlignment(JLabel.CENTER);
                this._endGameLabel1.setHorizontalAlignment(JLabel.CENTER);

                this._endGameFrame.setVisible(true);
            }

        }
    }

    /**
     * Reset method
     */
    public void resetPreview() {

        for (int i = 0; i < _width; ++i) {

            this.getGamePreview().getComponent(i).setBackground(Color.WHITE);

        }

    }

    /**
     * Fill grid method
     */
    public static void fillGrids() {

        for (int i = 0; i < _width; i++) {

            JPanel gameColsGrid = new JPanel(new GridLayout(0, 1));

            for (int j = 0; j < _height; ++j) {

                JLabel labelGrid = new JLabel();
                labelGrid.setBorder(_gameBlueLine);
                labelGrid.setOpaque(true);
                labelGrid.setBackground(Color.WHITE);
                labelGrid.setVerticalAlignment(SwingConstants.CENTER);
                labelGrid.setHorizontalAlignment(SwingConstants.CENTER);
                gameColsGrid.add(labelGrid);

            }

            _gameRowsGrid.add(gameColsGrid);
        }

        for (int i = 0; i < _width; i++) {

            JLabel labelPreview = new JLabel();
            labelPreview.setOpaque(true);
            labelPreview.setBackground(Color.WHITE);
            labelPreview.setVerticalAlignment(SwingConstants.CENTER);
            labelPreview.setHorizontalAlignment(SwingConstants.CENTER);
            _gamePreview.add(labelPreview);
        }

    }

    /**
     * Reset View method
     */
    public void resetView() {
        _gameRowsGrid.removeAll();
        _gamePreview.removeAll();
    }

    /**
     * Set border size
     */
    public void setBorderSize() {

        Rectangle rectangle = this.getBounds();

        this.setGameWindowHeight(rectangle.height);
        this.setGameWindowWidth(rectangle.width);

        _gameBorderSize = (_gameWindowWidth * 1) / 100;

        _gameBlueLine = BorderFactory.createLineBorder(Color.BLUE, _gameBorderSize);

        this.setLabelBorder();

    }

    /**
     * Set window height
     *
     * @param height
     */
    public void setGameWindowHeight(int height) {
        this._gameWindowHeight = height;
    }

    /**
     * Set window width
     *
     * @param width
     */
    public void setGameWindowWidth(int width) {
        this._gameWindowWidth = width;
    }

    /**
     * Set label border
     */
    public void setLabelBorder() {

        for (int i = 0; i < _width; i++) {

            JPanel gameColsGrid = new JPanel(new GridLayout(0, 1));

            for (int j = 0; j < _height; ++j) {
                JPanel panelTmp = (JPanel) _gameRowsGrid.getComponent(i);
                JLabel tmps = (JLabel) panelTmp.getComponent(j);
                tmps.setBorder(_gameBlueLine);

            }

        }

    }

    public void setWidth(int width) {
        _width = width;
    }

    public void setHeight(int height) {
        _height = height;
    }

    public JFrame getEndGameFrame() {
        return this._endGameFrame;
    }

    public JButton getEndGameQuit() {
        return this._endGameQuit;
    }

    public JButton getEndGamePlay() {
        return this._endGamePlay;
    }

    public JFrame getSettingsFrame() {
        return this._settingsFrame;
    }

    public JButton getSettingsQuitButton() {
        return this._settingsQuit;
    }

    public JButton getSettingsPlayButton() {
        return this._settingsPlay;
    }

    public JSlider getSettingsTileSlider() {
        return this._settingsSliderEffectChance;
    }

    public JPanel getGameWindow() {
        return _gameWindow;
    }

    public JPanel getGamePreview() {
        return _gamePreview;
    }

    public JPanel getGameRowsGrid() {
        return _gameRowsGrid;
    }

    public JFrame getMainFrame() {
        return this;
    }

}
