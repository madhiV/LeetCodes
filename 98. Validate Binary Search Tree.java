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
    public boolean isValidBST(TreeNode root) {
        return validate(root,Long.MAX_VALUE,Long.MIN_VALUE);    
    }
    public boolean validate(TreeNode p,long max,long min){
        if(p==null){
            return true;
        }
        if(p.val<=max && p.val>=min){
            return validate(p.left,((long)p.val)-1,min) && validate(p.right,max,((long)p.val)+1);
        }
        return false;
    }
}
