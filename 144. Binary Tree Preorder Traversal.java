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
    ArrayList<Integer> al;
    public List<Integer> preorderTraversal(TreeNode root) {
        al=new ArrayList<>();
        preOrderTraverse(root);
        return al;
    }
    public void preOrderTraverse(TreeNode temp){
        if(temp==null){
            return;
        }
        al.add(temp.val);
        preOrderTraverse(temp.left);
        preOrderTraverse(temp.right);
    }
}
