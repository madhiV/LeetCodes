class Solution {
    int avg;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0){
            return false;
        }
        avg=sum/k;
        return partition(0,0,nums,k,new boolean[nums.length]);
    }
    public boolean partition(int index,int sum,int[] nums,int k,boolean flag[]){
        if(k==1){
            return true;
        }
        if(sum==avg){
            return partition(0,0,nums,k-1,flag);
        }
        for(int i=index;i<flag.length;i++){
            if(!flag[i] && sum+nums[i]<=avg){
                flag[i]=true;
                sum+=nums[i];
                if(partition(i+1,sum,nums,k,flag)){
                    return true;
                }
                sum-=nums[i];
                flag[i]=false;
            }
        }
        return false;
    }
}
