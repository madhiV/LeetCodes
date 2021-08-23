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
    private Set<Integer> set;
    private ArrayList<Integer> al;
    public boolean findTarget(TreeNode root, int k) {
        set=new HashSet<>();
        al=new ArrayList<>();
        traverse(root);
        for(int K:al){
            if(k-K==K){
                continue;
            }
            if(set.contains(k-K)){
                return true;
            }
        }
        return false;
    }
    private void traverse(TreeNode root){
        if(root==null){
            return;
        }
        set.add(root.val);
        al.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
