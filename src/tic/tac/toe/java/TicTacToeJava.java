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
public class TicTacToeJava {
    static boolean player1Turn = true;
    static Board board;
    static HumanPlayer player1;
    static Player player2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initGame();
        board.drawBoard();
        gameplay(board);
    }
    
    private static void initGame(){
        board = new Board();
        System.out.print("Enter your name: ");
        Scanner s = new Scanner(System.in);
        player1 = new HumanPlayer(s.nextLine());
        selectPlayer2();
    }
    
    private static void selectPlayer2(){
        System.out.println("");
        System.out.println("Select who to play against");
        System.out.println("--------------------------");
        System.out.println("1. Another person");
        System.out.println("2. Novice Computer Player");
        
        System.out.println("Enter the cooresponding number: ");
        Scanner s = new Scanner(System.in);
        int p2Type = s.nextInt();
        switch(p2Type){
            case 1: 
                player2 = new HumanPlayer("Test");
                break;
            case 2: 
                player2 = new NoviceAI("");
                break;
        }
    }
    
    
    public static void gameplay(Board board){
        
        while (true){
            if(board.isBoardFull()){
                System.out.println("Draw!");
                break;
            }
            if(player1Turn){
                System.out.println("Player 1's Turn");
            } else {
                 System.out.println("Player 2's Turn");
            }
            
            
            if(player1Turn){
                int[] p1Move = player1.makeMove(board);
                board.placeX(p1Move);
                if(board.checkForWin()){
                    System.out.println("Player 1 Wins!");
                    board.drawBoard();
                    break;
                }
                player1Turn = false;
            } else {
                int[] p2Move = player2.makeMove(board);
                board.placeO(p2Move);
                if(board.checkForWin()){
                    System.out.println("Player 2 Wins!");
                    break;
                }
                player1Turn = true;
            }
            
            board.drawBoard();
        }
    }

}
