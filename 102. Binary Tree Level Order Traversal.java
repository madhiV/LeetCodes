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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new LinkedList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        ArrayList<List<Integer>> al=new ArrayList<>();
        ArrayList<Integer> l;
        TreeNode p;
        int size;
        while (!q.isEmpty()){
            size=q.size();
            l=new ArrayList<>();
            for(int i=0;i<size;i++){
                p=q.poll();
                l.add(p.val);
                if(p.left!=null){
                    q.add(p.left);
                }
                if (p.right!=null){
                    q.add(p.right);
                }
            }
            al.add(l);
        }
        return al;
    }
}
