class Solution {
    public int maxProduct(int[] nums) {
        int max,product;
        max=product=nums[0];
        if(nums[0]==0){
            product=1;
        }
        for(int i=1;i<nums.length;i++){
            product*=nums[i];
            max=Math.max(product,max);
            if(product==0){
                product=1;
            }
        }
        product=nums[nums.length-1];
        max=Math.max(max,product);
        if(product==0){
            product=1;
        }
        for(int i=nums.length-2;i>=0;i--){
            product*=nums[i];
            max=Math.max(product,max);
            if(product==0){
                product=1;
            }
        }
        return max;
    }
}
