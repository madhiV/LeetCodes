class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        computeMax(nums.length-3,nums);
        return Math.max(nums[0],nums[1]);
    }
    private void computeMax(int i,int[] nums){
        if(i<0){
            return;
        }
        if(i==nums.length-3){
            nums[i]+=nums[i+2];
        }
        else{
            nums[i]+=Math.max(nums[i+3],nums[i+2]);
        }
        computeMax(i-1,nums);
    }
}
