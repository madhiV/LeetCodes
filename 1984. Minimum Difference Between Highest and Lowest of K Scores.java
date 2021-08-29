import java.util.*;
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans=Integer.MAX_VALUE,i=0,j=k-1;
        Arrays.sort(nums);
        while(j!=nums.length){
            ans=Math.min(ans,nums[j]-nums[i]);
            j++;
            i++;
        }
        return ans;
    }
}
