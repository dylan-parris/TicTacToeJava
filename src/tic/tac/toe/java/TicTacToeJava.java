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
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        board = new Board();
        board.drawBoard();
        gameplay(board);
    }
    public static boolean validInput(int row, int col){
        if(row > board.size || col > board.size){
            return false;
        } else if(row < 0 || col < 0){
            return false;
        } else if(board.get(row,col) != 0){
            return false;
        }
        return true;
    }
    public static void gameplay(Board board){
        while (true){
            if(player1Turn){
                System.out.println("Player 1's Turn");
            } else {
                 System.out.println("Player 2's Turn");
            }
            
            System.out.print("Enter Coordinates:");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println("");
            System.out.println("");
            int row = Character.getNumericValue(input.charAt(0)) - 1;
            int col = Character.getNumericValue(input.charAt(2)) - 1;
            if(validInput(row, col)){
                if(player1Turn){
                    board.placeX(row, col);
                    if(board.checkForWin() != 0){
                        System.out.println("Player 1 Wins!");
                        board.drawBoard();
                        break;
                    }
                    player1Turn = false;
                } else {
                    board.placeO(row, col);
                    if(board.checkForWin() != 0){
                        System.out.println("Player 2 Wins!");
                        break;
                    }
                    player1Turn = true;
                }
            }
            board.drawBoard();
        }
    }

}
