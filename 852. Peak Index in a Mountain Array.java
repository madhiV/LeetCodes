class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l,r,mid=0;
        l=0;
        r=arr.length-1;
        while(l<=r){
            mid=(l+r+1)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]<arr[mid-1]){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return mid;
    }
}
