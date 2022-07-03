import java.util.Stack;
class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==1){
            return nums.length;
        }
        Stack<Integer> differences=new Stack<>();
        int i=1;
        while(i<nums.length && nums[i]-nums[i-1]==0){
            i++;
        }
        if(i!=nums.length){
            differences.push(nums[i]-nums[i-1]);
            i++;
        }
        for(;i<nums.length;i++){
            int currDiff=nums[i]-nums[i-1];
            if(currDiff<0){
                if(differences.peek()<0){
                    differences.push(differences.pop()+currDiff);
                }
                else{
                    differences.push(currDiff);
                }
            }
            else if(currDiff>0){
                if(differences.peek()>0){
                    differences.push(differences.pop()+currDiff);
                }
                else{
                    differences.push(currDiff);
                }
            }
        }
        return differences.size()+1;
    }
}
