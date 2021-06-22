class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        if(nums.length==1){
            return;
        }
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    void reverse(int[] nums,int l,int r){
        int temp;
        while(l<r){
            temp=nums[r];
            nums[r]=nums[l];
            nums[l]=temp;
            l++;
            r--;
        }
    }
}
