class Solution {
    public int getLucky(String s, int k) {
        int t,r,ans=0;
        t=0;
        for(int i=0;i<s.length();i++){
            t=s.charAt(i)-96;
            while(t!=0){
                ans+=t%10;
                t/=10;
            }
        }
        for(int i=1;i<k;i++){
            t=0;
            while(ans!=0){
                t+=ans%10;
                ans/=10;
            }
            ans=t;
        }
        return ans;
    }
}
