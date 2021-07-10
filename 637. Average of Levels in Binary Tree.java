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
    public List<Double> averageOfLevels(TreeNode root) {
        int count,size;
        double sum;
        ArrayList<Double> al=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode p;
        q.add(root);
        while(!q.isEmpty()){
            size=q.size();
            count=0;
            sum=0;
            for(int i=0;i<size;i++){
                p=q.poll();
                sum+=p.val;
                if(p.left!=null){
                    q.add(p.left);
                }
                if(p.right!=null){
                    q.add(p.right);
                }
                count++;
            }
            al.add(sum/count);
        }
        return al;
    }
}
