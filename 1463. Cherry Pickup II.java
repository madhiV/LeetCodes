class Solution {
    Integer[][][] dp;
    public int cherryPickup(int[][] grid) {
        int rowCount=grid.length;
        int colCount=grid[0].length;
        dp=new Integer[rowCount][colCount][colCount];
        return findMaxCherries(grid,0,0,colCount-1);
    }
    private int findMaxCherries(int[][] grid,int r,int c1,int c2){
        if(r==grid.length || c1==-1 || c2==-1 || c1==grid[0].length || c2==grid[0].length){
            return 0;
        }
        if(dp[r][c1][c2]!=null){
            return dp[r][c1][c2];
        }
        int prevCherry1=grid[r][c1];
        int cherriesCount=prevCherry1;
        int maxPostCherries=0;
        grid[r][c1]=0;
        cherriesCount+=grid[r][c2];
        //Move both robots to all 3 directions
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                maxPostCherries=Math.max(maxPostCherries,findMaxCherries(grid,r+1,c1+i,c2+j));
            }
        }
        grid[r][c1]=prevCherry1;
        dp[r][c1][c2]=maxPostCherries+cherriesCount;
        return dp[r][c1][c2];
    }
}
