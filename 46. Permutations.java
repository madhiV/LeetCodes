import java.util.*;
class Solution {
    List<List<Integer>> al;
    int[] nums;
    Set<Integer> set;
    public List<List<Integer>> permute(int[] nums) {
        set=new HashSet<>();
        this.nums=nums;
        al=new ArrayList<>();
        computePerm(new ArrayList<Integer>());
        return al;
    }
    private void computePerm(ArrayList<Integer> l){
        if(l.size()==nums.length){
            al.add(new ArrayList(l));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!set.contains(i)){
                set.add(i);
                l.add(nums[i]);
                computePerm(l);
                l.remove(l.size()-1);
                set.remove(i);
            }
        }
    }
}
