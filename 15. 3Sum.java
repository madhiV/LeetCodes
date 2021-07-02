class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //quickSort(nums,0,nums.length);
        Arrays.sort(nums);
        List<List<Integer>> al=new LinkedList<List<Integer>>();
        List<Integer> li;
        int temp,l,r;
        Set<List<Integer>> set=new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            l=i+1;
            r=nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]==-nums[i]){
                    li=new LinkedList<Integer>();
                    li.add(nums[i]);
                    li.add(nums[l]);
                    li.add(nums[r]);
                    if(!set.contains(li)){
                        al.add(li);
                        set.add(li);
                    }
                    r--;
                }
                else if(nums[l]+nums[r]>-nums[i]){
                    r--;
                }
                else{
                    l++;
                }
            }
        }
        return al;
    }
    void quickSort(int[] nums,int l,int r){
        if(l<r){
            int j=partition(nums,l,r);
            quickSort(nums,l,j);
            quickSort(nums,j+1,r);
        }
    }
    public int partition(int[] nums,int l,int r){
        int i,j,e,temp;
        temp=nums[(l+r)/2+1];
        nums[(l+r)/2+1]=nums[l];
        nums[l]=temp;
        i=l;
        j=r;
        e=nums[l];
        while(i<j){
            do{ 
                i++;
            }while(i<j && nums[i]<=e);
            do{
                j--;
            }while(j>0 && nums[j]>e);
            if(i<j){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        nums[l]=nums[j];
        nums[j]=e;
        return j;
    }
}
