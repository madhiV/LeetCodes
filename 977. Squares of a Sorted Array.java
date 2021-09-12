class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr=new int[nums.length];
        int k=0,end=-1,i;
        for(i=0;i<nums.length;i++){
            if(nums[i]<0){
                end=i;
            }
            nums[i]*=nums[i];
        }
        i=end+1;
        k=0;
        while(end!=-1 && i!=nums.length){
            if(nums[i]<=nums[end]){
                arr[k]=nums[i];
                i++;
            }
            else{
                arr[k]=nums[end];
                end--;
            }
            k++;
        }
        for(;i<nums.length;i++){
            arr[k]=nums[i];
            k++;
        }
        for(;end>=0;end--){
            arr[k]=nums[end];
            k++;
        }
        return arr;
    }
}
