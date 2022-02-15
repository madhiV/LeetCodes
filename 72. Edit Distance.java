class Solution {
    Integer[][] dp=null;
    public int minDistance(String word1, String word2) {
        dp=new Integer[word1.length()+1][word2.length()+1];
        return res(word1,word2,word1.length()-1,word2.length()-1);
    }
    public int res(String s1,String s2,int m,int n){
        if(m==-1){
            return n+1;
        }
        if(n==-1){
            return m+1;
        }
        if(dp[m][n]!=null){
            return dp[m][n];
        }
        //Characters match...
        if(s1.charAt(m)==s2.charAt(n)){
            dp[m][n]=res(s1,s2,m-1,n-1);
        }
        else{
            //Replace
            dp[m][n]=res(s1,s2,m-1,n-1)+1;
            //Remove , insert ...
            dp[m][n]=Math.min(dp[m][n],1+Math.min(res(s1,s2,m-1,n),res(s1,s2,m,n-1)));
        }
        return dp[m][n];
    }
}
