import java.util.*;
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre=strs[0];
        int count=pre.length(),j,match;
        for(int i=1;i<strs.length;i++){
            j=0;
            match=0;
            while(j<strs[i].length() && j<count && strs[i].charAt(j)==pre.charAt(j)){
                match++;
                j++;
            }
            if(match<count){
                count=match;
            }
        }
        return pre.substring(0,count);
    }
}
