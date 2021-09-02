class Solution {
    public void rotate(int[][] matrix) {
        int r1,r2,c1,c2,temp1,temp2,n=matrix.length;
        for(int k=0;k<n/2;k++){
            for(int i=0;i<n-1-2*k;i++){
                //Swap 1
                r1=k;
                c1=i+k;
                temp1=matrix[r1][c1];
                r2=c1;
                c2=n-1-r1;
                temp2=matrix[r2][c2];
                matrix[r2][c2]=temp1;
                temp1=temp2;
                
                //Swap 2
                r1=r2;
                c1=c2;
                r2=c1;
                c2=n-r1-1;
                temp2=matrix[r2][c2];
                matrix[r2][c2]=temp1;
                temp1=temp2;
                
                //Swap3
                r1=r2;
                c1=c2;
                r2=c1;
                c2=n-r1-1;
                temp2=matrix[r2][c2];
                matrix[r2][c2]=temp1;
                temp1=temp2;
                
                //Swap4
                r1=r2;
                c1=c2;
                r2=c1;
                c2=n-r1-1;
                temp2=matrix[r2][c2];
                matrix[r2][c2]=temp1;
                temp1=temp2;
                
                //Swap5
                r1=r2;
                c1=c2;
                r2=c1;
                c2=n-r1-1;
                temp2=matrix[r2][c2];
                matrix[r2][c2]=temp1;
            }
        }
    }
}
