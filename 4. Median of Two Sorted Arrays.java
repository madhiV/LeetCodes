class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int low,high,l1,l2,r1,r2,cut1,cut2,n=nums1.length+nums2.length;
        low=0; 
        high=nums1.length;
        while(low<=high){
            cut1=(low+high)/2;
            cut2=n/2-cut1;
            l1=cut1==0? Integer.MIN_VALUE:nums1[cut1-1];
            l2=cut2==0? Integer.MIN_VALUE:nums2[cut2-1];
            r1=cut1==nums1.length? Integer.MAX_VALUE:nums1[cut1];
            r2=cut2==nums2.length? Integer.MAX_VALUE:nums2[cut2];
            if(l1<=r2 && l2<=r1){
                if(n%2==0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else{
                    return Math.min(r1,r2);
                }
            }
            if(l1<r2){
                low=cut1+1;
            }
            else{
                high=cut1-1;
            }
        }
        return 0.0;
    }
}
