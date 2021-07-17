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
    Map<Integer,Integer> map;
    int max;
    public int[] findMode(TreeNode root) {
        int count=0;
        map=new HashMap<>();
        max=0;
        find(root);
        Set<Integer> set=map.keySet();
        for(int k:set){
            if(map.get(k)==max){
                count++;
            }
        }
        int[] arr=new int[count];
        int i=0;
        for(int k:set){
            if(map.get(k)==max){
                arr[i]=k;
                i++;
            }
        }
        return arr;
    }
    public void find(TreeNode root){
        if(root==null){
            return;
        }
        if(map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
            max=Math.max(max,map.get(root.val));
        }
        else{
            map.put(root.val,1);
            max=Math.max(max,1);
        }
        find(root.left);
        find(root.right);
    }
}
