import java.util.*;
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set=new HashSet<>();
        int count=0;
        for(int i=0;i<brokenLetters.length();i++){
            set.add(brokenLetters.charAt(i));
        }
        for(int i=0;i<text.length();i++){
            if(set.contains(text.charAt(i))){
                while(i<text.length() && text.charAt(i)!=' '){
                    i++;
                }
                continue;
            }
            if(text.charAt(i)==' ' || i==text.length()-1){
                count++;
            }
        }
        return count;
    }
}
