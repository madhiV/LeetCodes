/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public Node connect(Node root) {
        Queue<Node> nodes=new LinkedList<>();
        if(root==null){
            return root;
        }
        nodes.add(root);
        bfsAndConnect(nodes);
        return root;
    }
    private void bfsAndConnect(Queue<Node> nodes){
        if(nodes.size()==0){
            return;
        }
        int size=nodes.size()-1;
        Node prevNode=nodes.poll();
        addChildren(prevNode,nodes);
        while(size-->0){
            Node polledNode=nodes.poll();
            prevNode.next=polledNode;
            prevNode=polledNode;
            addChildren(prevNode,nodes);
        }
        bfsAndConnect(nodes);
    }
    private void addChildren(Node node,Queue<Node> nodes){
        if(node.left!=null){
            nodes.add(node.left);
        }
        if(node.right!=null){
            nodes.add(node.right);
        }
    }
}
