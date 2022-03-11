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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int n,count;
        ListNode z,p;
        n=size(head);
        k%=n;
        count=n-k;
        if(k==0){
            return head;
        }
        p=head;
        while(count>1){
            p=p.next;
            count--;
        }
        z=p.next;
        p.next=null;
        p=z;
        while(p.next!=null){
            p=p.next;
        }
        p.next=head;
        return z;
    }
    public int size(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
