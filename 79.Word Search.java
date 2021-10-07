class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0) && isPresent(board,i,j,word,1,dir)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isPresent(char[][] board,int i,int j,String word,int index,int[][] dir){
        if(index==word.length()){
            return true;
        }
        char prev=board[i][j];
        board[i][j]='.';
        int x,y;
        for(int[] k:dir){
            x=k[0]+i;
            y=k[1]+j;
            if(y==-1 || x==-1 || x==board.length || y==board[0].length || board[x][y]!=word.charAt(index)){
                continue;
            }
            if(isPresent(board,x,y,word,index+1,dir)){
                return true;
            }
        }
        board[i][j]=prev;
        return false;
    }
}
