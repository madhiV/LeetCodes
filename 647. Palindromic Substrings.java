class Solution {
    public int countSubstrings(String s) {
        int palindromeCount=0;
        for(int index=0;index<s.length();index++){
            int i=index;
            int j=index; 
            //Odd
            while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
                palindromeCount++;
                i--;
                j++;
            }
            //Even
            i=index;
            j=index+1;
            while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
                palindromeCount++;
                i--;
                j++;
            }
        }
        return palindromeCount;
    }
}
