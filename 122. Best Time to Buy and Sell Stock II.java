class Solution {
    public int maxProfit(int[] prices) {
        int start,end,sum;
        start=end=-1;
        sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                if(start==-1){
                    start=i;
                    end=i+1;
                }
                else{
                    end=i+1;
                }
            }
            else{
                if(start!=-1){
                    sum+=prices[end]-prices[start];
                    start=-1;
                }
            }
        }
        if(start!=-1 && prices[prices.length-1]>prices[start]){
            sum+=prices[prices.length-1]-prices[start];
        }
        return sum;
    }
}
