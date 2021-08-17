class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        this.matrix=matrix;
        //First row cells
        for(int i=1,j=0;i<matrix.length;i++){
            matrix[i][j]+=matrix[i-1][j];
        }
        //First col cells
        for(int j=1,i=0;j<matrix[0].length;j++){
            matrix[i][j]+=matrix[i][j-1];
        }
        //Other cells
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                matrix[i][j]+=matrix[i-1][j]+matrix[i][j-1]-matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum,sub;
        sum=matrix[row2][col2];
        //Row calc
        if(row1!=0){
            sum-=matrix[row1-1][col2];
        }
        //Col cal
        if(col1!=0){
            sub=matrix[row2][col1-1];
            if(row1!=0){
                sub-=matrix[row1-1][col1-1];
            }
            sum-=sub;
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
