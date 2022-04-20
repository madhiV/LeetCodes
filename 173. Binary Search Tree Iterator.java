/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private Stack<TreeNode> nodeStack;
    public BSTIterator(TreeNode root) {
        nodeStack=new Stack<>();
        addLefts(root);
    }
    
    public void addLefts(TreeNode root){
        while(root!=null){
            nodeStack.add(root);
            root=root.left;
        }
    }
    public int next() {
        TreeNode popedNode=nodeStack.pop();
        addLefts(popedNode.right);
        return popedNode.val;
    }
    
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
