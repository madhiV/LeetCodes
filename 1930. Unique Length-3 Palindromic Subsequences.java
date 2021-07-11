import java.util.*;
class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<Character> set;
        int l,r,count=0;
        char c;
        Integer[] right=null,left=null;
        right=new Integer[26];
        left=new Integer[26];
        //Storing leftmost and rightmost positions of each lowercase alphabets in string
        for(int i=0;i<26;i++){
            c=(char)(i+97);
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)==c){
                    if(left[i]==null){
                        left[i]=j;
                    }
                    else{
                        right[i]=j;
                    }
                }
            }
        }
        //finding nemo
        for(int i=0;i<26;i++){
            if(left[i]==null || right[i]==null){
                continue;
            }
            l=left[i]+1;
            r=right[i];
            set=new HashSet<>();
            while(l<r){
                set.add(s.charAt(l));
                l++;
            }
            count+=set.size();
        }
        return count;
    }
}
