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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count,size;
        ListNode n,p,prev,aprev,ans,temp;
        aprev=p=prev=ans=null;
        size=0;
        temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        temp=head;
        size-=(size%k);
        count=0;
        while(count<=size){
            if(count%k==0){
                if(ans==null){
                    ans=p;
                    aprev=prev;
                }
                else{
                    aprev.next=p;
                    aprev=prev;
                }
            }
            if(count==size){
                prev.next=temp;
                break;
            }
           // else{
                n=temp;
                temp=temp.next;
                n.next=p;
                p=n;
                if(count%k==0){
                    prev=p;
                }
                count++;
            //}
        }
        return ans;
    }
}
