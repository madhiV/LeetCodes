class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int count,curr,prev;
        count=curr=0;
        //Storing differences in nums array...
        for(int i=1;i<nums.length;i++){
            nums[i-1]=nums[i]-nums[i-1];
        }
        prev=nums[nums.length-1]=50000;
        //Computing total arithmetic count...
        for(int i=0;i<nums.length;i++){
            if(nums[i]==prev){
                curr++;
            }
            else{
                count+=computeCount(curr-1);
                prev=nums[i];
                curr=1;
            }
        }
        return count;
    }
    public int computeCount(int n){
        return (n*(n+1))/2;
    }
}
