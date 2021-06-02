class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0,t;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    t=areaCovered(grid,i,j);
                    if(t>max){
                        max=t;
                    }
                }
            }
        }
        return max;
    }
    public int areaCovered(int[][] grid,int x,int y){
        int sum=1,m,n;
        m=grid.length;
        n=grid[0].length;
        grid[x][y]=0;
        //Right
        if(y+1<n && grid[x][y+1]==1){
            sum+=areaCovered(grid,x,y+1);    
        }
        //Left
        if(y-1>=0 && grid[x][y-1]==1){
            sum+=areaCovered(grid,x,y-1);
        }
        //Up
        if(x-1>=0 && grid[x-1][y]==1){
            sum+=areaCovered(grid,x-1,y);
        }
        //Down
        if(x+1<m && grid[x+1][y]==1){
            sum+=areaCovered(grid,x+1,y);
        }
        return sum;
    }
}
