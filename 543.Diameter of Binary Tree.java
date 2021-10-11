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
    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        max=0;
        computeDiameter(root);
        return max;
    }
    private int computeDiameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left,right;
        left=computeDiameter(root.left);
        right=computeDiameter(root.right);
        max=Math.max(max,right+left);
        return Math.max(right,left)+1;
    }
}
