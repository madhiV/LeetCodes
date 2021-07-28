/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int lvl=0,size;
        Node p;
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            lvl++;
            size=q.size();
            for(int i=0;i<size;i++){
                p=q.poll();
                for(Node k:p.children){
                    q.add(k);
                }
            }
        }
        return lvl;
    }
}
