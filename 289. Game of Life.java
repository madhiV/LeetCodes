class Solution {
    public int[][] direction=new int[][]{{1,0},{0,1},{0,-1},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};
    public void gameOfLife(int[][] board) {
        //Finding next state for live cells...
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    continue;
                }
                if(!canLive(board,i,j)){
                    board[i][j]=-1;
                }
            }
        }
        //Finding next state for dead cells...
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==1 || board[i][j]==-1){
                    continue;
                }
                if(canLive(board,i,j)){
                    board[i][j]=-2;
                }
            }
        }
        //Filling deads...
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==-1){
                    board[i][j]=0;
                }
                else if(board[i][j]==-2){
                    board[i][j]=1;
                }
            }
        }
    }
    public boolean canLive(int[][] board,int i,int j){
        int neighborsAlive=0;
        //Counting number of neighbors...
        for(int[] k:direction){
            int x=k[0]+i;
            int y=k[1]+j;
            if(x==-1 || y==-1 || x==board.length || y==board[0].length || board[x][y]==0){
                continue;
            }
            if(board[x][y]==-1 || board[x][y]==1){
                    neighborsAlive++;
            }            
        }
        if(board[i][j]==1){
            if(neighborsAlive<2 || neighborsAlive>3){
                return false;
            }
            return true;
        }
        else{
            if(neighborsAlive==3){
                return true;
            }
            return false;
        }
    }
}
