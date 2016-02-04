/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe.java;

import java.util.Scanner;

/**
 *
 * @author Dylan
 */
public class HumanPlayer implements Player{
    private final String name;
    private Scanner s;
    @Override
    public String getName() {
        return name;
    }
    private int XorO;
    
    HumanPlayer(String n){
        name = n;
    }
    
    @Override
    public int[] makeMove(Board b){
        int[] move = new int[2];
        int row = -1;
        int col = -1;
        s = new Scanner(System.in);
        while(!b.validInput(row, col)){
            System.out.print("Enter Coordinates:");
            String input = s.nextLine();
            System.out.println("");
            System.out.println("");
            if(input.length() != 3){continue;}
            row = Character.getNumericValue(input.charAt(0)) - 1;
            col = Character.getNumericValue(input.charAt(2)) - 1;
            move[0] = row;
            move[1] = col;
        }
        
        return move;
    }

    @Override
    public int getXorO() {
        return this.XorO;
    }
    
    @Override
    public void setXorO(int a){
        this.XorO = a;
    }
}


