import java.util.*;
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int temp,sum=0,included=0;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            sum+=nums[i];
        }
        ArrayList<Integer> al=new ArrayList<>();
        while(included<=sum && !pq.isEmpty()){
            temp=pq.poll();
            al.add(temp);
            included+=temp;
            sum-=temp;
        }
        return al;
    }
}
