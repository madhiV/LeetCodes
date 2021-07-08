import java.util.*;
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        int max=0;
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j]){
                    if(i-1>=0 && j-1>=0){
                        dp[i][j]=1+dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=1;
                    }
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
