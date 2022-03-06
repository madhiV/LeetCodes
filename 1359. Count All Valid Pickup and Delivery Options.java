class Solution {
    public Integer[][] dp;
    public int n,mod=1000000007;
    public int countOrders(int n) {
        dp=new Integer[n+1][n+1];
        this.n=n;
        return count(0,0,n);
    }
    public int count(int picked,int delivered,int n){
        if(delivered==this.n){
            return 1;
        }
        if(dp[picked][delivered]!=null){
            return dp[picked][delivered];
        }
        long count=0,temp;
        //Pick...
        if(n>0){
            temp=count(picked+1,delivered,n-1)%mod;
            temp=(temp*n)%mod;
            count=(count+temp)%mod;
        }
        //Deliver...
        if(picked>0){
            temp=count(picked-1,delivered+1,n)%mod;
            temp=(temp*picked)%mod;
            count=(count+temp)%mod;
        }
        dp[picked][delivered]=(int)count;
        return dp[picked][delivered];
    }
}
