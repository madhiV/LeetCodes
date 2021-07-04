import java.util.*;
class Solution {
    public int longestPalindrome(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!dic.containsKey(s.charAt(i))){
                dic.put(s.charAt(i),1);
            }
            else{
                dic.put(s.charAt(i),dic.get(s.charAt(i))+1);
            }
        }
        String ans="";
        //Adding 1 character of any odd times present character
        Set<Map.Entry<Character,Integer>> entry=dic.entrySet();
        for(Map.Entry<Character,Integer> k:entry){
            if(k.getValue()%2==1){
                ans=k.getKey()+"";
            }
        }
        for(Map.Entry<Character,Integer> k:entry){
            for(int i=0;i<k.getValue()/2;i++){
                ans+=k.getKey();
                ans=k.getKey()+ans;
            }
        }
        return ans.length();
    }
}
