class Solution {
    private boolean canPlace(char[][] board,int r,int c,char n){
        //Row
        for(int i=r,j=0;j<9;j++){
            if(board[i][j]==n){
                return false;
            }
        }
        //Column
        for(int j=c,i=0;i<9;i++){
            if(board[i][j]==n){
                return false;
            }
        }
        //Box
        r=r/3;
        c=c/3;
        for(int i=r*3;i<r*3+3;i++){
            for(int j=c*3;j<c*3+3;j++){
                if(board[i][j]==n){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean solve(char[][] board,int r,int c){
        if(r==9 && c==0){
            return true;
        }
        //Already placed
        if(board[r][c]!='.'){
            if(c==8){//Moving next row
                return solve(board,r+1,0);
            }
            else{//Moving next column
                return solve(board,r,c+1);
            }
        }
        boolean flag=false;
        //Not placed
        for(int i=1;i<=9;i++){
            if(canPlace(board,r,c,(char)(i+48))){
                board[r][c]=(char)(i+48);
                if(c==8){//Moving next row
                    flag=solve(board,r+1,0);
                }
                else{//Moving next column
                    flag=solve(board,r,c+1);
                }
            }
            if(flag){
                break;
            }
            board[r][c]='.';
        }
        return flag;
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
}
