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
    ListNode head;
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        reverse(head);
        return this.head;
    }
    ListNode reverse(ListNode head){
        if(head.next==null){
            this.head=head;
            return head;
        }
        ListNode p=reverse(head.next);
        p.next=head;
        head.next=null;
        return head;
    }
}
