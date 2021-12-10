class Solution {
    public Integer[][] dp=null;
    int mod=1000000007;
    public int numTilings(int n) {
        int[][] board=new int[2][n];
        dp=new Integer[n][3];
        return computeCount(board,0);
    }
    public int computeCount(int[][] board,int i){
        if(i==board[0].length){
            return 1;
        }
        int count=0,temp;
        if(board[0][i]==0 && board[1][i]==0){//Both up and down empty...
            if(dp[i][0]!=null){
                return dp[i][0];
            }
            //Vertical domino
            verticalDomino(board,i);
            temp=computeCount(board,i+1);
            count=(count+temp)%mod;
            clearVerticalDominoDown(board,i);
            if(i!=board[0].length-1){
                //1 horizontal domino up
                horizontalDominoUp(board,i);
                temp=computeCount(board,i);
                count=(count+temp)%mod;
                clearHorizontalDominoUp(board,i);
                //tromino1
                if(board[1][i+1]==0){
                    tromino1(board,i);
                    temp=computeCount(board,i+1);
                    count=(count+temp)%mod;
                    clearTromino1(board,i);
                }
                //tromino2
                if(board[0][i+1]==0){
                    tromino2(board,i);
                    temp=computeCount(board,i+1);
                    count=(count+temp)%mod;
                    clearTromino2(board,i);
                }
            }
            dp[i][0]=count;
            return count;
        }
        else if(board[0][i]==0 && board[1][i]==1){//Up alone empty...
            if(dp[i][1]!=null){
                return dp[i][1];
            }
            if(i==board[0].length-1){
                return 0;
            }
            //1 horizontal domino in up
            horizontalDominoUp(board,i);
            if(board[1][i+1]==1){
                temp=computeCount(board,i+2);
                count=(count+temp)%mod;
            }
            else{
                temp=computeCount(board,i+1);
                count=(count+temp)%mod;
            }
            clearHorizontalDominoUp(board,i);
            //tromino3
            if(board[0][i+1]==0 && board[1][i+1]==0){
                tromino3(board,i);
                temp=computeCount(board,i+2);
                count=(count+temp)%mod;
                clearTromino3(board,i);
            }
            dp[i][1]=count;
            return count;
        }
        else{//Down alone empty...
            if(dp[i][2]!=null){
                return dp[i][2];
            }
            if(i==board[0].length-1){
                return 0;
            }
            //1 horizontal domino in down
            horizontalDominoDown(board,i);
            if(board[0][i+1]==1){
                temp=computeCount(board,i+2);
                count=(count+temp)%mod;
            }
            else{
                temp=computeCount(board,i+1);
                count=(count+temp)%mod;
            }
            clearHorizontalDominoDown(board,i);
            //tromino4
            if(board[0][i+1]==0 && board[1][i+1]==0){
                tromino4(board,i);
                temp=computeCount(board,i+2);
                count=(count+temp)%mod;
                clearTromino4(board,i);
                dp[i][2]=count;
            }
            return count;
        }
    }
    public void verticalDomino(int[][] board,int col){
        board[0][col]=1;
        board[1][col]=1;
    }
    public void horizontalDominoUp(int[][] board,int col){
        board[0][col]=1;
        board[0][col+1]=1;
    }
    public void horizontalDominoDown(int[][] board,int col){
        board[1][col]=1;
        board[1][col+1]=1;
    }
    public void tromino1(int[][] board,int col){
        board[0][col]=1;
        board[1][col+1]=1;
        board[1][col]=1;
    }
    public void tromino2(int[][] board,int col){
        board[0][col]=1;
        board[0][col+1]=1;
        board[1][col]=1;
    }
    public void tromino3(int[][] board,int col){
        board[0][col]=1;
        board[1][col+1]=1;
        board[0][col+1]=1;
    }
    public void tromino4(int[][] board,int col){
        board[1][col]=1;
        board[0][col+1]=1;
        board[1][col+1]=1;
    }
    public void clearVerticalDominoDown(int[][] board,int col){
        board[0][col]=0;
        board[1][col]=0;
    }
    public void clearHorizontalDominoUp(int[][] board,int col){
        board[0][col]=0;
        board[0][col+1]=0;
    }
    public void clearHorizontalDominoDown(int[][] board,int col){
        board[1][col]=0;
        board[1][col+1]=0;
    }
    public void clearTromino1(int[][] board,int col){
        board[0][col]=0;
        board[1][col+1]=0;
        board[1][col]=0;
    }
    public void clearTromino2(int[][] board,int col){
        board[0][col]=0;
        board[0][col+1]=0;
        board[1][col]=0;
    }
    public void clearTromino3(int[][] board,int col){
        board[0][col]=0;
        board[1][col+1]=0;
        board[0][col+1]=0;
    }
    public void clearTromino4(int[][] board,int col){
        board[1][col]=0;
        board[0][col+1]=0;
        board[1][col+1]=0;
    }
}
