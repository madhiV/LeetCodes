import java.util.HashMap;
class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer,Integer> prefixSumToIndex=new HashMap<>();
        prefixSumToIndex.put(0,-1);
        storePrefixSums(nums);
        int numsSum=nums[nums.length-1];
        if(numsSum==x){
            return nums.length;
        }
        int reqSum=numsSum-x;
        int largestSALength=-1;
        //Find largest contiguous subarray having sum==reqSum
        for(int index=0;index<nums.length;index++){
            int reqPrefix=nums[index]-reqSum;
            if(prefixSumToIndex.containsKey(reqPrefix)){
                largestSALength=Math.max(index-prefixSumToIndex.get(reqPrefix),largestSALength);
                System.out.println(index+" "+largestSALength);
            }
            prefixSumToIndex.put(nums[index],index);
        }
        return largestSALength==-1?-1:nums.length-largestSALength;
    }
    private void storePrefixSums(int[] nums){
        for(int index=1;index<nums.length;index++){
            nums[index]+=nums[index-1];
        }
    }
}
