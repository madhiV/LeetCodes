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
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums=nums;
        return constructTree(0,nums.length-1);
    }
    public TreeNode constructTree(int l,int r){
        if(l<=r){
            int mid=(l+r+1)/2;
            TreeNode root=new TreeNode(nums[mid]);
            root.left=constructTree(l,mid-1);
            root.right=constructTree(mid+1,r);
            return root;
        }
        return null;
    }
}
