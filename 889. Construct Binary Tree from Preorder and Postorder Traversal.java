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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer,Integer> map=new HashMap<>();
        int i;
        TreeNode p;
        Stack<TreeNode> s=new Stack<>();
        for(i=0;i<post.length;i++){
            map.put(pre[i],i);
        }
        i=0;
        s.push(new TreeNode(post[i]));
        i++;
        while(!s.isEmpty()){
            if(i==post.length){
                return s.pop();
            }
            p=new TreeNode(post[i]);
            if(map.get(s.peek().val)>map.get(post[i])){
                p.right=s.pop();
                if(!s.isEmpty() && map.get(s.peek().val)>map.get(post[i])){
                    p.left=s.pop();
                }
            }
            s.push(p);
            i++;
        }
        return null;
    }
}
