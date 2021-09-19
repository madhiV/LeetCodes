class Solution {
    public int sumOfBeauties(int[] nums) {
        int beauty=0,max;
        int[] pre=new int[nums.length];
        int[] post=new int[nums.length];
        max=-1;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            pre[i]=max;
        }
        max=10000000;
        for(int i=nums.length-1;i>=0;i--){
            max=Math.min(max,nums[i]);
            post[i]=max;
        }
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>pre[i-1] && nums[i]<post[i+1]){
                beauty+=2;
            }
            else if(nums[i]>nums[i-1] && nums[i]<nums[i+1]){
                beauty++;
            }
        }
        return beauty;
    }
}
