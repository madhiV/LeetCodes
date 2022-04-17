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
    public TreeNode convertBST(TreeNode root) {
        convertGreaterTree(root,0);
        return root;
    }
    public int convertGreaterTree(TreeNode root,int prevGreaterSum){
        if(root==null){
            return prevGreaterSum;
        }
        root.val+=convertGreaterTree(root.right,prevGreaterSum);
        return convertGreaterTree(root.left,root.val);
    }
}
