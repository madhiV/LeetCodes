class Solution {
    private int solutionCount;
    public int totalNQueens(int n) {
        solutionCount=0;
        int[][] chessBoard=new int[n][n];
        computeSolutionCount(chessBoard,0);
        return solutionCount;
    }
    private void computeSolutionCount(int[][] chessBoard,int row){
        if(row==chessBoard.length){
            solutionCount++;
            return;
        }
        for(int column=0;column<chessBoard.length;column++){
            if(isAttackHappening(chessBoard,row,column)){
                continue;
            }
            chessBoard[row][column]=1;
            computeSolutionCount(chessBoard,row+1);
            chessBoard[row][column]=0;
        }        
    }
    private boolean isAttackHappening(int[][] chessBoard,int row,int column){
        //Column
        for(int index=0;index<row;index++){
            if(chessBoard[index][column]==1){
                return true;
            }
        }
        //current to top-up left
        for(int ind1=row-1,ind2=column-1;ind1>=0 && ind2>=0;ind1--,ind2--){
            if(chessBoard[ind1][ind2]==1){
                return true;
            }
        }
        //current to top up right
        for(int ind1=row-1,ind2=column+1;ind1>=0 && ind2<chessBoard.length;ind1--,ind2++){
            if(chessBoard[ind1][ind2]==1){
                return true;
            }
        }
        return false;
    }
}
