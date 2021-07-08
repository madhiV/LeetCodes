class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l,r,row=-1,mid;
        l=0;
        r=matrix.length-1;
        while(l<=r){
            mid=(l+r)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            if(matrix[mid][0]<target){
                row=mid;
                l=mid+1;
            }
            else{
                row=mid-1;
                r=mid-1;
            }
        }
        if(row==-1){
            return false;
        }
        l=0;
        r=matrix[0].length-1;
        while(l<=r){
            mid=(l+r)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            if(matrix[row][mid]<target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return false;
    }
}
