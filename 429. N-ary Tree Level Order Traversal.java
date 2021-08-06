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
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> q=new LinkedList<>();
        ArrayList<List<Integer>> al=new ArrayList<>();
        ArrayList<Integer> l;
        int size;
        Node p;
        if(root==null){
            return al;
        }
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();
            l=new ArrayList<>();
            for(int i=0;i<size;i++){
                p=q.poll();
                l.add(p.val);
                for(Node k:p.children){
                    q.add(k);
                }
            }
            al.add(l);
        }
        return al;
    }
}
