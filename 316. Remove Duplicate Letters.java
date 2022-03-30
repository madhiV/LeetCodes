import java.util.*;
class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> st1=new Stack<>();
        char c;
        boolean[] visited=new boolean[26];
        int[] lastIndex=new int[26];
        
        //Finding count of alphabet occurence on the right....
        fillLastIndex(s,lastIndex);
        
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            //Not included already...
            if(!visited[c-97]){
                while(!st1.isEmpty() && st1.peek()>c && lastIndex[st1.peek()-97]>i){
                    visited[st1.peek()-97]=false;
                    st1.pop();
                }
                visited[c-97]=true;
                st1.push(c);
            }
        }
        StringBuilder answerString=new StringBuilder("");
        while(!st1.isEmpty()){
            answerString.insert(0,st1.pop());
        }
        return answerString.toString();
    }
    public void fillLastIndex(String s,int[] lastIndex){
        for(int i=0;i<s.length();i++){
            lastIndex[s.charAt(i)-97]=i;
        }
    }
}
