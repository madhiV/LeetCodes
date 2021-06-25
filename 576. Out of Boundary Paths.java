class Solution {
    Long dp[][][];
    long mod=1000000007;
    long find(int m,int n,int moves,int i,int j){
        if(i<0 || j<0 || i==m || j==n){
            return 1;
        }
        if(moves==0){
            return 0;
        }
        long count=0;
        if(dp[i][j][moves]==null){
            count=find(m,n,moves-1,i,j-1)%mod;
            count=(count+find(m,n,moves-1,i,j+1)%mod);
            count=(count+find(m,n,moves-1,i+1,j)%mod);
            count=(count+find(m,n,moves-1,i-1,j)%mod);
            dp[i][j][moves]=count;
        }
        return dp[i][j][moves];
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Long[m][n][maxMove+1];
        return (int)(find(m,n,maxMove,startRow,startColumn)%mod);
    }
}
