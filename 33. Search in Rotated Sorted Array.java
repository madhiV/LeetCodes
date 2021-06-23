class Solution {
    int search_(int[] nums,int target,int l,int r){
        int mid;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        //Find max
        int mid,r,l,max=nums[0],index=0;
        l=0;
        r=nums.length-1;
        while(l<=r){
            mid=(l+r)/2;
            if(nums[mid]<max){
                r=mid-1;
                index=r;
            }
            else{
                l=mid+1;
            }
        }
        l=search_(nums,target,0,index);
        r=search_(nums,target,index+1,nums.length-1);
        if(l!=-1){
            return l;
        }
        if(r!=-1){
            return r;
        }
        return -1;
    }
}
