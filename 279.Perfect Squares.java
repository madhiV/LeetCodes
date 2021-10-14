class Solution {
    public int numSquares(int n) {
        if(n==0){
            return 0;
        }
        if(n<4){
            return n;
        }
        int root=(int)(Math.sqrt(n)),ans=n,temp,curr;
        for(int i=root;i>=2;i--){
            temp=i*i;
            curr=n/temp;
            ans=Math.min(ans,numSquares(n-temp*curr)+curr);
        }
        return ans;
    }
}
