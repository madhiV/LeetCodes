import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> countMap=new HashMap<>();
        //Storing count of each element of nums...
        for(int i=0;i<nums.length;i++){
            int count=countMap.getOrDefault(nums[i],0);
            countMap.put(nums[i],++count);
        }
        PriorityQueue<int[]> frequencyPQ=new PriorityQueue<>(
            new Comparator<int[]>(){
                @Override
                public int compare(int[] entry1,int[] entry2){
                    if(entry1[1]<entry2[1]){
                        return 1;
                    }
                    return -1;
                }
            }
        );
        //Adding each unique elements along with its count into frequencyPQ
        for(Integer key:countMap.keySet()){
            frequencyPQ.add(new int[]{key,countMap.get(key)});
        }
        //Storing answer...
        int[] answerArray=new int[k];
        for(int index=0;index<k;index++){
            answerArray[index]=frequencyPQ.poll()[0];
        }
        return answerArray;
    }
}
