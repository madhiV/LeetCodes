class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int temp1=0,temp2=0;
        List<Integer> l=new LinkedList<>();
        //Finding count of ones...
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                temp1++;
                nums[i]=0;
            }
            else if(nums[i]==2){
                temp2++;
                nums[i]=0;
            }
        }
        if(temp1==2){
            l.add(1);
        }
        if(temp2==2){
            l.add(2);
        }
        
        //Finding count of other nos...
        for(int i=0;i<nums.length;i++){
            if(nums[i]>2){
                temp1=nums[i];
                nums[i]=0;
                computeCounts(nums,temp1);
            }
        }
        
        //Adding nos. with count of 2...
        for(int i=0;i<nums.length;i++){
            if(nums[i]==2){
                l.add(i+1);
            }
        }
        return l;
    }
    public void computeCounts(int[] nums,int num){
        int temp;
        if(nums[num-1]<2){
            nums[num-1]++;
            return;
        }
        temp=nums[num-1];
        nums[num-1]=1;
        computeCounts(nums,temp);
    }
}
