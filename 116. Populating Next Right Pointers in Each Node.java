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

class Solution {
    public Node connect(Node root) {
        int size;
        Node p;
        Queue<Node> q=new LinkedList<>();
        if(root==null){
            return null;
        }
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();
            for(int i=0;i<size;i++){
                p=q.poll();
                if(p.left!=null){
                    q.add(p.left);
                    q.add(p.right);
                }
                if(i==size-1){
                    break;
                }
                p.next=q.peek();
            }
        }
        return root;
    }
}
