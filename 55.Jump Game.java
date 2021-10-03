class Solution {
    public boolean canJump(int[] nums) {
        int curr=0;
        for(int i=0;i<nums.length;i++){
            curr=Math.max(curr,nums[i]);
            if(curr==0 && nums.length-1!=i){
                return false;
            }
            curr--;
        }
        return true;
    }
}
