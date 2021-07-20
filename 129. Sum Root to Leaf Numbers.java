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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        findSum(root,0);
        return sum;
    }
    void findSum(TreeNode root,int sum){
        if(root.left==null && root.right==null){
            this.sum+=(sum*10)+root.val;
            return;
        }
        if(root.left!=null){
            findSum(root.left,sum*10+root.val);
        }
        if(root.right!=null){
            findSum(root.right,sum*10+root.val);
        }
    }
}
