**Time complexity---> O(N^2)**
*Find left index then find right index then return ....Thats it...!!!*
```
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int mid,left,right,l,r;
        left=right=-1;
        l=0;
        r=nums.length-1;
        //Left
        while(l<=r){
            mid=(r+l+1)/2;
            if(nums[mid]==target){
                left=mid;
            }
            if(nums[mid]>=target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        
        l=0;
        r=nums.length-1;
        //Right
        while(l<=r){
            mid=(r+l+1)/2;
            if(nums[mid]==target){
                right=mid;
            }
            if(nums[mid]<=target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return new int[]{left,right};
    }
}
```
