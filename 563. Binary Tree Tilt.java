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
    public int sum;
    public int findTilt(TreeNode root) {
        sum=0;
        computeSum(root);
        return sum;
    }
    public int computeSum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=computeSum(root.left),right=computeSum(root.right);
        root.val+=left+right;
        sum+=Math.abs(left-right);
        return root.val;
    }
}
