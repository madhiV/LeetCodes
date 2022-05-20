class Solution {
    private Integer[][] uniquePaths;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        uniquePaths=new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return findUniquePaths(0,0,obstacleGrid);
    }
    private int findUniquePaths(int row,int col,int[][] grid){
        if(grid[row][col]==1){
            return 0;
        }
        if(row==grid.length-1 && col==grid[0].length-1){
            if(grid[row][col]==1){
                return 0;
            }
            return 1;
        }
        if(uniquePaths[row][col]!=null){
            return uniquePaths[row][col];
        }
        uniquePaths[row][col]=0;
        //Right
        if(col!=grid[0].length-1){
            uniquePaths[row][col]+=findUniquePaths(row,col+1,grid);
        }
        //Down
        if(row!=grid.length-1){
            uniquePaths[row][col]+=findUniquePaths(row+1,col,grid);
        }
        return uniquePaths[row][col];
    }
}
