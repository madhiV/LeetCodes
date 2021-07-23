import java.util.*;
class Solution {
    public int partitionDisjoint(int[] nums) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int max,count;
        count=1;
        max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for(int i=1;i<nums.length;i++){
            if(map.floorKey(max)==null){
                break;
            }
            max=Math.max(max,nums[i]);
            if(map.get(nums[i])==1){
                map.remove(nums[i]);
            }
            else{
                map.put(nums[i],map.get(nums[i])-1);
            }
            count++;
        }
        return count;
    }
}
