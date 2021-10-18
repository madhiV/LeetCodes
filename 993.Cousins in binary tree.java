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
import java.util.*;
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        int size,flag=0;
        TreeNode p;
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();
            flag=0;
            for(int i=0;i<size;i++){
                p=q.poll();
                if((p.left!=null && p.right!=null) &&( (p.left.val==x &&  p.right.val==y) || (p.left.val==y && p.right.val==x))){
                    return false;
                }
                if(p.val==x || p.val==y){
                    flag++;
                }
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
            if(flag==2){
                return true;
            }
        }
        return false;
    }
}
