import java.util.*;
class Solution {
    public int deleteAndEarn(int[] nums) {
        int sum=0,n,p;
        int[] count,dp;
        Map<Integer,Integer> map=new HashMap<>();
        //Sort array...
        Arrays.sort(nums);
        //Storing the count of each element...
        for(int i=0;i<nums.length;i++){
            p=map.getOrDefault(nums[i],0);
            p++;
            map.put(nums[i],p);
        }
        //Finding the length of unique element...
        n=1;
        for(int i=1;i<nums.length;i++){
            if(nums[n-1]==nums[i]){
                continue;
            }
            nums[n]=nums[i];
            n++;
        }
        //Storing the frequency of each element...
        count=new int[n];
        for(int i=0;i<n;i++){
            count[i]=map.get(nums[i]);
        }
        //Computing answer...
        dp=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1){
                dp[i]=nums[i]*count[i];
            }
            else if(i==n-2){
                if(nums[i+1]!=nums[i]+1){
                    dp[i]=dp[i+1]+nums[i]*count[i];
                }
                else{
                    dp[i]=Math.max(count[i]*nums[i],dp[i+1]);
                }
            }
            else{
                if(nums[i+1]!=nums[i]+1){
                    dp[i]=dp[i+1]+nums[i]*count[i];
                }
                else{
                    dp[i]=Math.max(count[i]*nums[i]+dp[i+2],dp[i+1]);
                }
            }
        }
        return dp[0];
    }
}
