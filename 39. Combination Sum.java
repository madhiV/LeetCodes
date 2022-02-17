import java.util.*;
class Solution {
    public List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new LinkedList<>();
        helper(candidates,target,0,new int[candidates.length],0);
        return ans;
    }
    public void helper(int[] candidates,int target,int index,int[] count,int sum){
        if(index==candidates.length){
            return;
        }
        int temp,prevCount;
        for(int i=index;i<candidates.length;i++){
            temp=sum;
            prevCount=count[i];
            while(temp<=target){
                temp+=candidates[i];
                count[i]++;
                if(temp<target){
                    helper(candidates,target,i+1,count,temp);
                    
                }
                else{
                    if(temp==target){
                        addList(candidates,count);
                    }
                    break;
                }
            }
            count[i]=prevCount;
        }
    }
    public void addList(int[] candidates,int[] count){
        List<Integer> l=new LinkedList<>();
        int temp;
        for(int i=0;i<count.length;i++){
            temp=count[i];
            while(temp-->0){
                l.add(candidates[i]);
            }
        }
        ans.add(l);
    }
}
