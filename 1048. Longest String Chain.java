import java.util.HashMap;
import java.util.Map;
class Solution {
    private StringBuilder globalSB;
    public int longestStrChain(String[] words) {
        globalSB=new StringBuilder();
        Arrays.sort(words,(a,b)->b.length()-a.length());
        Map<String,Integer> wordToLength=new HashMap<>();
        fillMap(words,wordToLength);
        for(String word:words){
            processString(word,wordToLength);
        }
        return maxLength(wordToLength);
    }
    private void processString(String word,Map<String,Integer> wordToLength){
        char[] charArray=word.toCharArray();
        for(int ind=0;ind<charArray.length;ind++){
            char prevChar=charArray[ind];
            charArray[ind]='-';
            String genString=formString(charArray);
            if(wordToLength.containsKey(genString)){
                wordToLength.put(genString,Math.max(wordToLength.get(genString),1+wordToLength.get(word)));
            }
            charArray[ind]=prevChar;
        }
    }
    private String formString(char[] charArray){
        globalSB.setLength(0);
        for(char ch:charArray){
            if(ch=='-'){
                continue;
            }
            globalSB.append(ch);
        }
        return globalSB.toString();
    }
    private int maxLength(Map<String,Integer> wordToLength){
        int max=0;
        for(int length:wordToLength.values()){
            max=Math.max(max,length);
        }
        return max;
    }
    private void fillMap(String[] arr,Map<String,Integer> wordToLength){
        for(String k:arr){
            wordToLength.put(k,1);
        }
    }
}
