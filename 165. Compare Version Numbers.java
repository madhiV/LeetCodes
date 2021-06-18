import java.util.*;
class Solution {
    public int compareVersion(String version1, String version2) {
        ArrayList<Integer> v1=new ArrayList<>();
        ArrayList<Integer> v2=new ArrayList<>();
        int i=0;
        StringBuilder t=new StringBuilder("");
        while(i<version1.length()){
            while(i<version1.length() && version1.charAt(i)!='.'){
                t.append(version1.charAt(i));
                i++;
            }
            i++;
            v1.add(Integer.parseInt(t+""));
            t.replace(0,t.length(),"");
        }
        i=0;
        while(i<version2.length()){
            while(i<version2.length() && version2.charAt(i)!='.'){
                t.append(version2.charAt(i));
                i++;
            }
            i++;
            v2.add(Integer.parseInt(t+""));
            t.replace(0,t.length(),"");
        }
        while(v1.size()>v2.size()){
            v2.add(0);
        }
        while(v1.size()<v2.size()){
            v1.add(0);
        }
        for(i=0;i<v1.size();i++){
            if(v1.get(i)==v2.get(i)){
                continue;
            }
            if(v1.get(i)<v2.get(i)){
                return -1;
            }
            else{
                return 1;
            }
        }
        return 0;
    }
}
