class Solution {
    String s;
    Integer[] dp=null;
    public int numDecodings(String s) {
        this.s=s;
        dp=new Integer[s.length()];
        return computeCount(0);
    }
    private int computeCount(int i){
        if(i==s.length()){
            return 1;
        }
        if(s.charAt(i)-48==0){
            return 0;
        }
        if(dp[i]==null){
            int count=0;
            //Single
            count+=computeCount(i+1);
            //Double
            if(i!=s.length()-1 ){
                if(s.charAt(i)-48==1){
                    count+=computeCount(i+2);
                }
                else if (s.charAt(i)-48==2 && s.charAt(i+1)-48<=6 && s.charAt(i+1)-48>=0){
                    count+=computeCount(i+2);
                }
            }
            dp[i]=count;
        }
        return dp[i];
    }
}
