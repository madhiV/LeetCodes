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
    public ListNode partition(ListNode head, int x) {
        ListNode part1,part2,part1Prev,part2Prev,p,temp;
        part1=part2=part1Prev=part2Prev=null;
        temp=head;
        while(temp!=null){
            p=temp;
            temp=temp.next;
            p.next=null;
            if(p.val<x){
                if(part1==null){
                    part1=p;
                    part1Prev=p;
                }
                else{
                    part1Prev.next=p;
                    part1Prev=p;
                }
            }
            else{
                if(part2==null){
                    part2=p;
                    part2Prev=p;
                }
                else{
                    part2Prev.next=p;
                    part2Prev=p;
                }
            }
        }
        if(part1==null){
            return part2;
        }
        part1Prev.next=part2;
        return part1;
    }
}
