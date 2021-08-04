class Solution {
    Set<LinkedList<Integer>> set;
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> al=new ArrayList<>();
        this.nums=nums;
        set=new HashSet<>();
        compute(0,new LinkedList<Integer>());
        for(List<Integer> l:set){
            al.add(l);
        }
        return al;
    }
    public void compute(int index,LinkedList<Integer> ll){
        if(index==nums.length){
            LinkedList<Integer> l=new LinkedList<>();
            for(int k:ll){
                l.add(k);
            }
            set.add(l);
            return;
        }
        //Without
        for(int i=index+1;i<=nums.length;i++){
            compute(i,ll);
        }
        ll.add(nums[index]);
        for(int i=index+1;i<=nums.length;i++){
            compute(i,ll);
        }
        ll.remove(ll.size()-1);
    }
}
