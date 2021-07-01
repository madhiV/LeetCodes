/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans=null;
        findLCA(root,p,q);
        return ans;
    }
    int findLCA(TreeNode temp,TreeNode p,TreeNode q){
        if(temp==null){
            return 0;
        }
        int count=0;
        if(temp==p || temp==q){
            count++;
        }
        count+=findLCA(temp.left,p,q)+findLCA(temp.right,p,q);
        if(count==2 && ans==null){
            ans=temp;
        }
        if(count>0){
            return 1;
        }
        return 0;
    }
}
