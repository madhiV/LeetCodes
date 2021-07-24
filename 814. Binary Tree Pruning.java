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
    public TreeNode pruneTree(TreeNode root) {
        if (!prune(root)){
            return null;
        }
        return root;
    }
    public boolean prune(TreeNode node){
        if(node==null){
            return false;
        }
        boolean left,right;
        left=prune(node.left);
        right=prune(node.right);
        
        if(left==false){
            node.left=null;
        }
        if(right==false){
            node.right=null;
        }
        if(left==false && right==false && node.val==0){
            return false;
        }
        return true;
    }
}
