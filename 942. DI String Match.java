class Solution {
    public int[] diStringMatch(String s) {
        int[] perm=new int[s.length()+1];
        int l,r;
        l=0;
        r=s.length();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                perm[i]=l;
                l++;
            }
            else{
                perm[i]=r;
                r--;
            }
        }
        perm[s.length()]=l;
        return perm;
    }
}
