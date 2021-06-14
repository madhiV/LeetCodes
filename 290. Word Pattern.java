import java.util.*;
class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> dic=new HashMap<>();
        HashSet<String> set=new HashSet<>();
        char c;
        int i=0;
        for(String k:s.split(" ")){
            if(i==pattern.length()){
                return false;
            }
            c=pattern.charAt(i);
            if(dic.containsKey(c)){
                if(dic.get(c).compareTo(k)!=0){
                    return false;
                }
            }
            else{
                if(set.contains(k)){
                    return false;
                }
                dic.put(c,k);
                set.add(k);
            }
            i++;
        }
        if(i!=pattern.length()){
                return false;
            }
        return true;
    }
}
