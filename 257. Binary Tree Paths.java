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
    ArrayList<String> al;
    StringBuilder s;
    public List<String> binaryTreePaths(TreeNode root) {
        al=new ArrayList<>();
        s=new StringBuilder("");
        findPaths(root);
        return al;
    }
    void findPaths(TreeNode root){
        if(root.left==null && root.right==null){
            s.append(root.val);
            al.add(s.toString());
            s.setLength(s.length()-((Integer)root.val).toString().length());
            return;
        }
        s.append(root.val+""+"->");
        if(root.left!=null){
            findPaths(root.left);
        }
        if(root.right!=null){
            findPaths(root.right);
        }
        s.setLength(s.length()-((Integer)root.val).toString().length()-2);
    }
}
