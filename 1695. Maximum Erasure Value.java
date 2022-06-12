import java.util.HashSet;
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i=0,j=0,sum=0,maxSum=0;
        HashSet<Integer> includedElements=new HashSet<>();
        while(j<nums.length){
            while(includedElements.contains(nums[j])){
                sum-=nums[i];
                includedElements.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            includedElements.add(nums[j]);
            maxSum=Math.max(sum,maxSum);
            j++;
        }
        return maxSum;
    }
}
