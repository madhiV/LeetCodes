class Solution {
    public String longestPalindrome(String s) {
        String ans="";
        int max=0,l,r,ansl=0,ansr=0;
        for(int i=0;i<s.length();i++){
            //Odd length
            l=i;
            r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>max){
                    max=r-l+1;
                    ansl=l;
                    ansr=r;
                }
                l--;
                r++;
            }
            //Even length
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1>max){
                    max=r-l+1;
                    ansl=l;
                    ansr=r;
                }
                l--;
                r++;
            }
        }
        return s.substring(ansl,ansr+1);
    }
}
