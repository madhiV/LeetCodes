import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        ArrayList<List<String>> al=new ArrayList<>();
        List<String> l;
        String s;
        for(int i=0;i<strs.length;i++){
            s=sort(strs[i]);
            l=map.getOrDefault(s,new ArrayList<String>());
            l.add(strs[i]);
            map.put(s,l);
        }
        Set<String> set=map.keySet();
        for(String sd:set){
            al.add(map.get(sd));
        }
        return al;
    }
    private String sort(String s){
        StringBuilder sb=new StringBuilder("");
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        for(int i=0;i<26;i++){
            for(int j=0;j<arr[i];j++){
                sb.append((char)97+i);
            }
        }
        return sb.toString();
    }
}
