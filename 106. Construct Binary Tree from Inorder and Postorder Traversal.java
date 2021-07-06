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
    Map<Integer,Integer> in;
    Map<Integer,Integer> post;
    int[] inorder,postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        in=new HashMap<>();
        post=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            in.put(inorder[i],i);
        }
        for(int i=0;i<postorder.length;i++){
            post.put(postorder[i],i);
        }
        return construct(0,inorder.length-1,postorder[in.size()-1]);
    }
    TreeNode construct(int l,int r,int data){
        TreeNode n=new TreeNode(data);
        int iPos=in.get(data),pPos=post.get(data),temp;
        if(l<iPos){
            for(int i=pPos-1;i>=0;i--){
                temp=postorder[i];
                if(in.get(temp)<iPos){
                    n.left=construct(l,iPos-1,temp);
                    break;
                }
            }
        }
        if(r>iPos){
            for(int i=pPos-1;i>=0;i--){
                temp=postorder[i];
                if(in.get(temp)>iPos){
                    n.right=construct(iPos+1,r,temp);
                    break;
                }
            }
        }
        return n;
    }
}
