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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode evenPrev,evenFirst,p,oddPrev,temp;
        evenPrev=evenFirst=oddPrev=null;
        p=head;
        while(p!=null){
            temp=p;
            p=p.next;
            temp.next=null;
            if(oddPrev==null){
                head=temp;
                oddPrev=temp;
            }
            else{
                oddPrev.next=temp;
                oddPrev=temp;
            }
            if(p==null){
                continue;
            }
            //Even List
            temp=p;
            p=p.next;
            temp.next=null;
            if(evenPrev==null){
                evenPrev=evenFirst=temp;
            }
            else{
                evenPrev.next=temp;
                evenPrev=temp;
            }
        }
        oddPrev.next=evenFirst;
        return head;
    }
}
