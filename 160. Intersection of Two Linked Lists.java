/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p;
        Set<ListNode> set=new HashSet<>();
        p=headA;
        while(p!=null){
            set.add(p);
            p=p.next;
        }
        p=headB;
        while(p!=null){
            if(set.contains(p)){
                return p;
            }
            p=p.next;
        }
        return null;
    }
}
