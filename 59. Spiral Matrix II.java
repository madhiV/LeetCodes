class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        fillAnswerMatrix(matrix,n);
        return matrix;
    }
    public void fillAnswerMatrix(int[][] matrix,int n){
        int left=0,right=n-1,up=0,down=n-1;
        int i,j;
        int count=1;
        i=j=0;
        while(left<=right && up<=down){
            //Right...
            for(int row=up,column=left;column<=right;column++){
                matrix[row][column]=count;
                count++;
            }
            up++;
            
            //Down...
            for(int row=up,column=right;row<=down;row++){
                matrix[row][column]=count;
                count++;
            }
            right--;
            
            //Left...
            for(int row=down,column=right;column>=left;column--){
                matrix[row][column]=count;
                count++;
            }
            down--;
            
            //Up...
            for(int row=down,column=left;row>=up;row--){
                matrix[row][column]=count;
                count++;
            }
            left++;
        }
    }
}
