class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i,j,temp;
        i=0;
        j=nums.length-1;
        
        //Putting even nos. at first half and odd not at other half of nums
        while(i<j){
            while(nums[i]%2==0){
                i++;
            }
            while(nums[j]%2!=0){
                j--;
            }
            if(i<j){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        
        
        //Rearranging to required condition
        i=1;
        j=nums.length-2;
        while(i<j){
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i+=2;
            j-=2;
        }
        return nums;
    }
}
