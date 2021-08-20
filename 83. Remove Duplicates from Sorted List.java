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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p,prev;
        prev=p=head;
        p=p.next;
        while(p!=null){
            if(p.val==prev.val){
                prev.next=p.next;
            }
            else{
                prev=p;
            }
            p=p.next;
        }
        return head;
    }
}
