class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int r=k;
        k=k%((grid.length*2)+(grid[0].length*2)-4);
        int right,left,up,down,i,j,temp;
        right=grid[0].length-1;
        up=0;
        down=grid.length-1;
        left=0;
        for(int l=0;l<Math.min(grid[0].length,grid.length)/2;l++){
        k=r%((down-up+1)*2+(right-left+1)*2-4);
        for(int z=0;z<k;z++){//Rotations
            //Left
            for(i=up,j=left+1;j<=right;j++){
                temp=grid[i][j];
                grid[i][j]=grid[i][j-1];
                grid[i][j-1]=temp;
            }
            //Down 
            for(i=up+1,j=right;i<=down;i++){
                temp=grid[i][j];
                grid[i][j]=grid[i-1][j];
                grid[i-1][j]=temp;
            }
            //Left
            for(i=down,j=right-1;j>=left;j--){
                temp=grid[i][j+1];
                grid[i][j+1]=grid[i][j];
                grid[i][j]=temp;
            }
            //Up
            for(i=down-1,j=left;i>up;i--){
                temp=grid[i][j];
                grid[i][j]=grid[i+1][j];
                grid[i+1][j]=temp;
            }
        }
        up++;
        left++;
        right--;
        down--;
        }
        return grid;
    }
}
