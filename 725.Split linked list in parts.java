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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int quotient,remainder,length=0,i;
        ListNode p=null,prev=null,n=null;
        ListNode[] arr=new ListNode[k];
        
        //Finding length
        p=head;
        while(p!=null){
            length++;
            p=p.next;
        }
        p=head;
        quotient=length/k;
        remainder=length%k;
        
        //Case 1 : 
        if(length<=k){
            i=0;
            while(i!=k){
                if(p!=null){
                    arr[i]=p;
                    p=p.next;
                    arr[i].next=null;
                }
                i++;
            }
        }
        
        else {
            i=0;
            while(i!=k){
                n=null;
                for(int j=0;j<quotient;j++){
                    if(n==null){
                        n=p;
                        prev=n;
                    }
                    else{
                        prev.next=p;
                        prev=p;
                    }
                    p=p.next;
                }
                if(remainder>0){
                    prev.next=p;
                    prev=p;
                    p=p.next;
                    remainder--;
                }
                prev.next=null;
                arr[i]=n;
                i++;
            }
        }
        return arr;
    }
}
