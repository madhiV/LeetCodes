class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0,count,curr;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%3!=0){
            return false;
        }
        count=curr=0;
        sum/=3;
        for(int i=0;i<arr.length;i++){
            curr+=arr[i];
            if(curr==sum){
                count++;
                curr=0;
            }
        }
        return count>2?true:false;
    }
}
