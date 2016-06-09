package model;
/**
 * MagicP4
 * IUT Lyon 1 - 2016
 */


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Classe de tests de l'effet Disappear 
 * Principe de l'effet : un pion joué sur
 * une case portant l'effet Disappear disparaît immédiatement. Conséquences :
 * l'état du jeu n'est pas modifié, le pion joué n'apparaît pas sur la grille,
 * et le tour de jeu change
 *
 * @author acordier
 */
public class DisappearEffectTest {

    static Game aGame;

    public DisappearEffectTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        // Création d'un jeu vide
        aGame = new Game();
        Board b = new Board(10, 10);
        aGame.setBoard(b);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test du bon fonctionnement du jeu, en dehors de l'effet Résultats
     * attendus après le coup : - un pion de plus sur le plateau - le tour de
     * jeu est passé - l'effet a bien été appliqué
     */
    @Test
    public void testDisappearEffectNormalGame() {

        // On pré-remplit le plateau pour les besoins de la simulation 
        Utils.simulateAGame(aGame);

        // Effet fixé sur une case (qui n'est pas encore remplie)
        int height = aGame.getBoard().getHeight();
        // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
        aGame.getBoard().getTileIJ(height - 3, 0).setEffect(new DisappearEffect());

        // Récupération de l'ID du joueur avant que le coup soit joué 
        int id_player = aGame.getCurrentPlayer().getId();

        // Récupération du nombre de pions présents 
        int nb_tokens_before = aGame.getBoard().getTotalTilesCount();

        // Coup joué sur une case ne contenant pas l'effet 
        aGame.playMove(1);

        // Récupération du nombre de pions après le coup 
        int nb_tokens_after = aGame.getBoard().getTotalTilesCount();

        // Vérifications :
        // - l'effet est bien appliqué sur la case 
        // - le tour de jeu a bien changé
        // - il y a bien un pion de plus sur le plateau
        assertTrue("Doit être d'effet disappear", aGame.getBoard().getTileIJ(height - 3, 0).getEffect() instanceof DisappearEffect);
        assertTrue(aGame.getCurrentPlayer().getId() != id_player);
        assertEquals(nb_tokens_before + 1, nb_tokens_after);
    }

    /**
     * Test de DisappearEffect sur grille vide 
     * Vérification de l'état de la
     * tuile après application de l'effet 
     * Résultats attendus : la case doit être
     * vide, le tour de jeu doit être passé
     */
    @Test
    public void testDisappearEffectEmptyGame() {

        // Effet fixé sur une case 
        int height = aGame.getBoard().getHeight();
        aGame.getBoard().getTileIJ(height - 1, 0).setEffect(new DisappearEffect());

        // Récupération de l'ID du joueur courant 
        int id_player = aGame.getCurrentPlayer().getId();

        // Coup joué sur la case de l'effet 
        aGame.playMove(0);

        // Vérifications :
        // - la case est bien vide après
        // - l'effet est bien appliqué sur la case 
        // - le tour de jeu a bien changé
        assertEquals(-1, aGame.getBoard().getTileIJ(height - 1, 0).getStatus());
        assertTrue("Doit être d'effet disappear", aGame.getBoard().getTileIJ(height - 1, 0).getEffect() instanceof DisappearEffect);
        assertTrue(aGame.getCurrentPlayer().getId() != id_player);

    }

    /**
     * Test de DisappearEffect sur grille vide 
     * Vérification du nombre de jetons
     * après jeu 
     * Résultat attendu : le nombre doit être égal à 0
     */
    @Test
    public void testDisappearEffectEmptyGameWithTilesNumber() {

        // Effet fixé sur une case 
        int height = aGame.getBoard().getHeight();
        aGame.getBoard().getTileIJ(height - 1, 0).setEffect(new DisappearEffect());

        // Coup joué sur cette case 
        aGame.playMove(0);

        // Vérification que le nombre de jetons au total est égal à 0  
        assertEquals(0, aGame.getBoard().getTotalTilesCount());

    }

    /**
     * Test de DisappearEffect sur grille pré-remplie 
     * Vérification de l'état de
     * la tuile après application de l'effet 
     * Résultat attendu : la case doit
     * être vide, l'effet doit être sur la case 
     * et le tour doit être passé
     */
    @Test
    public void testDisappearEffectFilledGame() {

        // On pré-remplit le plateau pour les besoins de la simulation 
        Utils.simulateAGame(aGame);

        // Effet fixé sur une case (qui n'est pas encore remplie)
        int height = aGame.getBoard().getHeight();
        // height-3 correspond à la première case vide dans la colonne O, vu que l'on a déjà joué deux coups dans cette colonne
        aGame.getBoard().getTileIJ(height - 3, 0).setEffect(new DisappearEffect());

        // Récupération de l'ID du joueur avant que le coup soit joué 
        int id_player = aGame.getCurrentPlayer().getId();

        // Coup joué sur cette case 
        aGame.playMove(0);

        // Vérifications :
        // - la case est bien vide après
        // - l'effet est bien appliqué sur la case 
        // - le tour de jeu a bien changé
        assertEquals(-1, aGame.getBoard().getTileIJ(height - 3, 0).getStatus());
        assertTrue("Doit être d'effet disappear", aGame.getBoard().getTileIJ(height - 3, 0).getEffect() instanceof DisappearEffect);
        assertTrue(aGame.getCurrentPlayer().getId() != id_player);

    }

}