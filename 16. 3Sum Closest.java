import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int temp,l,r,ans=-1;
        Arrays.sort(nums);
        long min=Long.MAX_VALUE;
        for(int i=0;i<nums.length-2;i++){
            l=i+1;
            r=nums.length-1;
            while(l<r){
                temp=nums[i]+nums[l]+nums[r];
                if((long)(Math.abs(temp-target))<min){
                    min=(long)(Math.abs(temp-target));
                    ans=temp;
                }
                if(temp<target){
                    l++;
                }
                else if(temp==target){
                    return target;
                }
                else{
                    r--;
                }
            }
        }
        return (int)ans;
    }
}
