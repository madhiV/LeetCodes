class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int[][] down=new int[matrix.length][matrix[0].length];
        int[][] right=new int[matrix.length][matrix[0].length];
        int temp=0,max=0,l,b;
        //storing down
        for(int j=matrix[0].length-1;j>=0;j--){
            for(int i=matrix.length-1;i>=0;i--){
                if(matrix[i][j]=='1'){
                    temp++;
                }
                else{
                    temp=0;
                }
                down[i][j]=temp;
            }
            temp=0;
        }
        //storing right
        for(int i=0;i<matrix.length;i++){
            for(int j=matrix[0].length-1;j>=0;j--){
                if(matrix[i][j]=='1'){
                    temp++;
                }
                else{
                    temp=0;
                }
                right[i][j]=temp;
            }
            temp=0;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                b=0;
                l=Integer.MAX_VALUE;
                temp=i;
                while(temp<matrix.length){
                    b++;
                    l=Math.min(l,right[temp][j]);
                    max=Math.max(max,l*b);
                    temp++;
                }
            }
        }
        return max;
    }
}
