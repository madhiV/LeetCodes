class Solution {
    public int missingNumber(int[] nums) {
        int arraySum=0;
        int requiredSum=(nums.length*(nums.length+1))/2;
        for(int index=0;index<nums.length;index++){
            arraySum+=nums[index];
        }
        return requiredSum-arraySum;
    }
}
