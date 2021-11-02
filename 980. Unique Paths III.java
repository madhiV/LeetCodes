class Solution {
    public int count;
    public int[][] dir=new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int uniquePathsIII(int[][] grid) {
        count=0;
        int[] start=new int[2];
        int[] end=new int[2];
        findStart(grid,start,end);
        computePaths(grid,start[0],start[1],end[0],end[1],0 , (grid.length*grid[0].length)-obstacles(grid));
        return count;
    }
    public void findStart(int[][] grid,int[] start,int[] end){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    start[0]=i;
                    start[1]=j;
                }
                if(grid[i][j]==2){
                    end[0]=i;
                    end[1]=j;
                }
            }
        }
    }
    public int obstacles(int[][] grid){
        int c=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==-1){
                    c++;
                }
            }
        }
        return c;
    }
    public void computePaths(int[][] grid,int i, int j , int e1, int e2 , int w , int nonObstacles){
        int x,y,prev=grid[i][j];
        w++;
        for(int[] k:dir){
            x=i+k[0];
            y=j+k[1];
            if(x==-1 || y==-1 || x==grid.length || y==grid[0].length || grid[x][y]==-1 || grid[x][y]==1){
                continue;
            }
            grid[i][j]=-1;
            computePaths(grid,x,y,e1, e2,w,nonObstacles);
            grid[i][j]=prev;
        }
        if(i==e1 && j==e2 && w==nonObstacles){
            count++;
        }
    }
}
