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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        int[] count=new int[1];
        Queue<TreeNode> q=new LinkedList<>();
        int size;
        TreeNode p;
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();
            while(size-->0){
                p=q.poll();
                computeCount(p,p.val,targetSum,count);
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
            }
        }
        return count[0];
    }
    public void computeCount(TreeNode root,int sum,int target,int[] count){
        if(sum==target){
            count[0]++;
        }
        if(root==null){
            return;
        }
        if(root.left!=null){
            computeCount(root.left,sum+root.left.val,target,count);
        }
        if(root.right!=null){
            computeCount(root.right,sum+root.right.val,target,count);
        }
    }
}
