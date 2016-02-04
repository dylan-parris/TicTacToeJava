package tic.tac.toe.java;

/**
 * @author Dylan Parris
 */
public class Board {
    int[][] board;
    public static final int SIZE = 3;
    public static final int EMPTY = 0;
    public static final int X = 1;
    public static final int Y = -1;
    
    public Board(){
        board = new int[SIZE][SIZE];
        initBoard();
    }
    
    protected final void initBoard(){
        for(int i = 0; i < SIZE; i++){
            for( int j = 0; j < SIZE; j++){
                board[i][j] = EMPTY;
            }
        }
    }
    
    public boolean placeXorO(int[] move, int XorO){
        if(XorO == X){
            return placeX(move);
        } else {
            return placeO(move);
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
        return checkRowWins() || checkColWins() 
                || checkPosDiag() || checkNegDiag();
    }
    
    public boolean checkRowWins(){
        int rowSum;
        for(int i = 0; i < SIZE; i++){
            rowSum = 0;
            for(int j = 0; j < SIZE; j++){
                rowSum+= this.board[i][j];
            }
            if(rowSum == 3*X || rowSum == 3*Y){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkColWins(){
        int colSum;
        for(int i = 0; i < SIZE; i++){
            colSum = 0;
            for(int j = 0; j < SIZE; j++){
                colSum += this.board[j][i];
            }
            if(colSum == 3*X || colSum == 3*Y){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkPosDiag(){
        int diagSum = 0;
        for(int i = 0; i < SIZE; i++){
            diagSum += this.board[i][i];
        }
        return diagSum == 3*X || diagSum == 3*Y;
    }
    
    public boolean checkNegDiag(){
        int diagSum = 0;
        for(int i = 0; i< SIZE; i++){
            diagSum += this.board[i][(SIZE - 1) - i];
        }
        return diagSum == 3*X || diagSum == 3*Y;
    }
    
    private int countEmptySpaces(){
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
        return countEmptySpaces() == 0;
    }
}