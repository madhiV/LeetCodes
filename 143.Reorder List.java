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
    public void reorderList(ListNode head) {
        ListNode p,l1,l2,prev;
        int size=0;
        prev=p=head;
        while(p!=null){
            p=p.next;
            size++;
        }
        size=(size/2)+size%2-1;
        prev=l1=p=head;
        while(size!=0){
            p=p.next;
            size--;
        }
        l2=p.next;
        p.next=null;
        l2=reverse(l2);
        while(l2!=null){
            p=l2;
            l2=l2.next;
            prev=l1;
            l1=l1.next;
            prev.next=p;
            p.next=l1;
        }
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null,p=head;
        while(p!=null){
            head=p;
            p=p.next;
            head.next=prev;
            prev=head;
        }
        return head;
    }
}
