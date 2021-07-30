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
    public ListNode swapNodes(ListNode head, int k) {
        int temp,count=1;
        ListNode a,curr;
        curr=head;
        //Finding left node
        while(count!=k){
            count++;
            curr=curr.next;
        }
        a=curr;
        //Finding size of the list
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        count--;
        curr=head;
        temp=1;
        while(temp!=count-k+1){
            temp++;
            curr=curr.next;
        }
        temp=a.val;
        a.val=curr.val;
        curr.val=temp;
        return head;
    }
}
