class Solution {
    Integer[][] dp=null;
    int m,n;
    public int uniquePaths(int m, int n) {
        dp=new Integer[m][n];
        this.m=m-1;
        this.n=n-1;
        return computeCount(0,0);
    }
    public int computeCount(int x,int y){
        if(x==m && y==n){
            return 1;
        }
        if(dp[x][y]!=null){
            return dp[x][y];
        }
        int count=0;
        if(x!=m){
            count=computeCount(x+1,y);
        }
        if(y!=n){
            count+=computeCount(x,y+1);
        }
        dp[x][y]=count;
        return dp[x][y];
    }
}
