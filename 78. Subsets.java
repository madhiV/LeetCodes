class Solution {
    public static List<List<Integer>> ans;
    public void computeSubsets(boolean[] included,int[] nums,int index){
        if(index==nums.length){
            List<Integer> ll=new LinkedList<>();
            for(int i=0;i<nums.length;i++){
                if(included[i]){
                    ll.add(nums[i]);
                }
            }
            ans.add(ll);
            return;
        }
        //Exclude
        computeSubsets(included,nums,index+1);
        //Include
        included[index]=true;
        computeSubsets(included,nums,index+1);
        included[index]=false;
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans=new LinkedList<>();
        computeSubsets(new boolean[nums.length],nums,0);
        return ans;
    }
}
