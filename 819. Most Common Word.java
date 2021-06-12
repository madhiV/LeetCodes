import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set=new HashSet<>();
        HashMap<String,Integer> dic=new HashMap<>();
        for(String s:banned){
            set.add(s);
        }
        char c;
        for(String s:paragraph.split(" ")){
            s=s.toLowerCase();
            for(int i=0;i<s.length();i++){
                c=s.charAt(i);
                if(c=='!' || c=='?' || c==39 || c==',' || c==';' || c=='.'){
                    s=s.substring(0,i);
                    break;
                }
            }
            if(set.contains(s)==false){
                if(dic.containsKey(s)){
                    dic.put(s,dic.get(s)+1);
                }
                else{
                    dic.put(s,1);
                }
            }
        }
        int max=0;
        String ans="";
        Set<Map.Entry<String,Integer>> entry=dic.entrySet();
        for(Map.Entry<String,Integer> e:entry){
            if(dic.get(e.getKey())>max){
                max=e.getValue();
                ans=e.getKey();
            }
        }
        return ans;
    }
}
