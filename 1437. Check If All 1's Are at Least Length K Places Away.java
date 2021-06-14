import java.util.*;
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                al.add(i);
            }
        }
        for(int i=1;i<al.size();i++){
            if(al.get(i)-al.get(i-1)<=k){
                return false;
            }
        }
        return true;
    }
}
