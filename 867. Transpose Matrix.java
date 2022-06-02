class Solution {
    public int[][] transpose(int[][] matrix) {
        int[][] transposeMatrix=new int[matrix[0].length][matrix.length];
        int row=0,column=0;
        for(int ind1=0;ind1<matrix.length;ind1++){
            for(int ind2=0;ind2<matrix[0].length;ind2++){
                transposeMatrix[row][column]=matrix[ind1][ind2];
                row++;
                if(row==transposeMatrix.length){
                    row=0;
                    column++;
                }
            }
        }
        return transposeMatrix;
    }
}
