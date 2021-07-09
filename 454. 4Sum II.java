import java.util.*;
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        //insering all the 2 sums of nums4,nums3 into map 
        for(int i=0;i<nums3.length;i++){
            for(int j=0;j<nums4.length;j++){
                if(map.containsKey(nums3[i]+nums4[j])){
                    map.put(nums3[i]+nums4[j],map.get(nums3[i]+nums4[j])+1);
                }
                else{
                    map.put(nums3[i]+nums4[j],1);
                }
            }
        }
        //finding four sum
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(map.containsKey(-(nums1[i]+nums2[j]))){
                    count+=map.get(-(nums1[i]+nums2[j]));
                }
            }
        }
        return count;
    }
}
