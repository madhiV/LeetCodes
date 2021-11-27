class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer=new int[nums.length];
        int temp,curr=1;
        //Prefix
        for(int i=0;i<nums.length;i++){
            temp=nums[i];
            answer[i]=curr;
            curr*=temp;
        }
        curr=1;
        //Postfix
        for(int i=nums.length-1;i>=0;i--){
            temp=nums[i];
            answer[i]*=curr;
            curr*=temp;
        }
        return answer;
    }
}
