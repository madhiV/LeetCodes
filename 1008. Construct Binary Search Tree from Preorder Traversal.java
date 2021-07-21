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
    int i;
    int[] preorder;
    public TreeNode bstFromPreorder(int[] preorder) {
        i=0;
        this.preorder=preorder;
        return construct(0,1000000000);
    }
    public TreeNode construct(int min,int max){
        if(i==preorder.length){
            return null;
        }
        TreeNode p;
        p=null;
        if(preorder[i]<=max && preorder[i]>=min){
            p=new TreeNode(preorder[i]);
            i++;
            p.left=construct(min,preorder[i-1]-1);
            p.right=construct(preorder[i-1]+1,max);
        }
        return p;
    }
}
