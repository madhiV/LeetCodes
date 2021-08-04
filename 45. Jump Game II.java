class Solution {
    public int jump(int[] nums) {
        int min;
        nums[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=nums.length-1){
                nums[i]=1;
            }
            else{
                if(nums[i]==0){
                    nums[i]=Integer.MAX_VALUE;
                }
                else{
                    min=Integer.MAX_VALUE;
                    for(int j=0;j<nums[i];j++){
                        if(nums[i+j+1]==Integer.MAX_VALUE){
                            continue;
                        }
                        min=Math.min(min,1+nums[i+j+1]);
                    }
                    nums[i]=min;
                }
            }
        }
        return nums[0];
    }
}
