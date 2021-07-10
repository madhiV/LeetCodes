class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count=0,LSBB=0,flag=0,flag2=0;
        //LSBB-Last smaller but before bound
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=right && nums[i]>=left){
                count++;
                count+=flag;
                count+=LSBB;
                if(LSBB>0){
                    flag2=LSBB;
                }
                flag++;
            }
            else if(nums[i]<left){
                LSBB++;
                count+=flag+flag2;
            }
            else{
                flag=0;
                flag2=0;
                LSBB=0;
            }
        }
        return count;
    }
}
