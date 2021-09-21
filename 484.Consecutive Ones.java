class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=0){
                nums[i]+=nums[i-1];
                max=Math.max(max,nums[i]);
            }
        }
        return max;
    }
}
