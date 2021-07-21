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
    Map<Integer,Integer> map;
    Set<TreeNode> set;
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        int count=0,i=0;
        map=new HashMap<>();
        set=new HashSet<>();
        max=0;
        findFreq(root);
        Set<Integer> set=map.keySet();
        for(int k:set){
            if(map.get(k)==max){
                count++;
            }
        }
        int[] arr=new int[count];
        for(int k:set){
            if(map.get(k)==max){
                arr[i]=k;
                i++;
            }
            if(i==count){
                break;
            }
        }
        return arr;
    }
    int findFreq(TreeNode root){
        if(root==null){
            return 0;
        }
        if(set.contains(root)){
            return root.val;
        }
        int sum=0;
        sum+=findFreq(root.left);
        sum+=findFreq(root.right);
        root.val+=sum;
        set.add(root);
        if(map.containsKey(root.val)){
            map.put(root.val,map.get(root.val)+1);
            max=Math.max(max,map.get(root.val));
        }
        else{
            map.put(root.val,1);
            if(max==0){
                max=1;
            }
        }
        return root.val;
    }
}
