import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        TreeSet<Integer> set=new TreeSet<Integer>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int max=0,t=1;
        Iterator<Integer> i =set.iterator();
        Integer temp1=i.next(),temp2;
        while(i.hasNext()){
            temp2=i.next();
            if(temp1+1==temp2){
                t++;
            }
            else{
                if(t>max){
                    max=t;
                }
                t=1;
            }
            temp1=temp2;
        }
        if(t>max){
            max=t;
        }
        return max;
    }
}
