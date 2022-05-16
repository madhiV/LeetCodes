import java.util.Queue;
import java.util.LinkedList;
class Solution {
    private int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{1,-1},{-1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> cells=new LinkedList<>();
        if(grid[0][0]==1){
            return -1;
        }
        cells.add(new int[]{0,0});
        grid[0][0]=1;
        int level=1;
        while(!cells.isEmpty()){
            int size=cells.size();
            while(size-->0){
                int[] firstCell=cells.poll();
                if(firstCell[0]==grid.length-1 && firstCell[1]==grid[0].length-1){
                    return level;
                }
                for(int[] direction:directions){
                    int rowIndex=direction[0]+firstCell[0];
                    int columnIndex=direction[1]+firstCell[1];
                    if(isBoundaryCondition(grid,rowIndex,columnIndex)){
                        continue;
                    }
                    grid[rowIndex][columnIndex]=1;
                    cells.add(new int[]{rowIndex,columnIndex});
                }
            }
            level++;
        }
        return -1;
    }
    private boolean isBoundaryCondition(int[][] grid,int rowIndex,int columnIndex){
        if(rowIndex==-1 || columnIndex==-1 || rowIndex==grid.length || columnIndex==grid[0].length ){
            return true;
        }
        if(grid[rowIndex][columnIndex]==1){
            return true;
        }
        return false;
    }
}
