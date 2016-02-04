package tic.tac.toe.java;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dylan
 */
public class AdvancedAI implements Player{

    String name;
    private int gamePeice;
    
    AdvancedAI(){}
    
    AdvancedAI(String n, int gp){
        name = n;
        gamePeice = gp;
    }
    
    @Override
    public int[] makeMove(Board b) {
        //Analyze board
            //Check for blocking move
            int[] move;
            
            //check for winning move
            move = checkFor2InRow(b, gamePeice);
            if(move != null){
                return move;
            }
            move = checkFor2InRow(b,gamePeice*-1);
            if(move != null){
                return move;
            }
            
            //Find best possible move
                //check for winning move
                move = checkFor2InRow(b, gamePeice);
                if(move != null){
                    return move;
                }
                //best move
            NoviceAI temp = new NoviceAI("");
            return temp.makeMove(b);
    }
    
    /*
    * Checks for 2 in a row or column of the given peice
    * using your opponents peice will return the blocking move
    * using your peice it will return a winning move
    */
    private int[] checkFor2InRow(Board b, int peice){
        int row = -1;
        int col = -1;
        int colSum = 0;
        int rowSum = 0;
        for(int i = 0; i < Board.SIZE; i++){
            for(int j = 0; j < Board.SIZE; j++){
                rowSum += b.get(i, j);
                colSum += b.get(j, i);
            }
            if(rowSum == (peice*2)){
                row = i;
                break;
            } else if(colSum == (peice*2)){
                col = i;
                break;
            }
            rowSum = 0;
            colSum = 0;
        }
        
        if(row != -1){
            for(int i = 0; i < Board.SIZE; i++){
                if(b.get(row, i) == 0){
                    int[] move = new int[]{row,i};
                    return move;
                }
            }
        } else if (col != -1){
            for(int i = 0; i < Board.SIZE; i++){
                if(b.get(i, col) == 0){
                    int[] move = new int[]{i,col};
                    return move;
                }
            }
        }
        
        return null;
    }

    @Override
    public int getXorO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setXorO(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
