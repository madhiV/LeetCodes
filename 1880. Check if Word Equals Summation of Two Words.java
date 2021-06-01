import java.util.*;
class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        StringBuilder a=new StringBuilder("");
        StringBuilder b=new StringBuilder("");
        StringBuilder c=new StringBuilder("");
        for(int i=0;i<firstWord.length();i++){
            a.append((int)firstWord.charAt(i)-97);
        }
        for(int i=0;i<secondWord.length();i++){
            b.append((int)(secondWord.charAt(i))-97);
        }
        for(int i=0;i<targetWord.length();i++){
            c.append((int)(targetWord.charAt(i))-97);
        }
        int n;
        n=Integer.parseInt(String.valueOf(a))+Integer.parseInt(String.valueOf(b));
        if(n==Integer.parseInt(String.valueOf(c))){
            return true;
        }
        return false;
    }
}
