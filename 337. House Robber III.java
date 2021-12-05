import java.util.*;
class Solution {
    Set<TreeNode> set;
    public int rob(TreeNode root) {
        set=new HashSet<>();
        return computeMax(root);
    }
    public int computeMax(TreeNode root){
        if(root==null){
            return 0;
        }
        if(set.contains(root)){
            return root.val;
        }
        int temp,max;
        //Exclude
        max=computeMax(root.left)+computeMax(root.right);
        //Include
        temp=root.val;
        if(root.left!=null){
            temp+=computeMax(root.left.left)+computeMax(root.left.right);
        }
        if(root.right!=null){
            temp+=computeMax(root.right.left)+computeMax(root.right.right);
        }
        root.val=Math.max(max,temp);
        set.add(root);
        return root.val;
    }
}
