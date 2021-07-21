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
    String ans="6";
    StringBuilder s;
    public String smallestFromLeaf(TreeNode root) {
        s=new StringBuilder("");
        findSmallest(root);
        return ans;
    }
    void findSmallest(TreeNode root){
        s.insert(0,(char)(root.val+97));
        if(root.left==null && root.right==null){
            if(ans.charAt(0)=='6'){
                ans=s.toString();
            }
            else{
                ans=(ans.compareTo(s.toString())>=0)?s.toString():ans;
            }
            s.deleteCharAt(0);
            return;
        }
        if(root.left!=null){
            findSmallest(root.left);
        }
        if(root.right!=null){
            findSmallest(root.right);
        }
        s.deleteCharAt(0);
    }
}
