class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int min_X=m,min_Y=n;
        for(int i=0;i<ops.length;i++){
            min_X=Math.min(min_X,ops[i][0]);
            min_Y=Math.min(min_Y,ops[i][1]);
        }
        return min_X*min_Y;
    }
}
