class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max=0;
        values[0]--;
        for(int i=1;i<values.length;i++){
            max=Math.max(max,values[i]+values[i-1]);
            values[i]=Math.max(values[i],values[i-1])-1;
        }
        return max;
    }
}
