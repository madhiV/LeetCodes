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
    public TreeNode root;
    public TreeNode deleteNode(TreeNode root, int key) {
        this.root=root;
        findAndDelete(root,null,key);
        return this.root;
    }
    public void findAndDelete(TreeNode root,TreeNode par,int key){
        if(root==null){
            return;
        }
        if(root.val==key){
            if(root.left==null && root.right==null){//Leaf node
                if(par==null){
                    this.root=null;
                }
                else if(par.left==root){
                    par.left=null;
                }
                else{
                    par.right=null;
                }
            }
            else if(root.left==null && root.right!=null){//Node with only right child
                if(par==null){
                    this.root=root.right;
                }
                else if(par.left==root){
                    par.left=root.right;
                }
                else{
                    par.right=root.right;
                }
            }
            else if(root.left!=null && root.right==null){//Node with only left child
                if(par==null){
                    this.root=root.left;
                }
                else if(par.left==root){
                    par.left=root.left;
                }
                else{
                    par.right=root.left;
                }
            }
            else{//Node with both left and right child
                deleteParentOfTwoChild(root);
            }
        }
        else if(root.val<key){
            findAndDelete(root.right,root,key);
        }
        else{
            findAndDelete(root.left,root,key);
        }
    }
    public void deleteParentOfTwoChild(TreeNode root){
        TreeNode succ=root.right,p=root;
        while(succ.left!=null){
            p=succ;
            succ=succ.left;
        }
        root.val=succ.val;
        if(p!=root){
            p.left=succ.right;
        }
        else{
            p.right=succ.right;
        }
    }
}
