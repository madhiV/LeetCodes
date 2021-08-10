class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
            min=Integer.MAX_VALUE;
                //Left up
                if(j!=0){
                    min=Math.min(min,matrix[i-1][j-1]);
                }
                //Up
                min=Math.min(min,matrix[i-1][j]);
                //Right up
                if(j!=matrix.length-1){
                    min=Math.min(min,matrix[i-1][j+1]);
                }
                matrix[i][j]+=min;
            }            
        }
        min=Integer.MAX_VALUE;
        for(int i=matrix.length-1,j=0;j<matrix.length;j++){
            min=Math.min(min,matrix[i][j]);
        }
        return min;
    }
}
