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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        ArrayList<Integer> pre=new ArrayList<>();
        ArrayList<Integer> in=new ArrayList<>();
        for(int x:preorder){
            pre.add(x);
        }
        for(int x:inorder){
            in.add(x);
        }
        int[] next=new int[1];
        next[0]=0;
        return construct(pre,in,pre.get(0),0,pre.size()-1,next);
    }
    TreeNode construct(ArrayList<Integer> pre,ArrayList<Integer> in,int data,int l,int r,int[] next){
        next[0]++;
        TreeNode n=new TreeNode(data);
        if(next[0]>=pre.size() || l==r){
            return n;
        }
        int index=in.indexOf(data);
        int nextIndex=in.indexOf(pre.get(next[0])),nextElement=pre.get(next[0]);
        if(nextIndex<index && nextIndex>=l){
            n.left=construct(pre,in,nextElement,l,index-1,next);
        }
        if(next[0]>=pre.size()){
            return n;
        }
        nextIndex=in.indexOf(pre.get(next[0]));
        nextElement=pre.get(next[0]);
        if(nextIndex<=r && nextIndex>index){
            n.right=construct(pre,in,nextElement,index+1,r,next);
        }
        return n;
    }
}
