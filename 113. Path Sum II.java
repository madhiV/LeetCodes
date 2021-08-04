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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        int size,temp;
        Queue<Object[]> q=new LinkedList<>();
        Object[] p;
        TreeNode pNode;
        ArrayList<List<Integer>> al=new ArrayList<>();
        ArrayList<Integer> l,pl;
        if(root==null){
            return al;
        }
        l=new ArrayList<>();
        l.add(root.val);
        q.add(new Object[]{root,l});
        while(!q.isEmpty()){
            size=q.size();
            for(int i=0;i<size;i++){
                p=q.poll();
                pNode=(TreeNode)p[0];
                pl=(ArrayList<Integer>)p[1];
                if(pNode.left==null && pNode.right==null && pNode.val==targetSum){
                    al.add(pl);
                }
                if(pNode.left!=null){
                    l=new ArrayList<>(pl);
                    l.add(pNode.left.val);
                    pNode.left.val+=pNode.val;
                    q.add(new Object[]{pNode.left,l});
                }
                if(pNode.right!=null){
                    pl.add(pNode.right.val);
                    pNode.right.val+=pNode.val;
                    q.add(new Object[]{pNode.right,pl});
                }
            }
        }
        return al;
    }
}
