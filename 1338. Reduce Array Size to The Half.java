import java.util.*;
class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer,Integer> dic=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(dic.containsKey(arr[i])){
                dic.put(arr[i],dic.get(arr[i])+1);
            }
            else{
                dic.put(arr[i],1);
            }
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        Set<Map.Entry<Integer,Integer>> entry=dic.entrySet();
        for(Map.Entry<Integer,Integer> k:entry){
            pq.add(k.getValue());
        }
        int n=arr.length,count=0;
        while(n>arr.length/2){
            count++;
            n-=pq.poll();
        }
        return count;
    }
}
