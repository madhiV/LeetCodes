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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q1=new LinkedList<>(),q3,q2;
        TreeNode p;
        ArrayList<Integer> al;
        int flag=0;
        q1.add(root);
        al=new ArrayList<>();
        al.add(root.val);
        ans.add(al);
        while(!q1.isEmpty()){
            q2=new LinkedList<>();
            al=new ArrayList<>();
            flag=0;
            while(!q1.isEmpty()){
                p=q1.poll();
                if(p.left!=null){
                    q2.add(p.left);
                    al.add(p.left.val);
                    flag=1;
                }
                if(p.right!=null){
                    al.add(p.right.val);
                    q2.add(p.right);
                    flag=1;
                }
            }
            if(flag==1){
                ans.add(0,al);
            }
            q1=q2;
        }
        return ans;
    }
}
