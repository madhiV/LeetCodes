/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null){
            return null;
        }
        Node p=head.next,temp;
        temp=head;
        if(head.child!=null){
            head.next=flatten(head.child);
            head.child=null;
            while(temp.next!=null){
                connect(temp);
                temp=temp.next;
            }
        }
        temp.next=flatten(p);
        connect(temp);
        return head;
    }
    public void connect(Node head){
        if(head.next==null){
            return;
        }
        Node p=head.next;
        p.prev=head;
    }
}
