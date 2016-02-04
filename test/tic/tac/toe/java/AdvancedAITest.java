/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.java;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dylan
 */
public class AdvancedAITest {
    
    public AdvancedAITest() {
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
     * Test of makeMove method, of class AdvancedAI.
     */
    @Test
    public void testMakeMove() {
        System.out.println("Advanced AI makeMove");
        Board b = new Board();
        AdvancedAI instance = new AdvancedAI("test", Board.X);
        int[] expResult = null;
        int[] result = instance.makeMove(b);
        assertArrayEquals(expResult, result);
        
        int[][] blockable = new int[][]{{-1,0,-1},{0,0,0},{0,0,0}};
        b.board = blockable;
        int[] expResult1 = new int[]{0,1};
        result = instance.makeMove(b);
        assertArrayEquals(expResult1, result);
    }
    
}
