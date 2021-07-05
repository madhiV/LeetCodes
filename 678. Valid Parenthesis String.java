class Solution {
    Boolean[][] dp=null;
    public boolean checkValidString(String s) {
        dp=new Boolean[s.length()][101];
        return isValid(0,0,s);
    }
    private boolean isValid(int stack,int index,String s){
        if(stack<0){
            return false;
        }
        if(index==s.length()){
            if(stack==0){
                return true;
            }
            return false;
        }
        if(dp[index][stack]==null){
            boolean flag=false;
            if(s.charAt(index)==40){
                flag=isValid(stack+1,index+1,s);
            }
            else if(s.charAt(index)==41){
                flag=isValid(stack-1,index+1,s);
            }
            else if(isValid(stack+1,index+1,s) || isValid(stack-1,index+1,s) || isValid(stack,index+1,s)){
                flag=true;
            }
            dp[index][stack]=flag;
        }
        return dp[index][stack];
    }
}
