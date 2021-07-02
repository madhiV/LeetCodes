class Solution {
    Integer[][] memo=null;
    public int minPathSum(int[][] grid) {
        memo=new Integer[grid.length][grid[0].length];
        int ans=findMin(memo,grid,0,0);
        return ans;
    }
    int findMin(Integer[][] memo,int[][] grid,int i,int j){
        if(i==grid.length-1 && j==grid[0].length-1){
            return grid[i][j];
        }
        if(memo[i][j]==null){
            int min=Integer.MAX_VALUE;
            //Right
            if(j+1<grid[0].length){
                min=grid[i][j]+findMin(memo,grid,i,j+1);
            }
            //Down
            if(i+1<grid.length){
                min=Math.min(min,grid[i][j]+findMin(memo,grid,i+1,j));
            }
            memo[i][j]=min;
        }
        return memo[i][j];
    }
}
