class Solution {
    public int removePalindromeSub(String s) {
        if(isPallindrome(s)){
            return 1;
        }
        return 2;
    }
    private boolean isPallindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                break;
            }
            i++;
            j--;
        }
        return i>=j;
    }
}
