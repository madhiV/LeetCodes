class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(r*c!=mat.length*mat[0].length){
            return mat;
        }
        int r1,c1;
        r1=0;
        c1=0;
        int[][] transform =new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                transform[i][j]=mat[r1][c1];
                if(c1==mat[0].length-1){
                    r1++;
                    c1=0;
                    continue;
                }
                c1++;
            }
        }
        return transform;
    }
}
