class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums=new int[m+n];
        int i,j,k,temp;
        i=j=k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                nums[k]=nums1[i];
                i++;
            }
            else{
                nums[k]=nums2[j];
                j++;
            }
            k++;
        }
        for(;i<m;i++,k++){
            nums[k]=nums1[i];
        }
        for(;j<n;j++,k++){
            nums[k]=nums2[j];
        }
        for(i=0;i<m+n;i++){
            nums1[i]=nums[i];
        }
    }
}
