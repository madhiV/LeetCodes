import java.util.*;
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        k%=(grid.length*grid[0].length);
        while(k-->0){
            shift(grid);
        }
        List<List<Integer>> gridList=new LinkedList<>();
        copyMatrixToList(grid,gridList);
        return gridList;
    }
    public void shift(int[][] grid){
        int prev=grid[grid.length-1][grid[0].length-1];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int temp=grid[i][j];
                grid[i][j]=prev;
                prev=temp;
            }
        }
    }
    public void copyMatrixToList(int[][] grid,List<List<Integer>> gridList){
        for(int i=0;i<grid.length;i++){
            List<Integer> rowList=new LinkedList<>();
            for(int j=0;j<grid[0].length;j++){
                rowList.add(grid[i][j]);
            }
            gridList.add(rowList);
        }
    }
}
