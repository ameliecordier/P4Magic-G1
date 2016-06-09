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
 * @author Adrien
 */
public class RandomTileEffectTest {
    
    public RandomTileEffectTest() {
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
     * Test of playEffect method, of class RandomTileEffect.
     */
    @Test
    public void testPlayEffect() {
        System.out.println("playEffect");
        int line = 0;
        int column = 0;
        Game game = null;
        RandomTileEffect instance = new RandomTileEffect();
        instance.playEffect(line, column, game);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
