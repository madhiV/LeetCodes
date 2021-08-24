class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        for(int i=max;i>=1;i--){
            if(max%i==0 && min%i==0){
                return i;
            }
        }
        return 0;
    }
}
