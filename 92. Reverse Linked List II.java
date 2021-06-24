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
    public ListNode reverse(ListNode p){
        ListNode t,temp=null;
        while(p!=null){
            t=p;
            p=p.next;
            t.next=temp;
            temp=t;
        }
        return temp;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp,part1,part2,middle,t,end=null;
        int count =1;
        temp=part1=head;
        if(left==1){
            middle=temp;
            temp=middle;
            while(count!=right){
                temp=temp.next;
                count++;
            }
            part2=temp.next;
            temp.next=null;
            middle=reverse(middle);
            temp=middle;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=part2;
            return middle;
        }
        //Left not 1
        while(count!=left){
            end=temp;
            temp=temp.next;
            count++;
        }
        middle=temp;
        temp=middle;
        while(count!=right){
            temp=temp.next;
            count++;
        }
        part2=temp.next;
        temp.next=null;
        middle=reverse(middle);
        end.next=middle;
        temp=middle;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=part2;
        return part1;
    }
}
