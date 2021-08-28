class Solution {
    public int titleToNumber(String columnTitle) {
        int ans,pow;
        ans=pow=0;
        for(int i=columnTitle.length()-1;i>=0;i--){
            ans+=(columnTitle.charAt(i)-64)*((int)Math.pow(26,pow));
            pow++;
        }
        return ans;
    }
}
