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
    public ListNode insertionSortList(ListNode head) {
        ListNode temp,p,end;
        int data;
        Stack<ListNode> s=new Stack<>();
        temp=head.next;
        while(temp!=null){
            end=temp.next;
            data=temp.val;
            p=head;
            while(p!=temp){
                s.add(p);
                p=p.next;
            }
            while(!s.isEmpty()){
                if(s.peek().val>data){
                    p=s.pop();
                    p.next=end;
                    end=p;
                }
                else{
                    break;
                }
            }
            p=new ListNode(data);
            p.next=end;
            end=p;
            while(!s.isEmpty()){
                p=s.pop();
                p.next=end;
                end=p;
            }
            head=end;
            temp=temp.next;
        }
        return head;
    }
}
