import java.util.*;
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll=new LinkedList<>();
        int prev,temp;
        for(int i=0;i<nums.length;i++){
            prev=nums[i];
            while(nums[prev-1]!=prev){
                temp=nums[prev-1];
                nums[prev-1]=prev;
                nums[i]=temp;
                prev=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++){
            temp=i+1;
            if(nums[i]!=temp){
                ll.add(temp);
            }
        }
        return ll;
    }
}
