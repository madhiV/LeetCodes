/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class PQ implements Comparable<PQ>{
    ListNode data;
    PQ(ListNode a){
        data=a;
    }
    @Override
    public int compareTo(PQ o){
        if(data.val > o.data.val){
            return 1;
        }
        return -1;
    }
}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<PQ> pq=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(new PQ(lists[i]));
            }
        }
        ListNode ans=null,temp=ans,p;
        while(!pq.isEmpty()){
            p=pq.poll().data;
            if(p.next!=null){
                pq.add(new PQ(p.next));
            }
            if(ans==null){
                ans=temp=new ListNode(p.val);
            }
            else{
                temp.next=new ListNode(p.val);
                temp=temp.next;
            }
        }
        return ans;
    }
}
