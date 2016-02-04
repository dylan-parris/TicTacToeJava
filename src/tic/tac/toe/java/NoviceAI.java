/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.java;
import java.util.Random;
/**
 *
 * @author Dylan
 */
public class NoviceAI implements Player{
    private String name;
    private int peice;
    //private Board board;
    
    NoviceAI(String n){
        name = n;
    }
    
    NoviceAI(String n, Board b){
        name = n;
    }

    public void setXorO(int a){
        peice = a;
    }
    
    private int randomInt(int max){
        return randomInt(0, max);
    }
    
    private int randomInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) % Board.SIZE;
    }
    
    @Override
    public int[] makeMove(Board b){
        int row = randomInt(Board.SIZE);
        int col = randomInt(Board.SIZE);
        
        while(b.get(row, col) != Board.EMPTY){
            row = randomInt(Board.SIZE);
            col = randomInt(Board.SIZE);
        }
        int[] move = {row, col};
        return move;
    }

    @Override
    public int getXorO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
