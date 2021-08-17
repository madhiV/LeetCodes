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
    private int count;
    public int goodNodes(TreeNode root) {
        count=0;
        computeCount(root,Integer.MIN_VALUE);
        return count;
    }
    private void computeCount(TreeNode root,int max){
        if(root==null){
            return;
        }
        if(root.val>=max){
            count++;
        }
        max=Math.max(max,root.val);
        computeCount(root.left,max);
        computeCount(root.right,max);
    }
}
