/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author p1500712
 */
public class SupprimerColonneTest {
    
    public SupprimerColonneTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of playEffect method, of class SupprimerColonne.
     * Commencé mais pas terminé
     */
    @Test
    public void testPlayEffect() {
        int line = 0;
        int column = 0;
        Game game=null;
        
        for(int i=0; i<game.getBoard().getHeight();i++){
            game.playMove(column);
        }
    }
    
}
