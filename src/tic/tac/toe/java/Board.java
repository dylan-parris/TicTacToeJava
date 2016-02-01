package tic.tac.toe.java;

/**
 * @author Dylan Parris
 */
public class Board {
    int[][] board;
    public static final int SIZE = 3;
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int Y = 2;
    
    public Board(){
        board = new int[SIZE][SIZE];
        initBoard();
    }
    
    private void initBoard(){
        for(int i = 0; i < SIZE; i++){
            for( int j = 0; j < SIZE; j++){
                board[i][j] = EMPTY;
            }
        }
    }
    
    public boolean placeX(int[] move){
        return placeX(move[0], move[1]);
    }
    
    public boolean placeX(int row, int col){
        if(board[row][col] == EMPTY){
            board[row][col] = X;
            return true;
        }
        return false;
    }
    
    public boolean placeO(int[] move){
        return placeO(move[0],move[1]);
    }
    
    public boolean placeO(int row, int col){
        if(board[row][col] == EMPTY){
            board[row][col] = Y;
            return true;
        }
        return false;
    }
    
    public void drawBoard(){
        for (int i = 0; i < SIZE; i++) {
            String line = "";
            for (int j = 0; j < SIZE; j++) {
                line += " ";
                switch(board[i][j]){
                    case X: line += "X";
                            break;
                    case Y: line += "O";
                            break;
                    default: line += " ";
                            break;
                }
                if (j != SIZE - 1) {
                    line += " |";
                }
            }
            System.out.println(line);
            if (i != SIZE - 1) {
                System.out.println("--- --- ---");
            }
        }
     System.out.println("");
    }
    
    public boolean validInput(int row, int col){
        if(row >= SIZE || col >= SIZE){
            return false;
        } else if(row < 0 || col < 0){
            return false;
        } else if(get(row,col) != EMPTY){
            return false;
        }
        return true;
    }
    
    public int get(int row, int col){
        return board[row][col];
    }
    
    public boolean checkForWin(){
        boolean rowWins = checkRowWins();
        boolean colWins = checkColWins();
        if(rowWins){
            return rowWins;
        } else if(colWins){
            return colWins;
        }
        return false;
    }
    
    public boolean checkRowWins(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] != board[i][0] || board[i][j] == EMPTY){
                    break;
                }
                if(j == SIZE - 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkColWins(){
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(board[j][i] != board[0][i] || board[i][j] == EMPTY){
                    break;
                }
                if(j == SIZE - 1){
                    return true;
                }
            }
        }
        return false;
    }
    
    private int countFreeSpaces(){
        int count = 0;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                if(board[i][j] == EMPTY){
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isBoardFull(){
        return countFreeSpaces() == EMPTY;
    }
}