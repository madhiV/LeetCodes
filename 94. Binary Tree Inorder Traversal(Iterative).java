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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> al=new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        if(root==null){
            return al;
        }
        TreeNode p;
        s.push(root);
        while(!s.isEmpty()){            
            if(s.peek().left!=null){
                s.push(s.peek().left);
            }
            else{
                p=s.pop();
                al.add(p.val);
                if(p.right!=null){
                    s.push(p.right);
                }
                else {
                    while(!s.isEmpty() ){
                        p=s.pop();
                        al.add(p.val);
                        if(p.right!=null){
                            s.push(p.right);
                            break;
                        }
                    }
                }
            }
        }
        return al;
    }
}
