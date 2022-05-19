import java.util.PriorityQueue;
import java.util.LinkedList;
class Solution {
    private int[][] directions=new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        PriorityQueue<int[]> elements=new PriorityQueue<>((a,b)->a[2]-b[2]);
        addMatrixElementsToQueue(matrix,elements);
        int[][] longestPathLength=new int[matrix.length][matrix[0].length];
        updateValuesToOne(longestPathLength);
        for(int cellCount=0;cellCount<matrix.length*matrix[0].length;cellCount++){
            int[] firstElement=elements.poll();
            updateLongestPaths(matrix,longestPathLength,firstElement);
        }
        return longestPathLength(longestPathLength);
    }
    private void addMatrixElementsToQueue(int[][] matrix,PriorityQueue<int[]> elements){
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                elements.add(new int[]{row,col,matrix[row][col]});
            }
        }
    }
    private void updateValuesToOne(int[][] matrix){
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                matrix[row][col]=1;
            }
        }
    }
    private void updateLongestPaths(int[][] matrix,int[][] longestPathLength,int[] element){
        int currRow=element[0];
        int currCol=element[1];
        for(int[] direction:directions){
            int newRow=direction[0]+currRow;
            int newCol=direction[1]+currCol;
            if(isBoundaryCondition(matrix,newRow,newCol)){
                continue;
            }
            if(!isIncreasing(matrix[currRow][currCol],matrix[newRow][newCol])){
                continue;
            }
            int currLongestPath=longestPathLength[currRow][currCol];
            longestPathLength[newRow][newCol]=Math.max(longestPathLength[newRow][newCol],currLongestPath+1);
        }
    }
    private boolean isBoundaryCondition(int[][] matrix,int row,int col){
        if(row==-1 || col==-1 || row==matrix.length || col==matrix[0].length){
            return true;
        }
        return false;
    }
    private int longestPathLength(int[][] matrix){
        int longestPathLength=0;
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                longestPathLength=Math.max(longestPathLength,matrix[row][col]);
            }
        }
        return longestPathLength;
    }
    private boolean isIncreasing(int a,int b){
        return a<b;
    }
}
