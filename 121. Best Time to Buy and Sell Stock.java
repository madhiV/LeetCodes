class Solution {
    public int maxProfit(int[] prices) {
        int start=0,max=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<prices[start]){
                start=i;
            }
            else{
                max=Math.max(max,prices[i]-prices[start]);
            }
        }
        return max;
    }
}
