class Solution {
    public boolean checkPossibility(int[] nums) {
        int maxIndex=0;
        int maxElement=nums[0];
        if(isSorted(nums)){
            return true;
        }
        for(int ind=1;ind<nums.length;ind++){
            if(nums[ind]>maxElement){
                maxIndex=ind;
                maxElement=nums[ind];
            }
            else if(nums[ind]!=maxElement){
                nums[maxIndex]=nums[ind];
                if(isSorted(nums)){
                    return true;
                }
                nums[maxIndex]=maxElement;
                nums[ind]=maxElement;
                if(isSorted(nums)){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    private boolean isSorted(int[] nums){
        int maxElement=nums[0];
        int ind=1;
        while(ind<nums.length){
            if(nums[ind]<maxElement){
                return false;
            }
            maxElement=nums[ind];
            ind++;
        }
        return true;
    }
}
