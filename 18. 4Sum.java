import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set set=new HashSet();
        ArrayList<Integer> al;
        Arrays.sort(nums);
        int l,r,temp;
        ArrayList<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<=nums.length-4;i++){
            for(int j=i+1;j<=nums.length-3;j++){
                temp=nums[i]+nums[j];
                l=j+1;
                r=nums.length-1;
                while(l<r){
                    if(temp+nums[l]+nums[r]==target){
                        al=new ArrayList<>();
                        al.add(nums[i]);
                        al.add(nums[j]);
                        al.add(nums[l]);
                        al.add(nums[r]);
                        set.add(al);
                        r--;
                    }
                    else{
                        if(temp+nums[l]+nums[r]>target){
                            r--;
                        }
                        else{
                            l++;
                        }
                    }
                }
            }
        }
        for(Object k:set){
            ans.add((ArrayList<Integer>)(k));
        }
        return ans;
    }
}
