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
    private List<Integer> al;
    public List<Integer> inorderTraversal(TreeNode root) {
        al=new ArrayList<>();
        traverse(root);
        return al;
    }
    private void traverse(TreeNode temp){
        if(temp==null){
            return;
        }
        traverse(temp.left);
        al.add(temp.val);
        traverse(temp.right);
    }
}
