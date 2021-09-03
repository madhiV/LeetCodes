class Solution {
    Set<List<Integer>> ans;
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums=nums;
        ans=new HashSet<>();
        computePerm(new HashSet<Integer>(),new ArrayList<Integer>());
        ArrayList<List<Integer>> al=new ArrayList<>();
        for(List<Integer> l:ans){
            al.add(l);
        }
        return al;
    }
    private void computePerm(Set<Integer> set,ArrayList<Integer> al){
        if(set.size()==nums.length){
            List<Integer> l=new ArrayList<>();
            for(int k:al){
                l.add(nums[k]);
            }
            if(set.contains(l)){
                return;
            }
            ans.add(l);
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i)){
                set.add(i);
                al.add(i);
                computePerm(set,al);
                al.remove(al.size()-1);
                set.remove(i);
            }
        }
    }
}
