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
    static Scanner s;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        s = new Scanner(System.in);
        initGame();
        board.drawBoard();
        gameplay(board);
        s.close();
    }
    
    private static void initGame(){
        board = new Board();
        System.out.print("Enter your name: ");
        player1 = new HumanPlayer(s.nextLine());
        selectPlayer2();
    }
    
    private static void selectPlayer2(){
        System.out.println("");
        System.out.println("Select who to play against");
        System.out.println("--------------------------");
        System.out.println("1. Another person");
        System.out.println("2. Novice Computer Player");
        System.out.println("3. Advanced Computer Player");
        
        System.out.println("Enter the cooresponding number: ");
        
        int p2Type = s.nextInt();
        switch(p2Type){
            case 1:
                player2 = new HumanPlayer("Test");
                break;
            case 2:
                player2 = new NoviceAI("Player 2");
                break;
            case 3:
                player2 = new AdvancedAI("Player 2", Board.O);
        }
    }
    
    
    public static void gameplay(Board board){
        player1.setXorO(Board.X);
        player2.setXorO(Board.O);
        while (!board.checkForWin()){
            if(board.isBoardFull()){
                System.out.println("Draw!");
                break;
            }
                        
            if(player1Turn){
                System.out.println("Player 1's Turn");
                playerTurn(player1);
                player1Turn = false;
            } else {
                System.out.println("Player 2's Turn");
                playerTurn(player2);
                player1Turn = true;
            }
            
            board.drawBoard();
            
        }
    }
    
    private static void playerTurn(Player player){
        int[] pMove = player.makeMove(board);
        board.placePiece(pMove, player.getXorO());
        if(board.checkForWin()){
            System.out.println(player.getName() + " Wins!");
        }
    }

}
