class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans=0,r,c;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    for(int[] k:dir){
                        r=i+k[0];
                        c=j+k[1];
                        if(r==-1 || c==-1 || r==grid.length || c==grid[0].length || grid[r][c]==0){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
