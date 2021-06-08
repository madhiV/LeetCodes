class Solution {
    public int findKthLargest(int[] nums, int k) {
        quicksort(nums,0,nums.length);
        int count=1,ans=nums[0];
        for(int i=1;i<nums.length;i++){
                count++;
                if(count==k){
                    ans=nums[i];
                    break;
                }
        }
        return ans;
    }
    public void quicksort(int[] arr,int l,int r){
        if(l<r){
            int j=partition(arr,l,r);
            quicksort(arr,l,j);
            quicksort(arr,j+1,r);
        }        
    }
    public int partition(int[] arr,int l,int r){
        int i,j,k=(l+r)/2;
        int pivot=arr[k];
        arr[k]=arr[l];
        arr[l]=pivot;
        i=l;
        j=r;
        while(i<j){
            do{
                i++;
            }while(i<j && arr[i]>=pivot);
            do{
                j--;
            }while(j>0 && arr[j]<pivot);
            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,l,j);
        return j;
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
