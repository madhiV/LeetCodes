class Solution {
    private int k;
    private int[] nums;
    public int search(int[] nums, int target) {
        k=target;
        this.nums=nums;
        return binSearch(0,nums.length-1);
    }
    private int binSearch(int l,int r){
        if(l<=r){
            int mid=(r+l+1)/2;
            if(nums[mid]==k){
                return mid;
            }
            if(nums[mid]<k){
                return binSearch(mid+1,r);
            }
            else{
                return binSearch(l,mid-1);
            }
        }
        return -1;
    }
}
