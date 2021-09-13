class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,sum,j=numbers.length-1;
        while(i<j){
            sum=numbers[i]+numbers[j];
            if(sum==target){
                return new int[]{1+i,1+j};
            }
            if(sum>target){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
