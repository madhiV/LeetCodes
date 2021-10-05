class Solution {
    public int maxProfit(int[] prices) {
        int[] pre=new int[prices.length];
        int[] post=new int[prices.length];
        int min=prices[0],max=prices[prices.length-1];
        //Pre
        for(int i=1;i<prices.length;i++){
            pre[i]=Math.max(pre[i-1],prices[i]-min);
            min=Math.min(min,prices[i]);
        } 
        //Post 
        for(int i=prices.length-2;i>=0;i--){
            post[i]=Math.max(post[i+1],max-prices[i]);
            max=Math.max(max,prices[i]);
        }
        max=0;
        for(int i=0;i<prices.length;i++){
            max=Math.max(max,pre[i]+post[i]);
        }
        return max;
    }
}
