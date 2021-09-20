import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int[] p;
        int[][] dir=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int level=0,count=0,size,x,y;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        while(!q.isEmpty() && count!=0){
            size=q.size();
            for(int i=0;i<size;i++){
                p=q.poll();
                for(int[] k:dir){
                    x=k[0]+p[0];
                    y=k[1]+p[1];
                    if(x==-1 || y==-1 || x==grid.length || y==grid[0].length || grid[x][y]!=1){
                        continue;
                    }
                    grid[x][y]=2;
                    q.add(new int[]{x,y});
                    count--;
                }
            }
            level++;
        }
        if(count==0){
            return level;
        }
        return -1;
    }
}
