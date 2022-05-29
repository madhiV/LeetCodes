import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
class Solution {
    public int maxProduct(String[] words) {
        List<Set<Character>> charsPresent=new LinkedList<>();
        fillCharacterList(charsPresent,words);
        return maxProduct(charsPresent,words);
    }
    private void fillCharacterList(List<Set<Character>> charsPresent,String[] words){
        for(int ind1=0;ind1<words.length;ind1++){
            Set<Character> currentChars=new HashSet<>();
            for(int ind2=0;ind2<words[ind1].length();ind2++){
                currentChars.add(words[ind1].charAt(ind2));
            }
            charsPresent.add(currentChars);
        }
    }
    private int maxProduct(List<Set<Character>> charsPresent,String[] words){
        int maxProduct=0;
        for(int ind1=0;ind1<words.length;ind1++){
            outer:
            for(int ind2=ind1+1;ind2<words.length;ind2++){
                for(char ch:charsPresent.get(ind2)){
                    if(charsPresent.get(ind1).contains(ch)){
                        continue outer;
                    }
                }
                maxProduct=Math.max(maxProduct,words[ind1].length()*words[ind2].length());
            }
        }
        return maxProduct;
    }
}
