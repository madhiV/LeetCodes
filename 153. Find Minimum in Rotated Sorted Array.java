class Solution {
    private int[] nums;
    private int min;
    public int findMin(int[] nums) {
        min=Integer.MAX_VALUE;
        this.nums=nums;
        computeMin(0,nums.length-1);
        return min;
    }
    private void computeMin(int l,int r){
        if(l<=r){
            if(l==r){
                min=Math.min(min,nums[l]);
                return;
            }
            int mid=(l+r)/2;
            computeMin(l,mid);
            computeMin(mid+1,r);
        }
    }
}
