/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
import java.util.*;
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        int i;
        Map<Integer,Node> map=new HashMap<>();
        Map<Node,Integer> map2=new HashMap<>();
        Node head1,p;
        ArrayList<Integer> al=new ArrayList<>();
        p=head;
        i=0;
        //storing indices of the nodes in original list
        while(p!=null){
            map2.put(p,i);
            i++;
            p=p.next;
        }
        p=head;
        //finding size of the list and storing random index of each node
        while(p!=null){
            if(p.random==null){
                al.add(-1);
            }
            else{
                al.add(map2.get(p.random));
            }
            p=p.next;
        }
        //Creating new list and storing the index of each node in map
        i=1;
        head1=new Node(head.val);
        p=head1;
        map.put(0,p);
        head=head.next;
        while(head!=null){
            p.next=new Node(head.val);
            head=head.next;
            p=p.next;
            map.put(i,p);
            i++;
        }
        //Setting random pointer for each node in new LL
        i=0;
        p=head1;
        while(p!=null){
            if(al.get(i)==-1){
                p.random=null;
            }
            else{
                p.random=map.get(al.get(i));
            }
            p=p.next;
            i++;
        }
        return head1;
    }
}
