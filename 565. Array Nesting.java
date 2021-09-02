class Solution {
    public int arrayNesting(int[] nums) {
        int max=0,count;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,computeLargestSet(i,nums));
        }
        return max;
    }
    private int computeLargestSet(int index,int[] nums){
        if(index==nums.length  || nums[index]==-1){
            return 0;
        }
        int val=nums[index];
        nums[index]=-1;
        return 1+computeLargestSet(val,nums);
    }
}
