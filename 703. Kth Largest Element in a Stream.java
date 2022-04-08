import java.util.*;
class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        while(pq.size()>k){
            pq.remove();
        }
        if(pq.isEmpty()){
            pq.add(Integer.MIN_VALUE);
        }
    }
    
    public int add(int val) {
        if(k!=pq.size()){
            pq.add(val);
            return pq.peek();
        }
        if(pq.peek()<val){
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
