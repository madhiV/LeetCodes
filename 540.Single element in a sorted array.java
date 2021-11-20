class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l,r,mid=0,n;
        l=0;
        r=nums.length-1;
        while(l<r){
            mid=(l+r)/2;
            n=nums.length-mid-1;
            if(n%2==0){
                if(nums[mid]!=nums[mid+1]){
                    r=mid;
                }
                else{
                    l=mid+2;
                }
            }
            else{
                if(nums[mid]!=nums[mid+1]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return nums[r];
    }
}
