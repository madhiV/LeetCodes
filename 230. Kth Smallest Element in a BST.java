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
    private int kthSmallest;
    public int kthSmallest(TreeNode root, int k) {
        findKthSmallest(root,0,k);
        return kthSmallest;
    }
    public int findKthSmallest(TreeNode root,int currCount,int k){
        if(root==null){
            return currCount;
        }
        int count=findKthSmallest(root.left,currCount,k);
        count++;
        if(count==k){
            kthSmallest=root.val;
        }
        return findKthSmallest(root.right,count,k);
    }
}
