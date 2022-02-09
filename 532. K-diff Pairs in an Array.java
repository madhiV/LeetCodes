import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        int p,count=0,t;
        //Putting into map...
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=nums.length-1;i>=0;i--){
            if(set.contains(nums[i])){
                continue;
            }
            map.put(nums[i],map.get(nums[i])-1);
            if(k==0){
                if(!set.contains(nums[i])){
                    p=map.getOrDefault(nums[i],0);
                    if(p!=0){
                        count++;
                    }
                }
                set.add(nums[i]);
                continue;
            }
            t=nums[i]-k;
            if(!set.contains(t)){
                p=map.getOrDefault(t,0);
                if(p!=0){
                    count++;
                }
            }
            t=nums[i]+k;
            if(!set.contains(t)){
                p=map.getOrDefault(t,0);
                if(p!=0){
                    count++;
                }
            }
            set.add(nums[i]);
        }
        return count;
    }
}
