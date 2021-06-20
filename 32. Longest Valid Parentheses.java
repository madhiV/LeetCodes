class Solution {
    public int longestValidParentheses(String s) {
        int max=0,st,count;
        int l=s.length();
        for(int i=0;i<l-1;i++){
            if(s.charAt(i)==')'){
                continue;
            }
            count =1;
            st=1;
            for(int j=i+1;j<l;j++){
                if(s.charAt(j)=='('){
                    st++;
                }
                else{
                    st--;
                }
                count++;
                if(st<0){
                    break;
                }
                if(st==0){
                    max=Math.max(count,max);
                }
            }
        }
        return max;
    }
}
