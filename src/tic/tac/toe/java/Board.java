package tic.tac.toe.java;

/**
 * @author Dylan Parris
 */
public class Board {
    int[][] board;
    int size;
    
    
    public Board(){
        size = 3;
        board = new int[size][size];
        initBoard();
    }
    
    protected final void initBoard(){
        for(int i = 0; i < size; i++){
            for( int j = 0; j < size; j++){
                board[i][j] = 0;
            }
        }
    }
    
    public boolean placeX(int row, int col){
        if(board[row][col] == 0){
            board[row][col] = 1;
            return true;
        }
        return false;
    }
    
    public boolean placeO(int row, int col){
        if(board[row][col] == 0){
            board[row][col] = 2;
            return true;
        }
        return false;
    }
    
    public void drawBoard(){
        for (int i = 0; i < size; i++) {
            String line = "";
            for (int j = 0; j < size; j++) {
                line += " ";
                switch(board[i][j]){
                    case 1: line += "X";
                            break;
                    case 2: line += "O";
                            break;
                    default: line += " ";
                            break;
                }
                if (j != size - 1) {
                    line += " |";
                }
            }
            System.out.println(line);
            if (i != size - 1) {
                System.out.println("--- --- ---");
            }
        }
     System.out.println("");
    }
    
    public int get(int row, int col){
        return board[row][col];
    }
    
    public int checkForWin(){
        int rowWins = checkRowWins();
        int colWins = checkColWins();
        if(rowWins != 0){
            return rowWins;
        } else if(colWins != 0){
            return colWins;
        }
        return 0;
    }
    
    public int checkRowWins(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] != board[i][0]){
                    break;
                }
                if(j == size - 1){
                    return board[i][j];
                }
            }
        }
        return 0;
    }
    
    public int checkColWins(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[j][i] != board[0][i]){
                    break;
                }
                if(j == size - 1){
                    return board[j][i];
                }
            }
        }
        return 0;
    }
    
    private int countFreeSpaces(){
        int count = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(board[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean isBoardFull(){
        return countFreeSpaces() == 0;
    }
}