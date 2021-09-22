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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode p,n;
        n=new TreeNode(val);
        if(root==null){
            return n;
        }
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            p=s.pop();
            if(p.val>val){
                if(p.left!=null){
                    s.push(p.left);
                }
                else{
                    p.left=n;
                }
            }
            else{
                if(p.right!=null){
                    s.push(p.right);
                }
                else{
                    p.right=n;
                }
            }
        }
        return root;
    }
}
