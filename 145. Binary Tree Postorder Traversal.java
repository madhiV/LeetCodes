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
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        if(root==null){
            return al;
        }
        stack.push(root);
        TreeNode p;
        while(!stack.isEmpty()){
            p=stack.pop();
            al.add(0,p.val);
            if(p.left!=null){
                stack.push(p.left);
            }
            if(p.right!=null){
                stack.push(p.right);
            }
        }
        return al;
    }
}
