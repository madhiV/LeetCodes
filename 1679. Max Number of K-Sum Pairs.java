//Approach 1: using sort
class Solution {
    public int maxOperations(int[] nums, int k) {
        int i=0;
        int j=nums.length-1;
        int pairCount=0;
        Arrays.sort(nums);
        while(i<j){
            if(nums[i]+nums[j]==k){
                pairCount++;
                i++;
                j--;
                continue;
            }
            if(nums[i]+nums[j]>k){
                j--;
            }
            else{
                i++;
            }
        }
        return pairCount;
    }
}
//Approach 2: using hashMap
//import java.util.HashMap;
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         HashMap<Integer,Integer> countMap=new HashMap<>();
//         int pairCount=0;
//         for(int index=0;index<nums.length;index++){
//             int requiredPair=k-nums[index];
//             int requiredPairCount=countMap.getOrDefault(requiredPair,0);
//             if(requiredPairCount>0){
//                 pairCount++;
//                 countMap.put(requiredPair,requiredPairCount-1);
//             }
//             else{
//                 countMap.put(nums[index],countMap.getOrDefault(nums[index],0)+1);
//             }
//         }
//         return pairCount;
//     }
// }
